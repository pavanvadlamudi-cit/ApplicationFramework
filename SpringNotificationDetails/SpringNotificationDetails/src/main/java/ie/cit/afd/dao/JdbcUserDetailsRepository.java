package ie.cit.afd.dao;

import ie.cit.afd.notification.models.UserDetails;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JdbcUserDetailsRepository implements UserDetailsRepository{
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public JdbcUserDetailsRepository(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public void insert(UserDetails userDetails) {
		jdbcTemplate.update("insert into "
				+ "userdetails"
				+ "(userdetailsid,  username,  password,  organisationdetailsid,  status) "
				+ "values (?,?,?,?,?)",
				userDetails.getUserDetailsID(),
				userDetails.getUsername(),
				userDetails.getPassword(),
				userDetails.getOrganisationDetailsID(),			
				userDetails.isStatus());		
	}
	public void update(UserDetails userDetails) {
		// TODO Auto-generated method stub
		
	}
	public void delete(UserDetails userDetails) {
		// TODO Auto-generated method stub
		
	}
	public List<UserDetails> getAll() {
		return jdbcTemplate.query(
				"select "
				+ "userdetailsid,  username,  password,  organisationdetailsid,  status"
				+ " from userdetails",
				new UserDetailsRowMapper());
		
	}
}
class UserDetailsRowMapper implements RowMapper<UserDetails>{

	public UserDetails mapRow(ResultSet rs, int arg1)
			throws SQLException {
		
		String userDetailsID=rs.getString("userdetailsid");
		String username=rs.getString("username");
		String organisationDetailsID=rs.getString("organisationdetailsid");
		String password=rs.getString("password");
		Boolean status=rs.getBoolean("status");
		
		UserDetails userDetails = new UserDetails();
		userDetails.setUserDetailsID(userDetailsID);
		userDetails.setUsername(username);
		userDetails.setStatus(status);
		userDetails.setOrganisationDetailsID(organisationDetailsID);
		userDetails.setPassword(password);
		
		return userDetails;
	}
}
