package misc;

import org.testng.annotations.Test;

import utils.Configuration;

public class UnitTests {
	@Test
	public void configurationUnitTest() {
		Configuration conf=new Configuration();	
		System.out.println(conf.readProp("browser"));
		
		
	}
	
	@Test
	public void configNumTest() {
		Configuration conf=new Configuration();	
		System.out.println(conf.readPropNum("pageLoad"));
		
		
	}
	

}
