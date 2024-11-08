package net.developia.spring01.di101;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext(TVUser.class,"beaninit.xml");
		// 초기화 시점의 빈 생성 : 호출하기전에 빈을 미리 생성!
//		System.out.println("---------------------------------");
		TV tv = (TV) context.getBean("tv");
		tv.powerOn();
		tv.channelDown();
		tv.channelDown();
		tv.soundUp();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		
		
//		// 싱글톤
//		TV tv2 = (TV) context.getBean("tv");
//		System.out.println(tv.hashCode());
//		System.out.println(tv2.hashCode());
//		
//		// scope="prototype": 싱글톤 아니게 하는 법  + 호출할때마다 빈 생성
//		
//		// lazy-init="true" : 호출할때마다 빈 생성 + 싱글톤
	}
}
