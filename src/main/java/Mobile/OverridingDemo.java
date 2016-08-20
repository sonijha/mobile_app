package Mobile;

public class OverridingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating Object of SuperClass and calling getModel Method  
        mobile_Encap m = new mobile_Encap("Nokia", "Win8", "Lumia",10000);  
        System.out.println(m.getModel());  
        //Creating Object of Sublcass and calling getModel Method  
        Android_Inheritance a = new Android_Inheritance("Samsung", "Android", "Grand",30000);  
        System.out.println(a.getModel());  
        //Creating Object of Sublcass and calling getModel Method  
        Blackberry_Mobile b = new Blackberry_Mobile("BlackB", "RIM", "Curve",20000);  
        System.out.println(b.getModel()); 

	}

}
