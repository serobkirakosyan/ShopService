class WareHouseInventory {

    WareHouse wareHouse
    Product product
    int count

    static belongsTo = [wareHouse: WareHouse, product: Product]
    static constraints = {
        count nullable: false, blank: false
    }
}
