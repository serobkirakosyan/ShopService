
class Product {
    String barCode
    String name
    BigDecimal price
    Date dateOfProduction
    Date expirationDate

    static belongsTo = [wareHouse: WareHouse]
    static hasMany = [shopInventories: ShopInventory, wareHouseInventories: WareHouseInventory]

    static constraints = {
        barCode nullable: false, blank: false
        name nullable: false, blank: false
        price nullable: false, blank: false
        dateOfProduction nullable: false, blank: true
        expirationDate nullable: true, blank: true
    }

    static mapping = {
        shopInventories cascade: 'all-delete-orphan'
        wareHouseInventories cascade: 'all-delete-orphan'
    }
}
