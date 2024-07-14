import grails.gorm.transactions.Transactional

@Transactional
class WareHouseInventoryService {

    Boolean addProduct(Product product, WareHouse wareHouse, int count) {

        WareHouseInventory wareHouseInventory = WareHouseInventory.findByWareHouseAndProduct(wareHouse, product)

        if (wareHouseInventory) {
            wareHouseInventory.count += count
            println "Existing WareHouseInventory updated"
        } else {
            wareHouseInventory = new WareHouseInventory(product: product, wareHouse: wareHouse, count: count)
            println "New WareHouse created"

        }
        wareHouseInventory.save(fetch: true)
        return true
    }

    Boolean removeProduct(Product product, WareHouse wareHouse, int count) {

        WareHouseInventory wareHouseInventory = WareHouseInventory.findByWareHouseAndProduct(wareHouse, product)
        if (count <= wareHouseInventory.count) {
            wareHouseInventory.count = wareHouseInventory.count - count
            wareHouseInventory.save(fetch: true)
            return true
        } else {
            println "Not enough product"
            return false
        }
    }
}
