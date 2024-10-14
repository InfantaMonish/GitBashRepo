package TestNGPackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	@Test(dataProvider ="dataProviderData")
	public void bookTickets(String src, String dest, int NumOfPpl)
	{
		System.out.println("Book Tickets from"+src+"to"+dest+" "+NumOfPpl);
	}
	@DataProvider
	public Object[][] dataProviderData()
	{
		Object[][] objArr = new Object[2][3];
		objArr[0][0]="Bangalore";
		objArr[0][1]="Chennai";
		objArr[0][2]=2;
		
		
		objArr[1][0]="Bangalore";
		objArr[1][1]="Goa";
		objArr[1][2]=4;
		return objArr;
	}

}
