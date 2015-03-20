package ie.cit.afd.dao;

import java.util.List;

import ie.cit.afd.notification.models.*;
public interface  OrganisationDetailsRepository {
	void insert(OrganisationDetails organisationdetails);
	void update(OrganisationDetails organisationdetails);
	void delete(OrganisationDetails organisationdetails);
	List<OrganisationDetails> getAll();
}
