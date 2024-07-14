$(document).ready(function() {

function fetchWareHouses() {
         $.ajax({
             url: '/wareHouse/getWareHouses',
             type: 'GET',
             contentType: 'application/json',
             success: function(response) {
                 var wareHouseList = $('#wareHouses');
                 wareHouseList.empty();
                 response.forEach(function(wareHouse) {
                     wareHouseList.append('<tr><td>' + "Name ->  " + wareHouse.name   + "   BarCode ->  " + wareHouse.barCode + '</td></tr>');
                 });
             },
             error: function(error) {
                 alert('Error fetching WareHouses: ' + error);
             }
         });
     }

 function fetchProducts() {
         $.ajax({
             url: '/product/getProducts',
             type: 'GET',
             contentType: 'application/json',
             success: function(response) {
                 var productList = $('#products');
                 productList.empty();
                 response.forEach(function(product) {
                     productList.append('<tr><td>' + "Name ->  " + product.name  + "   Price ->  " + product.price + "   BarCode ->  " + product.barCode + '</td></tr>');
                 });
             },
             error: function(error) {
                 alert('Error fetching products: ' + error);
             }
         });
     }


     function fetchShops() {
              $.ajax({
                  url: '/shop/getShops',
                  type: 'GET',
                  contentType: 'application/json',
                  success: function(response) {
                      var shopList = $('#shops');
                      shopList.empty();
                      response.forEach(function(shop) {
                          shopList.append('<tr><td>' + "Name ->  " + shop.name   + "   BarCode ->  " + shop.barCode + '</td></tr>');
                      });
                  },
                  error: function(error) {
                      alert('Error fetching Shops: ' + error);
                  }
              });
          }
function fetchWareHouseInventory() {
         $.ajax({
             url: '/wareHouse/getWareHouseInventory',
             type: 'GET',
             contentType: 'application/json',
             success: function(response) {
                 var productList = $('#wareHouseProducts');
                 productList.empty();
                 response.forEach(function(product) {
                     productList.append('<tr><td>' + "ProductBarCode ->  " + product.productBarCode   +
                     "   WareHouseBarCode ->  " + product.wareHouseBarCode +
                     "  Count ->  " + product.count + '</td></tr>');
                 });
             },
             error: function(error) {
                 alert('Error fetching Products: ' + error);
             }
         });
     }

     function fetchShopInventory() {
              $.ajax({
                  url: '/shop/getShopInventory',
                  type: 'GET',
                  contentType: 'application/json',
                  success: function(response) {
                      var productList = $('#shopProducts');
                      productList.empty();
                      response.forEach(function(product) {
                          productList.append('<tr><td>' + "ProductBarCode ->  " + product.productBarCode   +
                          "   ShopBarCode ->  " + product.shopBarCode +
                          "  Count ->  " + product.count + '</td></tr>');
                      });
                  },
                  error: function(error) {
                      alert('Error fetching Products: ' + error);
                  }
              });
          }
    $('#createWareHouseForm').submit(function(event) {
        event.preventDefault();
        var formData = {
            wareHouseBarCode: $('#createdWareHouseBarCode').val(),
            wareHouseName: $('#wareHouseName').val(),
        };
        var jsonData = JSON.stringify(formData);
        $.ajax({
            url: '/wareHouse/createWareHouse',
            type: 'POST',
            contentType: 'application/json',
            data: jsonData,
            success: function(response) {
                fetchWareHouses()
            },
            error: function(error) {
                alert('Error creating warehouse: ' + error);
            }
        });
    });

    $('#createShopForm').submit(function(event) {
        event.preventDefault();
        var formData = {
            shopBarCode: $('#shopBarCode').val(),
            shopName: $('#shopName').val(),
            shopAddress: $('#shopAddress').val()
        };
        var jsonData = JSON.stringify(formData);
        $.ajax({
            url: '/shop/createShop',
            type: 'POST',
            contentType: 'application/json',
            data: jsonData,
            success: function(response) {
                fetchShops();
            },
            error: function(error) {
                alert('Error creating shop: ' + error);
            }
        });
    });

    $('#createProductForm').submit(function(event) {
        event.preventDefault();
        var formData = {
            productBarCode: $('#barCode').val(),
            productName: $('#productName').val(),
            productPrice: $('#productPrice').val(),
            dateOfProduction: $('#productionDate').val(),
            dateOfExpiration: $('#expirationDate').val(),
            wareHouseBarCode: $('#wareHouseBarCode').val(),
            count: +$('#count').val()
        };
        var jsonData = JSON.stringify(formData);
        $.ajax({
            url: '/product/createProduct',
            type: 'POST',
            contentType: 'application/json',
            data: jsonData,
            success: function(response) {
                fetchProducts();
                fetchWareHouseInventory()
            },
            error: function(error) {
                alert('Error creating product: ' + error);
            }
        });
    });

    $('#deliveryProductToShopForm').submit(function(event) {
        event.preventDefault();
        var formData = {
            shopBarCode: $('#deliveryShopBarCode').val(),
            productBarCode: $('#deliveryProductBarCode').val(),
            count: +$('#deliveryCount').val()
        };
        var jsonData = JSON.stringify(formData);
        $.ajax({
            url: '/wareHouse/deliveryToShop',
            type: 'POST',
            contentType: 'application/json',
            data: jsonData,
            success: function(response) {
            fetchWareHouseInventory()
            fetchShopInventory()
            },
            error: function(error) {
                alert('Error delivering product: ' + error);
            }
        });
    });

    $('#returnProductToWareHouseForm').submit(function(event) {
        event.preventDefault();
        var formData = {
            shopBarCode: $('#returnShopBarCode').val(),
            productBarCode: $('#returnProductBarCode').val(),
            count: +$('#returnCount').val()
        };
        var jsonData = JSON.stringify(formData);
        $.ajax({
            url: '/shop/returnToWareHouse',
            type: 'POST',
            contentType: 'application/json',
            data: jsonData,
            success: function(response) {
            fetchWareHouseInventory()
            fetchShopInventory()
            },
            error: function(error) {
                alert('Error returning product: ' + error);
            }
        });
    });
    $('#removeProductFromWareHouse').submit(function(event) {
            event.preventDefault();
            var formData = {
                productBarCode: $('#removeProductBarCode').val(),
                count: +$('#removeCount').val()
            };
            var jsonData = JSON.stringify(formData);
            $.ajax({
                url: '/wareHouse/removeProduct',
                type: 'POST',
                contentType: 'application/json',
                data: jsonData,
                success: function(response) {
                fetchWareHouseInventory()
                },
                error: function(error) {
                    alert('Error removing product: ' + error);
                }
            });
        });

        $('#sellProduct').submit(function(event) {
                    event.preventDefault();
                    var formData = {
                        productBarCode: $('#sellProductBarCode').val(),
                        shopBarCode: $('#sellShopBarCode').val(),
                        count: +$('#sellCount').val()
                    };
                    var jsonData = JSON.stringify(formData);
                    $.ajax({
                        url: '/shop/sellProduct',
                        type: 'POST',
                        contentType: 'application/json',
                        data: jsonData,
                        success: function(response) {
                        fetchShopInventory()
                        },
                        error: function(error) {
                            alert('Error selling product: ' + error);
                        }
                    });
                });

                $('#removeProductForm').submit(function(event) {
                                    event.preventDefault();
                                    var formData = {
                                        productBarCode: $('#barCode').val()
                                        };
                                    var jsonData = JSON.stringify(formData);
                                    $.ajax({
                                        url: '/product/removeProduct',
                                        type: 'POST',
                                        contentType: 'application/json',
                                        data: jsonData,
                                        success: function(response) {
                                        fetchShopInventory();
                                        fetchWareHouseInventory();
                                        fetchProducts()
                                        },
                                        error: function(error) {
                                            alert('Error removing product: ' + error);
                                        }
                                    });
                                });
});
