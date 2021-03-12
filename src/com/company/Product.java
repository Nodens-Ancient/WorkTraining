package com.company;

public class Product {
    private final String productName;
    private final String productID;
    private Float productPrice;
    private final Integer productInStock;

    public Product(String productName, String productID, float productPrice, int productInStock) {
        this.productName = productName;
        this.productID = productID;
        this.productPrice = productPrice;
        this.productInStock = productInStock;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductID() {
        return productID;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductInStock() {
        return productInStock;
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
