package com.mytube;

public class VideoProcessor{

	public void process(Video video, Methods methods) {

		methods.encode(video);

		methods.store(video);

		methods.sendEmail(video.getUser());
	}

}
