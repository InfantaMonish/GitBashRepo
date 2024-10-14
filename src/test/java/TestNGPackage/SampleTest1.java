package TestNGPackage;

import org.testng.annotations.Test;

public class SampleTest1 {
	@Test(priority =1,invocationCount = 2)
 public void createContact() 
 {
	 System.out.println("Contact created");
	
}
	@Test//(enabled=false)	
	public void modifyContact() {
		System.out.println("Contact Modified");
	}
	@Test(dependsOnMethods = "createContact")
	public void deleteContact() {
		System.out.println("Contact Deleted");
	}
}
