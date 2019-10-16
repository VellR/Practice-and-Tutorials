package com.perscholas.unittest;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;

import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleClassTest {
	private static SimpleClass simpleClass;
	
	@BeforeClass
	public static void createSimpleClass() {
		simpleClass = new SimpleClass();
	}
	
	@Test
	public void compareTwoObjectsTest() {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		assertNotSame(obj1, obj2);
		
		Object obj3 = obj1;
		assertSame(obj1, obj3);
	}
	
	@Test
	public void listContainsRedBlueTest() {
		assertThat(simpleClass.returnList(), hasItems("red", "blue"));
	}
	
	@Test
	public void listItemsContainETest() {
		assertThat(simpleClass.returnList(), everyItem(containsString("e")));
	}
}
