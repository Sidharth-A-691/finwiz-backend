package com.ust.feign.ifaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ust.feign.model.Product;

@FeignClient(value ="feignclient" , url = "http://localhost:8090/product/api1.0")
public interface ProductFeignIface {

	@GetMapping("/productsinfo")
	public List<Product> getAllProducts();

	@GetMapping(value = "/product/{id}")
	public Product getProductById(@PathVariable long id);
	
	@GetMapping(value = "/products/{brand}")
	public List<Product> getByBrand(@PathVariable String brand);
}
