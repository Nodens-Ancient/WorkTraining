package com.company;

public class Product {
    private String productName;
    private String productID;
    private String productPrice;
    private String productInStock;

    public Product(String productName, String productID, String productPrice, String productInStock) {
        this.productName = productName;
        this.productID = productID;
        this.productPrice = productPrice;
        this.productInStock = productInStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductInStock() {
        return productInStock;
    }

    public void setProductInStock(String productInStock) {
        this.productInStock = productInStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productID='" + productID + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productInStock='" + productInStock + '\'' +
                '}' + "\n";
    }
}
