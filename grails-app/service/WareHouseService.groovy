import grails.gorm.transactions.Transactional

@Transactional
class WareHouseService {

    WareHouseInventoryService wareHouseInventoryService
    ShopInventoryService shopInventoryService

    WareHouse createWareHouse(def requestBody) {
        def wareHouse = WareHouse.findByBarCode(requestBody.wareHouseBarCode)
        if (wareHouse) {
            println "WareHouse existed"
            return wareHouse
        }
        wareHouse = new WareHouse(barCode: requestBody.wareHouseBarCode, name: requestBody.wareHouseName)
        wareHouse.save(fetch: true)
        println "WareHouse added successfully"
        return wareHouse
    }

    Boolean removeWareHouse(def requestBody) {
        def wareHouse = WareHouse.findByBarCode(requestBody.wareHouseBarCode)
        if (wareHouse) {
            wareHouse.remove(fetch: true)
            println "WareHouse removed successfully"
            return true
        } else {
            println "WareHouse can't be null"
            return false
        }
    }

    Boolean addProduct(def requestBody) {

        Product product = Product.findByBarCode(requestBody.productBarCode)
        WareHouse wareHouse = WareHouse.findByBarCode(requestBody.wareHouseBarCode)
        if (!product) {
            println "Product can't be null"
            return false
        }
        if (!wareHouse) {
            println "WareHouse can't be null"
            return false
        }
        wareHouseInventoryService.addProduct(product, wareHouse, requestBody.count)
        println "Product added successfully"
        return true
    }

    Boolean deliveryToShop(def requestBody) {

        Product product = Product.findByBarCode(requestBody.productBarCode)
        Shop shop = Shop.findByBarCode(requestBody.shopBarCode)
        WareHouse wareHouse = product.wareHouse
        if (!product) {
            println "Product can't be null"
            return false
        }
        if (!shop) {
            println "Shop can't be null"
            return false
        }
        if (!wareHouseInventoryService.removeProduct(product, wareHouse, requestBody.count)) {
            return false
        }
        shopInventoryService.addProduct(product, shop, requestBody.count)
        println "Product delivered successfully"
        return true
    }

    Boolean removeProduct(def requestBody) {
        def product = Product.findByBarCode(requestBody.productBarCode)
        def wareHouse = product.wareHouse
        if (!product) {
            println "Product can't be null"
            return false
        }
        if (!wareHouse) {
            println "WareHouse can't be null"
            return false
        }
        if (!wareHouseInventoryService.removeProduct(product, wareHouse, requestBody.count)) {
            return false
        }
        println "Product removed successfully"
        return true
    }

    List<WareHouse> getWareHouses() {
        def wareHouses = WareHouse.findAll()

        def wareHouseList = []

        wareHouses.each { wareHouse ->
            def wareHouseMap = [
                    name   : wareHouse.name,
                    barCode: wareHouse.barCode
            ]
            wareHouseList.add(wareHouseMap)
        }
        return wareHouseList
    }
}



