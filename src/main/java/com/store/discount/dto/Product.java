package com.store.discount.dto;

import java.math.BigDecimal;

public class Product {

    private String productName;
    private ProductType productType;
    private BigDecimal productPrice;
    private int itemQty;
    private BigDecimal discount;

    public Product() {
    }
    public Product(String productName, ProductType productType, BigDecimal productPrice, int itemQty, BigDecimal discount) {
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.itemQty = itemQty;
        this.discount = discount;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productType=" + productType +
                ", productPrice=" + productPrice +
                ", itemQty=" + itemQty +
                ", discount=" + discount +
                '}';
    }
}
