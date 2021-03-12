package com.company;

import java.util.ArrayList;

public class ProductList {
    public ArrayList<Product> products;

    public ProductList(ArrayList<Product> products) {
        this.products = products;
    }

    public ProductList(){
        this.products = new ArrayList<>();
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
    public static void RaseAllPrices(ProductList productList, float value){
        for (Product p:
                productList.products) {
            Float price = p.getProductPrice();
            price += value;
            p.setProductPrice(price);
        }
    }
}
