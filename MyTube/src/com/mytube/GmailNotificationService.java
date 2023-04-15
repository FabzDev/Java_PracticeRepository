package com.mytube;

public class GmailNotificationService implements NotificationService{

	@Override
	public void sendNotification(User user) {
		System.out.println("Notifying via Gmail to " + user.getEmail() + "...");
		System.out.println("Done!\n");
	}

	
}
