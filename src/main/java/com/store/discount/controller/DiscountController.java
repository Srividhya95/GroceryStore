package com.store.discount.controller;

import com.store.discount.dto.UserBill;
import com.store.discount.service.DiscountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/store")
public class DiscountController {
    DiscountService discountService = new DiscountService();

    @PostMapping("/discount")
    public ResponseEntity<BigDecimal> getAmount(UserBill userBill) {
        BigDecimal payableAmount = discountService.getPayableAmount(userBill);
        return new ResponseEntity<>(payableAmount, HttpStatus.OK);
    }

}
