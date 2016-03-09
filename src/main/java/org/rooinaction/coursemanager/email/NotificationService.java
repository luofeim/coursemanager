package org.rooinaction.coursemanager.email;

public interface NotificationService {
    public void sendMessage(String mailTo, String message);
}
