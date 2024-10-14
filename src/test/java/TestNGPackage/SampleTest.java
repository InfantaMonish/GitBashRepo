package TestNGPackage;

import org.testng.annotations.Test;

public class SampleTest {
	@Test(priority =0 )	
 public void createContact() 
 {
	 System.out.println("Contact created");
	
}
	@Test(priority =-1)	
	public void modifyContact() {
		System.out.println("Contact Modified");
	}
	@Test(priority =2 )	
	public void deleteContact() {
		System.out.println("Contact Deleted");
	}
}
