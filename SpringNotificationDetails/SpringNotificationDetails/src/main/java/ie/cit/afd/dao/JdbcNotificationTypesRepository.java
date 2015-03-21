package ie.cit.afd.dao;

import ie.cit.afd.notification.models.NotificationTypes;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JdbcNotificationTypesRepository implements NotificationTypesRepository{
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public JdbcNotificationTypesRepository(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public void insert(NotificationTypes notificationTypes) {
		jdbcTemplate.update("insert into "
				+ "notificationtypes("
				+ "notificationtypeid,name,code,status) "
				+ "values (?,?,?,?)",
				notificationTypes.getNotificationTypeID(),
				notificationTypes.getName(),
				notificationTypes.getCode(),
				notificationTypes.isStatus());
		
	}
	public void update(NotificationTypes notificationTypes) {
		// TODO Auto-generated method stub
		
	}
	public void delete(NotificationTypes notificationTypes) {
		// TODO Auto-generated method stub
		
	}
	public List<NotificationTypes> getAll() {
		return jdbcTemplate.query(
				"select notificationtypeid,name,code,status"
				+ " from notificationtypes",
				new NotificationTypesRowMapper());
		
	}
}
class NotificationTypesRowMapper implements RowMapper<NotificationTypes>{

	public NotificationTypes mapRow(ResultSet rs, int arg1)
			throws SQLException {
		
		String notificationTypeID=rs.getString("notificationtypeid");
		String name=rs.getString("name");
		String code=rs.getString("code");
		Boolean status=rs.getBoolean("status");
		
		NotificationTypes notificationTypes = new NotificationTypes();
		notificationTypes.setNotificationTypeID(notificationTypeID);
		notificationTypes.setName(name);
		notificationTypes.setStatus(status);
		notificationTypes.setCode(code);
		
		return notificationTypes;
	}
}
