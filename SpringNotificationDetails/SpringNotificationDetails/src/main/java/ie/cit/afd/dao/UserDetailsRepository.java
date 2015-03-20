package ie.cit.afd.dao;
import java.util.List;

import ie.cit.afd.notification.models.*;
public interface UserDetailsRepository {
	void insert(UserDetails userdetails);
	void update(UserDetails userdetails);
	void delete(UserDetails userdetails);
	List<UserDetails> getAll();
}
