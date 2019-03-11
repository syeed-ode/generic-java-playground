package com.syeedode;

import com.syeedode.interviews.wipro.DemoRomanNumeralConversion;
import org.junit.Assert;
import org.junit.Test;

public class DemoRomanNumberalConversionTests {

	@Test
	public void contextLoads() {
		Assert.assertEquals(11, DemoRomanNumeralConversion.getDecimalResultValue("XI"));
		Assert.assertEquals(9, DemoRomanNumeralConversion.getDecimalResultValue("IX"));
		Assert.assertEquals(21, DemoRomanNumeralConversion.getDecimalResultValue("XXI"));
		Assert.assertEquals(19, DemoRomanNumeralConversion.getDecimalResultValue("XIX"));
		Assert.assertEquals(19, DemoRomanNumeralConversion.getDecimalResultValue("XIX"));
	}

}
