package com.perscholas.unittest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalTime;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class BeforeAfterTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{

		System.out.println("Setting up BeforeAfterTest test class @" + LocalTime.now());
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		System.out.println("Completing BeforeAfterTest test class @ " + LocalTime.now());
	}
	
	@Before
	public void setUp() throws Exception{
		System.out.println("Setting up test method @ " + LocalTime.now());
	}
	
	@After
	public void tearDown() throws Exception{
		System.out.println("Tearing down test method@ " + LocalTime.now());
	}
	
	@Rule public TestName name = new TestName(); //what is rule?
	
	@Test
	public void testOne() {
		System.out.println(name.getMethodName());
		assertTrue(Math.sqrt(25) == 5);
	}
	
	@Test
	public void testTwo() {
		System.out.println(name.getMethodName());
		assertFalse(Math.pow(2, 2) == 5);
	}
}
