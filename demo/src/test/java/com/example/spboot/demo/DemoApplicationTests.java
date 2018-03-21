package com.example.spboot.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	Log log= LogFactory.getLog(DemoApplicationTests.class);
	@Test
	public void contextLoads() {
		log.info("Spring Boot");
	}

}
