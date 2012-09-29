package com.property.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="POST_PROPERTY")
public class PostProperty 
{ 
	private long property_id;
	private String email_id;
	private String property_for;
	private String property_type;
	private String transaction;
	private String city;
	//private String locality;
	private String bhk;
	private String furnished;
	private long area;
	private long totalprice;	
	private String negotiation_status;
	private String description;
	private String possession;
	
	          
	public PostProperty()
	{
		
	}
	@Id
	@Column(name="PROPERTY_ID",unique = true)
	public long getProperty_id() {
		return property_id;
	}
	
	public void setProperty_id(long property_id) {
		this.property_id = property_id;
	}

	@Column(name="EMAIL_ID")
	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	@Column(name="PROPERTY_FOR")
	public String getProperty_for() {
		return property_for;
	}

	public void setProperty_for(String property_for) {
		this.property_for = property_for;
	}

	@Column(name="PROPERTY_TYPE")
	public String getProperty_type() {
		return property_type;
	}

	public void setProperty_type(String property_type) {
		this.property_type = property_type;
	}

	@Column(name="TRANSACTION")
	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	@Column(name="CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	/*@Column(name="locality")
	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}*/

	@Column(name="BHK")
	public String getBhk() {
		return bhk;
	}

	public void setBhk(String bhk) {
		this.bhk = bhk;
	}

	 
	@Column(name="FURNISHED")
	public String getFurnished() {
		return furnished;
	}

	public void setFurnished(String furnished) {
		this.furnished = furnished;
	}

	@Column(name="COVERED_AREA")
	public long getArea() {
		return area;
	}

	public void setArea(long area) {
		this.area = area;
	}

	@Column(name="TOTAL_PRICE")
	public long getTotalprice() {
		return totalprice;
	}

	
	public void setTotalprice(long totalprice) {
		this.totalprice = totalprice;
	}

	@Column(name="NEGOTIATION_STATUS")
	public String getNegotiation_status() {
		return negotiation_status;
	}

	public void setNegotiation_status(String negotiation_status) {
		this.negotiation_status = negotiation_status;
	}

	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="POSSESSION_STATUS")
	public String getPossession() {
		return possession;
	}

	public void setPossession(String possession) {
		this.possession = possession;
	}
	
	@Override
	public String toString() {
		return "PostProperty [property_id=" + property_id + ", email_id="
				+ email_id + ", property_for=" + property_for
				+ ", property_type=" + property_type + ", transaction="
				+ transaction + ", city=" + city + ", bhk=" + bhk + ", furnished=" + furnished + ", area="
				+ area + ", totalprice=" + totalprice + ", negotiation_status="
				+ negotiation_status + ", description=" + description
				+ ", possession=" + possession + "]";
	}

	
	
}

	