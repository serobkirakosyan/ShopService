class WareHouse {

    String barCode
    String name

    static hasMany = [products: WareHouseInventory]

    static constraints = {
        barCode nullable: false, blank: false
        name nullable: false, blank:false
    }

    static mapping = {
        products cascade: 'all-delete-orphan'
    }
}
