package com.company;

import java.util.ArrayList;

public class ProductList {
    ArrayList<Product> products;

    public ProductList(ArrayList<Product> products) {
        this.products = products;
    }

    public ProductList(){
        this.products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void AddProduct(Product product){
        products.add(product);
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "products=" + products +
                '}';
    }
}
