package net.developia.spring01.di301;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVUser {
	public static void main(String[] args) {
	
		//자바 클래스로 세터
		ApplicationContext context =
				new AnnotationConfigApplicationContext(BeanInit.class); 
		
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
