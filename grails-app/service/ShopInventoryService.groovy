import grails.gorm.transactions.Transactional

@Transactional
class ShopInventoryService {

    Product addProduct(Product product, Shop shop, int count) {

        ShopInventory shopInventory = ShopInventory.findByShopAndProduct(shop, product)

        if (shopInventory) {
            shopInventory.count += count
            println "Existing ShopInventory updated"
        } else {
            shopInventory = new ShopInventory(product: product, shop: shop, count: count)
            println "New ShopInventory created"
        }

        shopInventory.save(fetch: true)
        return product
    }

    Boolean removeProduct(Product product, Shop shop, int count) {

        ShopInventory shopInventory = ShopInventory.findByShopAndProduct(shop, product)
        if (count <= shopInventory.count) {
            shopInventory.count = shopInventory.count - count
            shopInventory.save(fetch: true)
            println "Product removed successfully"
            return true
        } else {
            println "Not enough product"
            return false
        }
    }
}
