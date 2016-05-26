package com.travelbest.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travelbest.entity.PaymentSystem;
import com.travelbest.service.PaymentSystemService;

@Controller
@RequestMapping(value = "/api")
public class PaymentSystemRESTController {

	@Autowired
	private PaymentSystemService paymentSystemService;
	
	@RequestMapping(value = "/payment-systems", method = RequestMethod.GET)
	public @ResponseBody List<PaymentSystem> getAllPaymentSystems() {
		return paymentSystemService.findAll();
	}
	
}