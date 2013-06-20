package us.co.state.sos.licenserequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LicenseRequestService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public String create(LicenseRequest licenseRequest) {
		System.out.format("License for %s accepted\n", licenseRequest.getLastName());
		entityManager.persist(licenseRequest);
		return "Success";
	}
}
