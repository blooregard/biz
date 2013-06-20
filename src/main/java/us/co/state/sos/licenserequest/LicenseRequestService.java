package us.co.state.sos.licenserequest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

	public LicenseRequest load(Long id) {
		LicenseRequest licenseRequest = entityManager.find(LicenseRequest.class, id);
		if (licenseRequest != null)
			System.out.format("Found License for %s accepted\n", licenseRequest.getLastName());
		return licenseRequest;
	}

	public List<LicenseRequest> list() {
		TypedQuery<LicenseRequest> query = entityManager.createQuery("SELECT a from LicenseRequest as a",
				LicenseRequest.class);

		return query.getResultList();
	}

}
