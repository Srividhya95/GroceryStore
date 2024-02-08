package com.store.discount.service;

import com.store.discount.config.DroolsConfiguration;
import com.store.discount.dto.Product;
import com.store.discount.dto.ProductType;
import com.store.discount.dto.User;
import com.store.discount.dto.UserBill;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class DiscountService {

    DroolsConfiguration droolsConfiguration = new DroolsConfiguration();
    KieContainer kieContainer = droolsConfiguration.kieContainer();
    public void applyDiscount(UserBill userBill) {
        KieSession kieSession = kieContainer.newKieSession();

        try {
            kieSession.insert(userBill);
            kieSession.fireAllRules();
        } finally {
            kieSession.dispose();
        }
    }
        public BigDecimal getPayableAmount(UserBill userBill) {
        for (Product p : userBill.getProductList()) {
            if (p.getProductType().equals(ProductType.GROCERY)) {
                p.setDiscount(BigDecimal.valueOf(0));
            }
        }
        applyDiscount(userBill);
        BigDecimal discountAmount = userBill.getDiscountPercentage().multiply(userBill.getBillAmount());
        BigDecimal payableAmount = userBill.getBillAmount().subtract(discountAmount);
        BigDecimal testDivide = userBill.getBillAmount().divide(BigDecimal.valueOf(100));
        return payableAmount;
    }
}
