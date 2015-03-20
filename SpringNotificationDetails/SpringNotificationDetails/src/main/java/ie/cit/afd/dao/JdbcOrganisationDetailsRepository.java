package ie.cit.afd.dao;

import ie.cit.afd.notification.models.OrganisationDetails;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JdbcOrganisationDetailsRepository implements OrganisationDetailsRepository{
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public JdbcOrganisationDetailsRepository(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public void insert(OrganisationDetails organisationDetails) {
		// TODO Auto-generated method stub
		
	}
	public void update(OrganisationDetails organisationDetails) {
		// TODO Auto-generated method stub
		
	}
	public void delete(OrganisationDetails organisationDetails) {
		// TODO Auto-generated method stub
		
	}
	public List<OrganisationDetails> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
class OrganisationDetailsRowMapper implements RowMapper<OrganisationDetails>{

	public OrganisationDetails mapRow(ResultSet rs, int arg1)
			throws SQLException {
		
		//String id=rs.getString("id");
		//String name=rs.getString("name");
		//Boolean status=rs.getBoolean("status");
		
		OrganisationDetails organisationDetails = new OrganisationDetails();
		//notificationTypes.setId(id);
		//notificationTypes.setName(name);
		//notificationTypes.setStatus(status);
		
		return organisationDetails;
	}
}

