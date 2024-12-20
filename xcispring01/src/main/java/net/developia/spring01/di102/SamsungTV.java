package net.developia.spring01.di102;

public class SamsungTV implements TV {

	// injection 방법 1)생성자 2)setter
	private final Speaker speaker; // final 처리! = 값이 변하지 않으면 꼭!

	// 1) 생성자
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
