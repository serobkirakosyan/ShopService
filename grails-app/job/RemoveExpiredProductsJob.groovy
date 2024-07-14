class RemoveExpiredProductsJob {
    static triggers = {
        cron name: 'removeExpiredProductsTrigger', cronExpression: "0 0 0 * * ?"
    }

    ProductService productService

    def execute() {
        productService.removeExpiredProducts()
        println "Expired products removed at ${new Date()}"
    }
}
