import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class ShopController {
    ShopService shopService

    def createShop() {
        def requestBody = request.JSON
        if (shopService.createShop(requestBody)) {
            render(status: 200, contentType: 'application/json') {
                message 'Shop created successfully'
            }
        } else {
            render status: 500
        }
    }

    def sellProduct() {
        def requestBody = request.JSON
        if (shopService.sellProduct(requestBody)) {
            render(status: 200, contentType: 'application/json') {
                message 'Product sold successfully'
            }
        } else {
            render status: 500
        }
    }

    def returnToWareHouse() {
        def requestBody = request.JSON
        if (shopService.returnToWareHouse(requestBody)) {
            render(status: 200, contentType: 'application/json') {
                message 'Product returned successfully'
            }
        } else {
            render status: 500
        }
    }

    def getShops() {

        render shopService.getShops() as JSON
    }

    def getShopInventory() {

        render shopService.getShopInventory() as JSON
    }
}
