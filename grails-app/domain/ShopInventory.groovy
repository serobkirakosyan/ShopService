class ShopInventory {
    Shop shop
    Product product
    int count

    static belongsTo = [shop: Shop, product: Product]
    static constraints = {
        count nullable: false, blank: false
    }
}
