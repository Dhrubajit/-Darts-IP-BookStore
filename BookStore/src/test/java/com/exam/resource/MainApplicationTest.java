package com.exam.resource;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.exam.MainApplication;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MainApplicationTest {
	
	@Autowired
	private MainApplication app;
	
	@Test
	public void contextLoads() {
		assertThat(app).isNotNull();
	}

}
