import grails.gorm.transactions.Transactional

@Transactional
class ShopService {

    ShopInventoryService shopInventoryService
    WareHouseInventoryService wareHouseInventoryService

    Shop createShop(def requestBody) {

        def shop = Shop.findByBarCode(requestBody.shopBarCode)
        if (shop) {
            println "Shop existed"
            return shop
        }
        shop = new Shop(barCode: requestBody.shopBarCode, name: requestBody.shopName, address: requestBody.shopAddress)
        shop.save(fetch: true)
        println "New shop created"
        return shop
    }

    Boolean sellProduct(def requestBody) {
        Product product = Product.findByBarCode(requestBody.productBarCode)
        Shop shop = Shop.findByBarCode(requestBody.shopBarCode)
        if (!product) {
            println "Product can't be null"
            return false
        }
        if (!shop) {
            println "Shop can't be null"
            return false
        }
        if (!shopInventoryService.removeProduct(product, shop, requestBody.count)) {
            return false
        }
        println "Product sold successfully"
        return true
    }

    Boolean returnToWareHouse(def requestBody) {

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
        if (!shopInventoryService.removeProduct(product, shop, requestBody.count)) {
            return false
        }
        wareHouseInventoryService.addProduct(product, wareHouse, requestBody.count)
        println "Product returned successfully"
        return true
    }

    List<Shop> getShops() {
        def shops = Shop.findAll()

        def shopList = []

        shops.each { shop ->
            def shopMap = [
                    name   : shop.name,
                    barCode: shop.barCode
            ]
            shopList.add(shopMap)
        }

        return shopList
    }

    List<Shop> getShopInventory() {
        def shopInventories = ShopInventory.findAll()

        def shopInventoryList = []

        shopInventories.each { shopInventory ->
            def shopInventoryMap = [
                    shopBarCode   : shopInventory.shop.barCode,
                    productBarCode: shopInventory.product.barCode,
                    count         : shopInventory.count
            ]
            shopInventoryList.add(shopInventoryMap)
        }
        return shopInventoryList
    }
}
