package net.developia.spring01.di202;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVUser {
	public static void main(String[] args) {
//		ApplicationContext context = new GenericXmlApplicationContext(TVUser.class,"beaninit.xml"); //beaninit.xml 필요없어짐 삭제해도됨.
		ApplicationContext context = new AnnotationConfigApplicationContext("net.developia.spring01.di202"); //현재 패키지안에 있는 자바 어노테이션을  찾아온다.
//		TV tv = (TV) context.getBean("samsungTV"); 	// samsungTV를 찾기 -> 2개 이상일 경우 명시적으로 적어야함
//		TV tv = (TV) context.getBean(TV.class); 	// TV 구현체가 있으면 찾아온다. -> SamsungTV, LgTV 둘다 가져옴(No qualifying bean of type 'net.developia.spring01.di201.TV' available: expected single matching bean but found 2: lgTV,samsungTV)
//		TV tv = (TV) context.getBean("tv"); 		// LgTV를 찾기 -> 2개 이상일 경우 명시적으로 적어야함
//		TV tv = (TV) context.getBean(LgTV.class);   // LgTV를 명시적으로 찾기 
		
		TV tv = (TV) context.getBean(SamsungTV.class);   
		
		tv.powerOn();
		tv.channelDown();
		tv.channelDown();
		tv.soundUp();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		

	}
}
