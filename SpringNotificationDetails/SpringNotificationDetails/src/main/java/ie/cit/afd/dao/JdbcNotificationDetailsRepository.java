package ie.cit.afd.dao;

import ie.cit.afd.notification.models.NotificationDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JdbcNotificationDetailsRepository implements NotificationDetailsRepository{
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public JdbcNotificationDetailsRepository(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public void insert(NotificationDetails notificationDetails) {
		jdbcTemplate.update("insert into "
				+ "notificationdetails("
				+ "notificationdetailsid,notificationtypeid,details,status) "
				+ "values (?,?,?,?)",
				notificationDetails.getNotificationDetailsID(),
				notificationDetails.getNotificationTypeID(),
				notificationDetails.getDetails(),
				notificationDetails.isStatus());
		
	}
	public void update(NotificationDetails notificationDetails) {
		// TODO Auto-generated method stub
		
	}
	public void delete(NotificationDetails notificationDetails) {
		// TODO Auto-generated method stub
		
	}
	public List<NotificationDetails> getAll() {
		//may be i need a join
		return jdbcTemplate.query(
				"select notificationdetailsid,notificationtypeid,details,status"
				+ " from notificationdetails",
				new NotificationDetailsRowMapper());
	}
}
class NotificationDetailsRowMapper implements RowMapper<NotificationDetails>{

	public NotificationDetails mapRow(ResultSet rs, int arg1)
			throws SQLException {
		
		String notificationDetailsID=rs.getString("notificationdetailsid");
		String notificationTypeID=rs.getString("notificationtypeid");
		String details=rs.getString("details");
		Boolean status=rs.getBoolean("status");
		
		NotificationDetails notificationDetails = new NotificationDetails();
		notificationDetails.setNotificationDetailsID(notificationDetailsID);
		notificationDetails.setNotificationTypeID(notificationTypeID);
		notificationDetails.setDetails(details);
		notificationDetails.setStatus(status);
		//notificationTypes.setId(id);
		//notificationTypes.setName(name);
		//notificationTypes.setStatus(status);
		
		return notificationDetails;
	}
}
