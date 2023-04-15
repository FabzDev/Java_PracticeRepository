package com.mytube;

public class VideoProcessor implements VideoEncoder, VideoDatabase, EmailService {

	@Override
	public void encode(Video video) {
		System.out.println("Encoding video...");
		System.out.println("Done!\n");
	}

	@Override
	public void store(Video video) {
		System.out.println("Storing video metadata in a SQL database...");
		System.out.println("Title: " + video.getTitle());
		System.out.println("File Name: " + video.getFileName());
		System.out.println("Done!\n");
	}

	@Override
	public void sendEmail(User user) {
		System.out.println("Notifying " + user.getEmail() + "...");
		System.out.println("Done!\n");
	}

	public void process(Video video) {

		encode(video);

		store(video);

		sendEmail(video.getUser());
	}

}
