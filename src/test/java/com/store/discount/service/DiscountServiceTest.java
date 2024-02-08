package com.store.discount.service;

import com.store.discount.dto.Product;
import com.store.discount.dto.ProductType;
import com.store.discount.dto.User;
import com.store.discount.dto.UserBill;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class DiscountServiceTest {

    @InjectMocks
    DiscountService discountService;

    @Test
    void testForEmployee(){
        UserBill userBill = userBill();
        userBill.setUserCategory(User.EMPLOYEE);
        BigDecimal billDetailsAfterDiscount = discountService.getPayableAmount(userBill);
        BigDecimal payableAmount = BigDecimal.valueOf(210);
        assertEquals(0, payableAmount.compareTo(billDetailsAfterDiscount));
    }

    @Test
    void testForAffiliate(){
        UserBill userBill = userBill();
        userBill.setUserCategory(User.AFFILIATE);
        BigDecimal billDetailsAfterDiscount = discountService.getPayableAmount(userBill);
        BigDecimal payableAmount = BigDecimal.valueOf(370);
        assertEquals(0, payableAmount.compareTo(billDetailsAfterDiscount));
    }

    @Test
    void testForCustomer(){
        UserBill userBill = userBill();
        userBill.setUserCategory(User.OLD_CUSTOMER);
        BigDecimal billDetailsAfterDiscount = discountService.getPayableAmount(userBill);
        BigDecimal payableAmount = BigDecimal.valueOf(790);
        assertEquals(0, payableAmount.compareTo(billDetailsAfterDiscount));
    }

    public UserBill userBill() {
        UserBill userBill = new UserBill();
        userBill.setUserName("XYZ");
        userBill.setUserCategory(User.EMPLOYEE);
        Product p1 = new Product("P1", ProductType.GROCERY, BigDecimal.valueOf(20), 5, BigDecimal.valueOf(0));
        Product p2 = new Product("P2", ProductType.OTHERS, BigDecimal.valueOf(250), 2, BigDecimal.valueOf(0));
        Product p3 = new Product("P3", ProductType.OTHERS, BigDecimal.valueOf(890), 6, BigDecimal.valueOf(0));
        Product p4 = new Product("P4", ProductType.GROCERY, BigDecimal.valueOf(20), 5, BigDecimal.valueOf(0));
        List<Product> productList = Arrays.asList(p1,p2,p3,p4);
        userBill.setProductList(productList);
        userBill.setBillAmount(BigDecimal.valueOf(840));
        return userBill;
    }
}
