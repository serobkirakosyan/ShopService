import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class ProductController {
    ProductService productService

    def createProduct() {
        def requestBody = request.JSON
        if (productService.createProduct(requestBody)) {
            render(status: 200, contentType: 'application/json') {
                message 'Product created successfully'
            }
        } else {
            render status: 500
        }
    }

    def removeProduct() {
        def requestBody = request.JSON
        if (productService.removeProduct(requestBody)) {
            render(status: 200, contentType: 'application/json') {
                message 'Product removed successfully'
            }
        } else {
            render status: 500
        }
    }

    def getProducts() {

        render productService.getProducts() as JSON
    }
}


