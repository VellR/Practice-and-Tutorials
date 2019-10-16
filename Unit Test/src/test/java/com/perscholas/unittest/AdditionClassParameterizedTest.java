package com.perscholas.unittest;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class AdditionClassParameterizedTest {
	
	private static AdditionClass additionClass;
	private double num1 = 0;
	private double num2 = 0;
	private double testSum = 0;
	private Boolean confirmation;
	
	public AdditionClassParameterizedTest(double num1, double num2, double testSum) {
		this.num1 = num1;
		this.num2 = num2;
		this.testSum = testSum;
	}
	
	@Parameters()
	public static Collection<Object[]> data(){
		return Arrays.asList(
				new Object[][] {
					{1,1,2},
					{2,2,4},
					{3,3,6}
				});
				
	}
	
	@BeforeClass
	public static void setUp() {
		additionClass = new AdditionClass();
	}
	
	@Test
	public void additionClassTest() {
		double actual = additionClass.addTwoNumbers(num1, num2);
		
		if(actual == testSum) {
			confirmation = true;
			assertThat(actual, equalTo(testSum));
		}else {
			confirmation = false;
			assertThat(actual, not(equalTo(testSum)));
		}
		
		System.out.printf("%.2f + %.2f = %.2f is %s\n", num1, num2, testSum, Boolean.toString(confirmation));
	}
}
