package com.server.chbw.controller.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class ProductController {
	
	@RequestMapping("getProduct")
	public String getProduct() {
		System.out.println("66666666666666666666");
		return "index";
	}

}
