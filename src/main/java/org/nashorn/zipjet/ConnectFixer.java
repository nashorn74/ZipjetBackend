package org.nashorn.zipjet;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ConnectFixer {
	private static final String REG_EXP_STR = "[A-Z]{3}";
	private static final String DOUBLE_REG_EXP_STR = "\\d*(\\.?\\d*)";
	private static final String FIXER_URL = "https://api.fixer.io/latest";
	
	public static Currency createCurrencyObject(String base, String target, String amount) {
		Currency currency = new Currency("", 0.0, "", 0.0);
		if (base.matches(REG_EXP_STR) && target.matches(REG_EXP_STR) && !base.equals(target) &&
			amount.length() > 0 && amount.matches(DOUBLE_REG_EXP_STR)) {
			System.out.println("right");
			currency = connectFixer(base, target, Double.parseDouble(amount));			
		} else {
			System.out.println("wrong");
			currency.setErrorCode(1);
		}
		return currency;
	}
	private static Currency connectFixer(String base, String target, Double amount) {
		Currency currency = new Currency("", 0.0, "", 0.0);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(
				FIXER_URL+"?base="+base+"&symbols="+target, String.class);
		System.out.println(response.getBody());
		try {
			JSONObject object = new JSONObject(response.getBody());
			JSONObject rates = object.getJSONObject("rates");
			Double currencyRates = rates.getDouble(target);
			currency = new Currency(base, amount, target, currencyRates*amount);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			currency.setErrorCode(2);
		}
		return currency;
	}
}
