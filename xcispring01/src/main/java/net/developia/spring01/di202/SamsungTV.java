package net.developia.spring01.di202;

import org.springframework.stereotype.Component;

//3)어노테이션
@Component //어노테이션 찾아서 빈생성 -> 이름 안쓰면 클래스 이름인 samsungTV로!!
public class SamsungTV implements TV {

	// injection 방법 1)생성자 2)setter 3)어노테이션 4)
	// construct 인젝션
	
	private final Speaker speaker; 

	// 스피커가 반드시 주입되어야 한다!
	// 어노테이션으로 samsungtv 빈 생성 -> 생성자로 주입
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
