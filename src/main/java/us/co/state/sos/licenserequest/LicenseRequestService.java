package us.co.state.sos.licenserequest;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LicenseRequestService {
	public String create(LicenseRequest licenseRequest) {
		System.out.format("License for %s accepted\n", licenseRequest.getLastName());
		return "Success";
	}
}
