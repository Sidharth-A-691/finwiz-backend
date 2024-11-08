package com.ust.feign.model;

import org.springframework.aot.generate.GeneratedTypeReference;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Product {     // resource
	
	private long Id;
	private String brand;
	private String description;
	private int qty;
	private int price;
}
