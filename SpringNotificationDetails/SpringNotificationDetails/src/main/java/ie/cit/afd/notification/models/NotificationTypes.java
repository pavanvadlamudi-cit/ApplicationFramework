package ie.cit.afd.notification.models;

public class NotificationTypes {
	String NotificationTypeID;
	String Name;
	String Code;
	boolean Status;

	public String getNotificationTypeID() {
		return NotificationTypeID;
	}

	public void setNotificationTypeID(String notificationTypeID) {
		NotificationTypeID = notificationTypeID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}
}
