package net.developia.spring01.di101;

public class HarmanSpeaker implements Speaker{
	
	@Override
	public void soundUp() {
		System.out.println("하만스피커 : 소리를 키웁니다.");
	}

	@Override
	public void soundDown() {
		System.out.println("하만스피커 : 소리를 줄입니다.");
		
	}

}