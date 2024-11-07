package net.developia.spring01.di301;

public class MarshallSpeaker implements Speaker {

	@Override
	public void soundUp() {
		System.out.println("하만스피커 : 소리를 키웁니다.");		
	}

	@Override
	public void soundDown() {
		System.out.println("하만스피커 : 소리를 낮춥니다.");		
		
	}

}
