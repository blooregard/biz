package us.co.state.sos.licenserequest;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.common.base.Objects;

@ManagedBean
@SessionScoped
public class LicenseRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String line1;
	private String line2;
	private String fein;
	private Date issuedDate;
	private Date expirationDate;
	//private Employee approvedBy;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getFein() {
		return fein;
	}

	public void setFein(String fein) {
		this.fein = fein;
	}
	
	public Date getIssuedDate() {
		return issuedDate;
	}
	
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

//	public Employee getApprovedBy() {
//		return approvedBy;
//	}
//
//	public void setApprovedBy(Employee approvedBy) {
//		this.approvedBy = approvedBy;
//	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof LicenseRequest))
			return false;
		LicenseRequest other = (LicenseRequest) o;
		return Objects.equal(lastName, other.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(lastName);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("lastName", lastName).toString();
	}

}
