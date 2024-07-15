import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class WareHouseController {

    WareHouseService wareHouseService
    WareHouseInventoryService wareHouseInventoryService

    def createWareHouse() {
        def requestBody = request.JSON
        if (wareHouseService.createWareHouse(requestBody)) {
            render(status: 200, contentType: 'application/json') {
                message 'WareHouse created successfully'
            }
        } else {
            render status: 500
        }
    }

    def addProduct() {
        def requestBody = request.JSON
        if (wareHouseService.addProduct(requestBody)) {
            render(status: 200, contentType: 'application/json') {
                message 'Product added successfully'
            }
        } else {
            render status: 500
        }
    }

    def deliveryToShop() {
        def requestBody = request.JSON
        if (wareHouseService.deliveryToShop(requestBody)) {
            render(status: 200, contentType: 'application/json') {
                message 'Product delivered successfully'
            }
        } else {
            render status: 500
        }
    }

    def removeProduct() {
        def requestBody = request.JSON
        if (wareHouseService.removeProduct(requestBody)) {
            render(status: 200, contentType: 'application/json') {
                message 'Product removed successfully'
            }
        } else {
            render status: 500
        }
    }

    def getWareHouses() {

        render wareHouseService.getWareHouses() as JSON
    }

    def getWareHouseInventory() {

        render wareHouseInventoryService.getWareHouseInventory() as JSON
    }
}
