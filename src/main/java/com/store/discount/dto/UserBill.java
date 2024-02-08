package com.store.discount.dto;

import java.math.BigDecimal;
import java.util.List;

public class UserBill {
    private String userName;
    private User userCategory;
    private List<Product> productList;
    private BigDecimal billAmount;
    private BigDecimal discountPercentage;
    private BigDecimal payableAmount;

    public UserBill() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(User userCategory) {
        this.userCategory = userCategory;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    @Override
    public String toString() {
        return "UserBill{" +
                "userName='" + userName + '\'' +
                ", userCategory=" + userCategory +
                ", productList=" + productList +
                ", billAmount=" + billAmount +
                ", discountPercentage=" + discountPercentage +
                ", payableAmount=" + payableAmount +
                '}';
    }
}
