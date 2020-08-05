package com.epam.thymeleaf.formatter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.epam.thymeleaf.domain.Amount;

@Component
public class AmountFormatter implements Formatter<Amount> {

	private final String pattern = "$ #,##0.00";

	@Override
	public String print(final Amount amount, final Locale locale) {
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(amount.getAmount());
	}

	@Override
	public Amount parse(final String string, final Locale locale) throws ParseException {
		DecimalFormat df = new DecimalFormat(pattern);
		BigDecimal amount = new BigDecimal(df.parse(string).doubleValue());
		return new Amount(amount);
	}
}
