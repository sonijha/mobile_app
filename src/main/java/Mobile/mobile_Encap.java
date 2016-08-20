package Mobile;

public class mobile_Encap {
	
	private String Manufacturer;
	private String Operating_System;
	public String model;
	private int Cost;
	public mobile_Encap(String manu, String op, String mo, int c) 
	{
		this.Manufacturer=manu;
		this.Operating_System=op;
		this.model=mo;
		this.Cost=c;
	}
	public String getModel()
	{
		return this.model;
	}

}
