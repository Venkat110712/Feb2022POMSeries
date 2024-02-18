package qa.com.google.Tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.google.base.BaseTest;

public class GooglePageTest extends BaseTest {
	
	@Test(priority = 1)
	public void googlesearchenable() {		
		
	Assert.assertTrue(gglpg.getenterSerachContext());
	
	}
	@Test(priority = 2)
	public void searchlabeltest () {
	String labelname =  gglpg.getsearchbuttonlabel();
	System.out.println(labelname);
	Assert.assertEquals(labelname,"Google Search");
	
	}
	

}
