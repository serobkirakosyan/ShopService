
class Shop {

    String barCode
    String name
    String address

    static hasMany = [products: Product]
    static constraints = {
        name nullable: false, blank: false
        address nullable: false, blank: false
        barCode nullable: false, blank: false
    }
    static mapping = {
        products cascade: 'all-delete-orphan'
    }
}
