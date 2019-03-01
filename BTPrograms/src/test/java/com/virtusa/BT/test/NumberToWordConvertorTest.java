package com.virtusa.BT.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.virtusa.BT.NumberToWordConvertor;

@RunWith(PowerMockRunner.class)
@PrepareForTest(NumberToWordConvertor.class)
public class NumberToWordConvertorTest {

	@BeforeClass
	public static void setup(){
		PowerMockito.spy(NumberToWordConvertor.class);
	}
	
	@Test
	public void numToWordTest() throws Exception {
		String value=NumberToWordConvertor.numToword(5694781);
		assertEquals("five million six hundred ninety-four thousand seven hundred eighty-one", value);
	}
	
	
	@Test
	public void numToWordRestricttest() throws Exception {
		PowerMockito.doReturn("One Hundred").when(NumberToWordConvertor.class,"numberToWord",any(Integer.class));
		String value=NumberToWordConvertor.numToword(100);
		assertNotNull(value);
		assertEquals(value,"One Hundred");
	}
	
	
	@Test
	public void notNullTest() throws Exception {
		String value=NumberToWordConvertor.numToword(100);
		assertNotNull(value);
	}
	
	@Test
	public void threeDigitnumToWordTest() throws Exception {
		String value=NumberToWordConvertor.numToword(100);
		assertEquals(value, "one hundred ");
	}
	
	
}
