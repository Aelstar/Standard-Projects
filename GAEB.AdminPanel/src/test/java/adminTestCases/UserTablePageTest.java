package adminTestCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

import adminConfig.AdminBase_Setup;

public class UserTablePageTest extends AdminBase_Setup{

	public UserTablePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
public void test9(Method method) {
		
		System.out.println("Test..........."+method.getName());
	}
}
