package com.mytube;

public class RSXVideoEncoder implements VideoEncoder{

	@Override
	public void encode(Video video) {
		System.out.println("Encoding video with RSXVideoEncoder...");
		System.out.println("RSXVideoEncoder has finished!\n");
	}

}
