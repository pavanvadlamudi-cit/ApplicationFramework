package ie.cit.afd.dao;
import java.util.List;

import ie.cit.afd.notification.models.*;

public interface  NotificationTypesRepository {
	void insert(NotificationTypes notificationdetails);
	List<NotificationTypes> getAll();
}
