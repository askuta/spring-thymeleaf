package com.epam.thymeleaf.formatter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class TimestampFormatter implements Formatter<Timestamp> {

	private final String pattern = "EEEE dd 'of' MMMM, yyyy, 'at' HH:mm";

	@Override
	public String print(final Timestamp time, final Locale locale) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(time);
	}

	@Override
	public Timestamp parse(final String string, final Locale locale) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = sdf.parse(string);
		return new Timestamp(date.getTime());
	}
}
