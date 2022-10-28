package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ProductDTO;
import com.example.repository.ProductRepo;

//@Component

/*@RestController   // rest api controller ( reques/ res)
@Service          // service logics 
@Repository
@ControllerAdvice
@Controller
@Configuration*/

// verifyLoan -- exisitng loan, cbil, local or non-local, business man/ salaries -- user is 

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	/*
	 * static Map<Integer, ProductDTO> list = new HashMap<>(); int count = 100;
	 * static {
	 * 
	 * list.put(90, new ProductDTO(90,"test","test desc","1000",1));
	 * 
	 * }
	 */

	/*
	 * public Integer createProduct(ProductDTO productDTO) {
	 * 
	 * count = count+1; productDTO.setProductId(count);
	 * 
	 * list.put(count, productDTO);
	 * 
	 * 
	 * return productDTO.getProductId(); }
	 */

	public Integer createProduct(ProductDTO productDTO) {
		
		ProductDTO savedProduct = productRepo.save(productDTO);

		return savedProduct.getProductId();
	}

	public List getAllProducts() {
	
		return productRepo.findAll();
	}

	public ProductDTO updateProductInfo(ProductDTO productDTO) {
		
		return productRepo.save(productDTO);
	}

	public String deleteProduct(Integer id) {

		String response;
		
		if(id == null) {
			return "product id is null";
		}
		else {
			productRepo.deleteById(id);
			response = "product is deleted with id : "+id;
		}
		
		return response;
	}

	public List<ProductDTO> searchProductByname(String name) {

		return productRepo.searchByProductName(name);
	}

}
