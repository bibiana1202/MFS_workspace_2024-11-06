package net.developia.spring01.di302;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // applicationcontext 가 설정 파일로 인식 = beaninit.xml
public class BeanInit {
	
	//자바 클래스로 생성자 injection
	
	@Bean // 스프링 빈으로 만들어 진다. -> 싱글톤에 미리 만들어짐.
	public TV tv() {
		return new SamsungTV(speaker());
	}
	
	@Bean
	public Speaker speaker() {
		return new HarmanSpeaker();
	}
}
