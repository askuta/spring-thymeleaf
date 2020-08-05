package com.epam.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.epam.thymeleaf.domain.Customer;
import com.epam.thymeleaf.domain.Gender;
import com.epam.thymeleaf.domain.PaymentMethod;

@Controller
public class E09_MoreOnConditionsController {

	@GetMapping("/e09moreonconditions")
	public String getMoreOnConditionsPage(ModelMap model) {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1, "Peter", "Houston", Gender.MALE, PaymentMethod.CREDIT_CARD, 3000, ""));
		customers.add(new Customer(2, "Mary", "Johnson", Gender.FEMALE, PaymentMethod.BANK_TRANSFER, 12000, ""));
		customers.add(new Customer(3, "Andy", "Hoffman", Gender.MALE, PaymentMethod.DIRECT_DEBIT, 35000, ""));
		customers.add(new Customer(4, "Jane", "Jones", null, PaymentMethod.CREDIT_CARD, 3050, ""));
		customers.add(new Customer(5, "Owen", "Houston", Gender.MALE, PaymentMethod.BANK_TRANSFER, 1500, ""));
		customers.add(new Customer(6, "Margaret", "Jackson", Gender.FEMALE, PaymentMethod.DIRECT_DEBIT, 3900, ""));
		customers.add(new Customer(7, "Rafael", "Garcia", null, PaymentMethod.CREDIT_CARD, 5000, ""));

		model.put("customerList", customers);

		return "e09moreonconditions";
	}
}
