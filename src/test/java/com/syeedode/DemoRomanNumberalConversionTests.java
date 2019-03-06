package com.syeedode;

import com.syeedode.wipro.DemoRomanNumeralConversion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

public class AffinityMainClassTests {

	@Test
	public void contextLoads() {
		Assert.assertEquals(11, DemoRomanNumeralConversion.getDecimalResultValue("XI"));
		Assert.assertEquals(9, DemoRomanNumeralConversion.getDecimalResultValue("IX"));
		Assert.assertEquals(21, DemoRomanNumeralConversion.getDecimalResultValue("XXI"));
		Assert.assertEquals(19, DemoRomanNumeralConversion.getDecimalResultValue("XIX"));
	}

}
