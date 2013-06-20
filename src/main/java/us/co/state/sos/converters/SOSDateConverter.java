package us.co.state.sos.converters;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

@FacesConverter(value = "sosDateConverter")
public class SOSDateConverter implements Converter {

	public Object getAsObject(FacesContext arg0, UIComponent component, String value) {
		if(value == null || value.equals("")) {
			return null;
		}
		
		List<String> items = Lists.newArrayList(Splitter.on('/').split(value));
		if (items.size() != 3) {
			throw new ConverterException(new FacesMessage("Date is not in recognizable format"));
		}

		String yearString = items.get(2);

		if (yearString.length() < 4) {
			throw new ConverterException(new FacesMessage("Date is not in recognizable format"));
		}

		try {
			DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy");
			DateTime dateTime = dtf.parseDateTime(value);
			return dateTime.toDate();
		} catch (Exception e) {
			throw new ConverterException(new FacesMessage(e.getMessage()));
		}

	}

	public String getAsString(FacesContext arg0, UIComponent component, Object value) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy");
		if (value instanceof java.util.Date) {
			java.util.Date date = (java.util.Date) value;
			return dtf.print((new DateTime(date)));
		}
		return "unknown";
	}

}
