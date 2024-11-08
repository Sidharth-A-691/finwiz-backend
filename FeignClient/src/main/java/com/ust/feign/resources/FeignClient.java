package com.ust.feign.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.feign.ifaces.ProductFeignIface;
import com.ust.feign.model.Product;

@RestController
@RequestMapping("/client")
public class FeignClient {

	@Autowired
	private ProductFeignIface feignclient;
	
	@GetMapping("/products")
	public List<Product> getAll()
	{
		return feignclient.getAllProducts();
	}
	@GetMapping(value = "/product/{id}")
	public Product getProduct_id(@PathVariable long id)
	{
		return feignclient.getProductById(id);
	}
	@GetMapping(value = "/products/{brand}")
	public List<Product> getProduct_brand(@PathVariable String brand)
	{
		return feignclient.getByBrand(brand);
	}
	
} 


