package com.gqb.eurekaclient.rabbit;

import com.gqb.EurekaClientApplication;
import com.gqb.api.rabbit.sender.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EurekaClientApplication.class})
public class RabbitMqHelloTest {

	@Autowired
	private HelloSender helloSender;

	@Test
	public void hello() throws Exception {
		helloSender.send(null);
	}
	@Test
	public void sendDirectMessage() throws Exception {
		helloSender.sendDirectMessage(null);
	}

}