package net.developia.spring01.di301;

// 4)자바클래스
public class SamsungTV implements TV {

	// injection 방법 1)생성자 2)setter 3)어노테이션 4)자바클래스
	
	private Speaker speaker; 

	//자바 클래스로 세터
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	
	public SamsungTV() {}
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
