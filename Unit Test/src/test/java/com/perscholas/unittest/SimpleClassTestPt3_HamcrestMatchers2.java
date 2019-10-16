package com.perscholas.unittest;

import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.CombinableMatcher.both;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.hamcrest.core.StringStartsWith.startsWith;

import static org.hamcrest.beans.HasProperty.hasProperty;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.hamcrest.number.IsCloseTo.closeTo;

import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.hamcrest.collection.IsMapContaining.hasValue;

import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.object.HasToString.hasToString;

import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleClassTestPt3_HamcrestMatchers2 {
	private static SimpleClass simpleClass;
	
	@BeforeClass
	public static void createSimpleClass() {
		simpleClass = new SimpleClass();
	}
	
	@Test
	public void coreTest() {
		assertThat(simpleClass.returnList().get(0), is("red"));
		assertThat(simpleClass.returnList().get(1), not("red"));
		
		
		//can we add an infinite list of arguments to assertThat?
		assertThat(simpleClass.returnList().get(2), anyOf(equalTo("blue"), containsString("Hello"), is("orange"), startsWith("y")));
		
		assertThat(simpleClass.returnList().get(1), allOf(not("red"), containsString("green"), not(startsWith("b")), startsWith("g")));
		
	}
	
	@Test
	public void returnObjectsTest() {
		Object obj1 = simpleClass.returnNotNull();
		Object obj2 = obj1;
		
		assertThat(obj1, sameInstance(obj2));
		
		obj2 = new Object();
		
		assertThat(obj1, not(sameInstance(obj2)));
		
		assertThat(simpleClass.returnNull(), nullValue());
		assertThat(simpleClass.returnNotNull(), notNullValue());
		
		String s1 = "Hello";
		String s2 = new String("Hello");
		
		assertThat(s1, not(sameInstance(s2)));
		
		assertThat(s1, equalTo(s2));
	}
	
	@Test
	public void toStringTest() {
		assertThat(simpleClass, hasToString(equalTo("This is the custom toString output for SimpleClass.")));
	}
	
	@Test
	public void beanPropertiesTest() {//Why is it called bean?
		SimpleObject obj1 = new SimpleObject();
		
		assertThat(obj1, hasProperty("name"));
		obj1.setName("John");
		
		assertThat(obj1, hasProperty("name", equalTo("John")));
	}
	
	@Test
	public void orderingComparisonTest() {
		
		assertThat(simpleClass.returnOne(), both(greaterThan(0)).and(lessThan(10)));
		assertThat(simpleClass.returnOne(), is(1));
		
		assertThat((double) simpleClass.returnOne(), is(closeTo(1.3, .5)));
	}
	
	@Test
	public void collectionMatchersTest() {
		List<String> colors = simpleClass.returnList();
		
		Map<String, String> officers = simpleClass.returnHashMap();
		
		assertThat(colors, allOf(hasItems("red", "blue"), not(hasItems("orange"))));
		assertThat(colors, anyOf(hasItems("red", "blue"), hasItems("yellow", "cyan")));
		assertThat(colors, both(hasItems("red")).and(hasItems("green"))); //Why .and() instead of chaining commas?
		assertThat(colors, everyItem(is(not("orange"))));
		assertThat(officers,hasEntry("president", "Jane"));
		assertThat(officers, hasKey("treasurer"));
		assertThat(officers, hasValue("James"));
	}
	
	@Test
	public void testMatcherTest() {
		String str1 = "It's a great day!";
		String str2 = "It's a great day!";
		String str3 = "   It's a great day!";
		String str4 = "";
		String str5 = null;
		
		assertThat(str1, equalToIgnoringCase(str2));
		
//		assertThat(str1, equalToCompressingWhiteSpace(str3));
		
		assertThat(str1, startsWith("It's"));
		assertThat(str1, endsWith("ay!"));
		assertThat(str1, containsString("a grea"));
		
//		assertThat(str4, emptyString());
		
//		assertThat(str5, emptyOrNullString());
	}
}
