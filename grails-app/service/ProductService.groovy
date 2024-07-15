import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class ProductService {

    WareHouseService wareHouseService
    ShopService shopService

    Product createProduct(def requestBody) {
        def existingProduct = Product.findByBarCode(requestBody.productBarCode)
        def wareHouse = WareHouse.findByBarCode(requestBody.wareHouseBarCode)
        if (existingProduct) {
            println "Existing product"
            return null
        }
        if (!wareHouse) {
            println "WareHouse can't be null"
            return null
        } else {
            def product = new Product(barCode: requestBody.productBarCode,
                    name: requestBody.productName,
                    price: requestBody.productPrice,
                    dateOfProduction: requestBody.dateOfProduction,
                    expirationDate: requestBody.dateOfExpiration,
                    wareHouse: wareHouse)
            if (product.save(fetch: true)) {
                wareHouseService.addProduct(requestBody)
                println "Product added successfully"
                return product
            } else {
                println "Adding failed"
                return null
            }

        }
    }

    Boolean removeProduct(def requestBody) {
        def product = Product.findByBarCode(requestBody.productBarCode)
        if (!product) {
            println "Product can't be null"
            return false
        }
        product.delete(flush: true)
        println "Product removed successfully"
        return true
    }

    def returnExpiredProducts() {
        def currentDate = new Date()
        def shopInventories = ShopInventory.findAll()
        shopInventories.each { shopInventory ->
            if (shopInventory.product.expirationDate < currentDate) {
                shopService.returnToWareHouse(shopInventory.product, shopInventory.shop, shopInventory.count)
            }
        }
    }

    List<Product> getProducts() {
        def products = Product.findAll()

        def productList = []

        products.each { product ->
            def productMap = [
                    name   : product.name,
                    price  : product.price,
                    barCode: product.barCode
            ]
            productList.add(productMap)
        }
        return productList
    }
}