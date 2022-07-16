package com.example.demo.model;

public class Product {
	
	private Integer prodId;

	private String prodCode;

	private Double prodCost;

	private String prodVendor;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Integer prodId, String prodCode, Double prodCost, String prodVendor) {
		super();
		this.prodId = prodId;
		this.prodCode = prodCode;
		this.prodCost = prodCost;
		this.prodVendor = prodVendor;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public Double getProdCost() {
		return prodCost;
	}

	public void setProdCost(Double prodCost) {
		this.prodCost = prodCost;
	}

	public String getProdVendor() {
		return prodVendor;
	}

	public void setProdVendor(String prodVendor) {
		this.prodVendor = prodVendor;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodCode=" + prodCode + ", prodCost=" + prodCost + ", prodVendor="
				+ prodVendor + "]";
	}

}
