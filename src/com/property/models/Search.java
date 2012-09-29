package com.property.models;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class Search 
{	
	String property_for ;
	String type ;
	String bhk ;
	String city ;
	String minbudget ;
	String maxbudget ;	
	String[] posted_by ;
	String locality ;
	
	public String getProperty_for() {
		return property_for;
	}
	public void setProperty_for(String property_for) {
		this.property_for = property_for;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBhk() {
		return bhk;
	}
	public void setBhk(String bhk) {
		this.bhk = bhk;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public String[] getPosted_by() {
		return posted_by;
	}
	public void setPosted_by(String[] posted_by) {
		this.posted_by = posted_by;
	}
	
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getMinbudget() {
		return minbudget;
	}
	public void setMinbudget(String minbudget) {
		this.minbudget = minbudget;
	}
	public String getMaxbudget() {
		return maxbudget;
	}
	public void setMaxbudget(String maxbudget) {
		this.maxbudget = maxbudget;
	}
	@Override
	public String toString() {
		return "Search [property_for=" + property_for + ", type=" + type
				+ ", bhk=" + bhk + ", city=" + city + ", minbudget="
				+ minbudget + ", maxbudget=" + maxbudget + ", posted_by="
				+ Arrays.toString(posted_by) + ", locality=" + locality + "]";
	}
	
	
		
}
