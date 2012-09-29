package com.property.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POST_REQUIREMENT")
public class PostRequirement 
{ 
	
    private long requirement_id;
	private String email_id;
	private String requirement_for;
	private String property_type;
	private String city;
	private String bhk;
	private long area;
	private String maxbudget;
	private String minbudget;
	
	public PostRequirement()
	{
		
	}
	 
	@Id
	public long getRequirement_id() {
		return requirement_id;
	}

	public void setRequirement_id(long requirement_id) {
		this.requirement_id = requirement_id;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getRequirement_for() {
		return requirement_for;
	}

	public void setRequirement_for(String requirement_for) {
		this.requirement_for = requirement_for;
	}

	public String getProperty_type() {
		return property_type;
	}

	public void setProperty_type(String property_type) {
		this.property_type = property_type;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBhk() {
		return bhk;
	}

	public void setBhk(String bhk) {
		this.bhk = bhk;
	}

	public long getArea() {
		return area;
	}

	public void setArea(long area) {
		this.area = area;
	}

	public String getMaxbudget() {
		return maxbudget;
	}

	public void setMaxbudget(String maxbudget) {
		this.maxbudget = maxbudget;
	}

	public String getMinbudget() {
		return minbudget;
	}

	public void setMinbudget(String minbudget) {
		this.minbudget = minbudget;
	}
	@Override
	public String toString() {
		return "PostRequirement [requirement_id=" + requirement_id
				+ ", email_id=" + email_id + ", requirement_for="
				+ requirement_for + ", property_type=" + property_type
				+ ", city=" + city + ", bhk=" + bhk + ", area=" + area
				+ ", maxbudget=" + maxbudget + ", minbudget=" + minbudget + "]";
	}
	
	
}
