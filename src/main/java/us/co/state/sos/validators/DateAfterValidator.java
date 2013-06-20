package us.co.state.sos.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.joda.time.DateTime;

@FacesValidator(value="dateAfterValidator")
public class DateAfterValidator implements Validator {

	public void validate(FacesContext context,
            UIComponent component,
            Object value) throws ValidatorException {		
		if(!(value instanceof java.util.Date)) {
			throw new ValidatorException(new FacesMessage("Must be a Date Object"));
		}
		
		java.util.Date date = (java.util.Date)value;
		UIComponent target = context.getViewRoot().findComponent("create_license_request_form:issued_date:issued_date");
		
		if (target instanceof UIInput) {
			UIInput issuedDateInput = (UIInput) target;
			Object o = issuedDateInput.getLocalValue();
			if (!(o instanceof java.util.Date)) {
				throw new ValidatorException( new FacesMessage("issueDate not readable"));
			}
			
			java.util.Date other = (java.util.Date)o;
			if((new DateTime(date)).isBefore(new DateTime(other))) {
				throw new ValidatorException( new FacesMessage("Expiration Date is before issued date"));
			}
		}
	}

}
