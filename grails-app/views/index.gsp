<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shop and Warehouse Management</title>
<asset:stylesheet src="style.css"/>
</head>
<body>
<div class="container">
    <h1>Shop and Warehouse Management</h1>

    <!-- Product List Table -->

 <table>
                <thead>
                    <tr>
                        <th>WareHouses</th>

                    </tr>
                </thead>
                <tbody id="wareHouses">
                </tbody>
            </table>

        <table>
                <thead>
                    <tr>
                        <th>Shops</th>

                    </tr>
                </thead>
                <tbody id="shops">
                </tbody>
            </table>
             <table>
                    <thead>
                        <tr>
                            <th>Products</th>

                        </tr>
                    </thead>
                    <tbody id="products">
                    </tbody>
                </table>
                <table>
                    <thead>
                        <tr>
                            <th>WareHouseInventory</th>

                        </tr>
                    </thead>
                    <tbody id="wareHouseProducts">
                    </tbody>
                </table>
                <table>
                    <thead>
                        <tr>
                            <th>ShopInventory</th>

                        </tr>
                    </thead>
                    <tbody id="shopProducts">
                    </tbody>
                </table>
    <!-- Warehouse Management -->
    <section class="management-section" id="warehouseManagement">
        <h2>Warehouse Management</h2>
        <form id="createWareHouseForm">
            <label for="wareHouseName">Warehouse Name:</label>
            <input type="text" id="wareHouseName" name="wareHouseName" required><br>

            <label for="createdWareHouseBarCode">Bar Code</label>
            <input type="text" id="createdWareHouseBarCode" name="createdWareHouseBarCode" required><br>

            <button type="submit">Create Warehouse</button>
        </form>
    </section>

    <!-- Shop Management -->
    <section class="management-section" id="shopManagement">
        <h2>Shop Management</h2>
        <form id="createShopForm">
            <label for="shopName">Shop Name:</label>
            <input type="text" id="shopName" name="shopName" required><br>

            <label for="shopBarCode">BarCode:</label>
            <input type="text" id="shopBarCode" name="shopBarCode" required><br>

            <label for="shopAddress">Address:</label>
            <input type="text" id="shopAddress" name="shopAddress" required><br>

            <button type="submit">Create Shop</button>
        </form>
    </section>

    <!-- Product Management -->
    <section class="management-section" id="productManagement">
        <h2>Product Management</h2>
        <form id="createProductForm">
            <label for="barCode">Bar Code:</label>
            <input type="text" id="barCode" name="barCode" required><br>

            <label for="productName">Product Name:</label>
            <input type="text" id="productName" name="productName" required><br>

            <label for="productPrice">Price:</label>
            <input type="number" id="productPrice" name="productPrice" step="0.01" required><br>

            <label for="productionDate">Date of Production:</label>
            <input type="date" id="productionDate" name="productionDate" required><br>

            <label for="expirationDate">Date of Expiration:</label>
            <input type="date" id="expirationDate" name="expirationDate" ><br>

            <label for="wareHouseBarCode">WareHouse</label>
            <input type="text" id="wareHouseBarCode" name="wareHouseBarCode" required><br>

            <label for="count">Count</label>
            <input type="number" id="count" name="count" required><br>

            <button type="submit">Create Product</button>
        </form>
    </section>

    <!-- Product Management -->
        <section class="management-section" id="productManagement">
            <h2>Remove Product</h2>
            <form id="removeProductForm">
                <label for="barCode">Bar Code:</label>
                <input type="text" id="barCode" name="barCode" required><br>

                <button type="submit">Remove Product</button>
            </form>
        </section>

    <!-- Delivery Management -->
    <h3>Delivery from Warehouse to Shop</h3>
    <form id="deliveryProductToShopForm">
        <label for="deliveryProductBarCode">Product BarCode</label>
        <input type="text" id="deliveryProductBarCode" name="deliveryProductBarCode" required><br>

        <label for="deliveryShopBarCode">Shop BarCode</label>
        <input type="text" id="deliveryShopBarCode" name="deliveryShopBarCode" required><br>

        <label for="deliveryCount">Products Count</label>
        <input type="number" id="deliveryCount" name="deliveryCount" required><br>

        <button type="submit">Delivery</button>
    </form>

    <!-- Return Management -->
    <h3>Return from Shop to WareHouse</h3>
    <form id="returnProductToWareHouseForm">
        <label for="returnProductBarCode">Product BarCode</label>
        <input type="text" id="returnProductBarCode" name="returnProductBarCode" required><br>

        <label for="returnShopBarCode">Shop BarCode</label>
        <input type="text" id="returnShopBarCode" name="returnShopBarCode" required><br>

        <label for="returnCount">Products Count</label>
        <input type="number" id="returnCount" name="returnCount" required><br>

        <button type="submit">Return</button>
    </form>

    <!-- Remove Management -->
        <h3>Remove Product From WareHouse</h3>
        <form id="removeProductFromWareHouse">
            <label for="removeProductBarCode">Product BarCode</label>
            <input type="text" id="removeProductBarCode" name="removeProductBarCode" required><br>

            <label for="removeCount">Products Count</label>
            <input type="number" id="removeCount" name="removeCount" required><br>

            <button type="submit">Remove</button>
        </form>

        <!-- Sell Management -->
                <h3>Sell Product</h3>
                <form id="sellProduct">
                    <label for="sellProductBarCode">Product BarCode</label>
                    <input type="text" id="sellProductBarCode" name="sellProductBarCode" required><br>

                    <label for="sellShopBarCode">Shop BarCode</label>
                    <input type="text" id="sellShopBarCode" name="sellShopBarCode" required><br>

                    <label for="sellCount">Products Count</label>
                    <input type="number" id="sellCount" name="sellCount" required><br>

                    <button type="submit">Sell</button>
                </form>
</div>
<div id="productList"></div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<asset:javascript src="script.js"/>
</body>
</html>
