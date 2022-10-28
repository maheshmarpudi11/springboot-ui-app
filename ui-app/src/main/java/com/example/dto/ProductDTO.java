package com.example.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="T_PRODUCT")
public class ProductDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	@Column(name="P_NAME")
	@NotNull(message = "productname can't be null")
	@NotEmpty(message = " prodctname can't be empty.")
	//@Email,@Size
	//@Pattern(regexp = "", message = "it should match the requirements.")
	private String productName;
	
	private String productDesc;
	private String productCost;
	
	@Min(value = 2, message = "product count can't be less then 2")
	@Max(value = 10, message = "product count can't be greater then 10")
	private Integer productCount;
	
	public ProductDTO() {
	}

	public ProductDTO(Integer productId, String productName, String productDesc, String productCost,
			Integer productCount) {
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productCost = productCost;
		this.productCount = productCount;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductCost() {
		return productCost;
	}
	public void setProductCost(String productCost) {
		this.productCost = productCost;
	}
	public Integer getProductCount() {
		return productCount;
	}
	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}
	
	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", productCost=" + productCost + ", productCount=" + productCount + "]";
	}
	
	
}
