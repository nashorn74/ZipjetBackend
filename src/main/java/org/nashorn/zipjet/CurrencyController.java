package org.nashorn.zipjet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/currency")
public class CurrencyController {
	@RequestMapping(method = RequestMethod.GET)
    public Currency getCurrency(@RequestParam(value = "base") String base, 
    		@RequestParam(value = "target") String target,
    		@RequestParam(value = "amount") String amount) {
		Currency currency = ConnectFixer.createCurrencyObject(base, target, amount);
        return currency;
    }
}
