package adminTestCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

import adminConfig.AdminBase_Setup;

public class EditUserPageTest extends AdminBase_Setup{

	public EditUserPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Test
public void test5(Method method) {
		
		System.out.println("Test..........."+method.getName());
	}
}
