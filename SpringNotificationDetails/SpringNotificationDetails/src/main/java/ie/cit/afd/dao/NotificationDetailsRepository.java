package ie.cit.afd.dao;
import java.util.List;
import ie.cit.afd.notification.models.*;
public interface NotificationDetailsRepository {
	void insert(NotificationDetails notificationdetails);
	List<NotificationDetails> getAll();
}
