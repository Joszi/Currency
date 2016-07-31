package joachim.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import joachim.model.Currency;
import joachim.parser.GsonParser;
import joachim.pdf.GeneratePdf;
import joachim.repository.CurrencyRepository;

@Controller
public class CurrencyController {

	@Autowired
	public CurrencyRepository currencyRepository;

	@RequestMapping("/")
	@ResponseBody
	public String mainPage() {
		return "Hello World";
	}

	@RequestMapping("/db")
	@ResponseBody
	public String testCurrency() {
		Logger logger = Logger.getLogger(CurrencyController.class);
		String url = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=json";
		StringBuilder response = new StringBuilder();

		GsonParser gsonParser = new GsonParser();
		String message = gsonParser.parseJson(url, logger);

		GeneratePdf createPdf = new GeneratePdf();
		createPdf.generatePdf("Joachim_GBP.pdf", url, message, logger);

		Currency currencyModel = new Currency().withId(1L).withName(gsonParser.getCurrency())
				.withCode(gsonParser.getCode()).withNumber(gsonParser.getNo()).withDate(gsonParser.getEffectiveDate())
				.withMid(gsonParser.getMid());
		currencyRepository.save(currencyModel);

		for (Currency i : currencyRepository.findAll()) {
			response.append(i).append("<br>");
		}
		return response.toString();
	}
}