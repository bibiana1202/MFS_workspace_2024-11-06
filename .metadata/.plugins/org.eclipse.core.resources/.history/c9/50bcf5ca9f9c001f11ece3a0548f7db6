package net.developia.spring01.di102;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext(TVUser.class,"beaninit.xml");
		TV tv = (TV) context.getBean("tv");
		tv.powerOn();
		tv.channelDown();
		tv.channelDown();
		tv.soundUp();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		

	}
}
