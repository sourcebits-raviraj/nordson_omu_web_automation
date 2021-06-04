package com.nordson.MDS;

public class MDSGetterandSetters_Temperature {
	
	// Declaration of Temperature MDS variables to set and get the Values
	private static String prmryunt = "";
	private static String default1="";
	private static String min1 = "";
	private static String max1 = "";
	
	private static String scndryunt = "";
	private static String default2="";
	private static String min2 = "";
	private static String max2 = "";
	
	//Methods to set and get the values of MDS temperature file
	public String getPrmryunt() {

		return prmryunt;
	}
	public void setPrmryunt(String prmryunt) {
		this.prmryunt = prmryunt;
	}
	public String getDefault1() {
		return default1;
	}
	public void setDefault1(String default1) {
		this.default1 = default1;
	}
	public String getMin1() {
		return min1;
	}
	public void setMin1(String min1) {
		this.min1 = min1;
	}
	public String getMax1() {
		return max1;
	}
	public void setMax1(String max1) {
		this.max1 = max1;
	}
	public String getScndryunt() {
		return scndryunt;
	}
	public void setScndryunt(String scndryunt) {
		this.scndryunt = scndryunt;
	}
	public String getDefault2() {
		return default2;
	}
	public void setDefault2(String default2) {
		this.default2 = default2;
	}
	public String getMin2() {
		return min2;
	}
	public void setMin2(String min2) {
		this.min2 = min2;
	}
	public String getMax2() {
		return max2;
	}
	public void setMax2(String max2) {
		this.max2 = max2;
	}	

}
