package net.developia.spring01.di301;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 자바 어노테이션
@Configuration // applicationcontext 가 설정 파일로 인식 = beaninit.xml
public class BeanInit {

	
	/* 
		<bean name ="speaker" class="net.developia.spring01.di101.OrangeSpeaker"/>
	
		<bean name = "tv" class ="net.developia.spring01.di101.SamsungTV">
			<property name="speaker"  ref="speaker"></property>  <!-- name: setSpeaker를 의미 -->
		</bean> 
	 */
	
	@Bean
	public TV tv() {
		SamsungTV tv =  new SamsungTV();
		tv.setSpeaker(speaker());
		return tv;
	}
	
	//자바 클래스로 세터
	@Bean
	public Speaker speaker() {
		return new HarmanSpeaker();
	}
}
