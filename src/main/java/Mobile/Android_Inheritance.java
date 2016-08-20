package Mobile;

public class Android_Inheritance extends mobile_Encap {

	public Android_Inheritance(String manu, String op, String mo, int c) {
		super(manu, op, mo, c);
		
	}
	public String getModel()
	{
		return "This is Android Mobile- " + model;
	}
	

}
