<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simple Shopping Website</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Simple Shopping Website</h1>
        <div class="products">
            <div class="product" id="product1">
                <h3>Product 1</h3>
                <p>Description: Lorem ipsum dolor sit amet.</p>
                <p>Price: $10</p>
                <button class="add-to-cart">Add to Cart</button>
            </div>
            <div class="product" id="product2">
                <h3>Product 2</h3>
                <p>Description: Consectetur adipiscing elit.</p>
                <p>Price: $15</p>
                <button class="add-to-cart">Add to Cart</button>
            </div>
        </div>
        <h2>Shopping Cart</h2>
        <ul id="cart">
            <!-- Cart items will be added dynamically using JavaScript -->
        </ul>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="script.js"></script>
</body>
</html>
