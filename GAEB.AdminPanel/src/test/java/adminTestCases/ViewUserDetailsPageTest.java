package adminTestCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

import adminConfig.AdminBase_Setup;

public class ViewUserDetailsPageTest extends AdminBase_Setup{

	public ViewUserDetailsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
public void test8(Method method) {
		
		System.out.println("Test..........."+method.getName());
	}
	
}
