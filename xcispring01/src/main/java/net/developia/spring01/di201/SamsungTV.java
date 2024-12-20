package net.developia.spring01.di201;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//3)어노테이션
@Component //어노테이션 찾아서 빈생성 -> 이름 안쓰면 클래스 이름인 samsungTV로!!
public class SamsungTV implements TV {

	// injection 방법 1)생성자 2)setter 3)어노테이션
	
	// setter 인젝션
	@Autowired // 삼성 티비의 스피커 타입에 스피커를 주입
	@Qualifier(value = "mspeaker") //명시적 지정 하기 !! 
	private Speaker speaker; 

	public SamsungTV() {
		
	}

	public SamsungTV(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void powerOn() {
		System.out.println("SamsungTV>TV를 켭니다.");
	}
	public void powerOff(){
		System.out.println("SamsungTV>TV를 끕니다.");
	}
	public void channelUp(){
		System.out.println("SamsungTV>채널을 올립니다.");
	}
	public void channelDown(){
		System.out.println("SamsungTV>채널을 내립니다.");
	}
	public void soundUp(){
		if(speaker == null) {
			System.out.println("SamsungTV>소리를 키웁니다.");			
		}
		else {
			speaker.soundUp();
		}
	}
	public void soundDown(){
		if(speaker == null) {
			System.out.println("SamsungTV>소리를 줄입니다.");			
		}
		else {
			speaker.soundDown();
		}
	}
}
