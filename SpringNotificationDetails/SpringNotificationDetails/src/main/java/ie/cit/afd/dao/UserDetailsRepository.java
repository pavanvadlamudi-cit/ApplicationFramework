package ie.cit.afd.dao;
import java.util.List;

import ie.cit.afd.notification.models.*;
public interface UserDetailsRepository {
	void insert(UserDetails notificationdetails);
	List<UserDetails> getAll();
}
