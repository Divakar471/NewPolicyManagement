package com.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AddPolicy {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private float premium;
	private String customer_name;
	private String customer_address;
	private String policy_term;
	private String policy_effective_date;
	private String policy_product;
	private String policy_amount;
	private String agency_code;
	private String policy_type;
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public String getPolicy_term() {
		return policy_term;
	}
	public void setPolicy_term(String policy_term) {
		this.policy_term = policy_term;
	}
	public String getPolicy_effective_date() {
		return policy_effective_date;
	}
	public void setPolicy_effective_date(String policy_effective_date) {
		this.policy_effective_date = policy_effective_date;
	}
	public String getPolicy_product() {
		return policy_product;
	}
	public void setPolicy_product(String policy_product) {
		this.policy_product = policy_product;
	}
	public String getPolicy_amount() {
		return policy_amount;
	}
	public void setPolicy_amount(String policy_amount) {
		this.policy_amount = policy_amount;
	}
	public String getAgency_code() {
		return agency_code;
	}
	public void setAgency_code(String agency_code) {
		this.agency_code = agency_code;
	}
	public String getPolicy_type() {
		return policy_type;
	}
	public void setPolicy_type(String policy_type) {
		this.policy_type = policy_type;
	}
	public float getPremium() {
		return premium;
	}
	public void setPremium(float premium) {
		this.premium = premium;
	}
	@Override
	public String toString() {
		return "AddPolicy [id=" + id + ", customer_name=" + customer_name + ", customer_address=" + customer_address
				+ ", policy_term=" + policy_term + ", policy_effective_date=" + policy_effective_date
				+ ", policy_product=" + policy_product + ", policy_amount=" + policy_amount + ", agency_code="
				+ agency_code + ", policy_type=" + policy_type + "]";
	}
	
}
	