package com.example.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_tab")
public class Product {
	@Id
	@Column(name = "prod_id")
	private Integer prodId;

	@Column(name = "prod_code")
	private String prodCode;

	@Column(name = "prod_cost")
	private Double prodCost;

	@Column(name = "prod_vendor")
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
