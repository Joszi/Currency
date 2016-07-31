package joachim.parser;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonParser {
	private CurrencyObject obj;

	public String parseJson(String url, Logger logger) {
		try {
			Reader reader = new InputStreamReader(new URL(url).openStream());
			Gson gson = new GsonBuilder().create();
			obj = new CurrencyObject();
			obj = gson.fromJson(reader, CurrencyObject.class);
			logger.debug("From GsonParser: " + obj);
		} catch (Exception e) {
			logger.debug(e);
		}
		return obj.toString();
	}

	public String getTable() {
		return obj.getTable();
	}

	public String getCurrency() {
		return obj.getCurrency();
	}

	public String getCode() {
		return obj.getCode();
	}

	public String getNo() {
		return obj.getNo();
	}

	public String getEffectiveDate() {
		return obj.getEffectiveDate();
	}

	public Double getMid() {
		return obj.getMid();
	}

	private class CurrencyObject {
		private String table;
		private String currency;
		private String code;
		private ArrayList<Rates> rates;

		public String getTable() {
			return table;
		}

		public String getCurrency() {
			return currency;
		}

		public String getCode() {
			return code;
		}

		public String getNo() {
			return rates.get(0).getNo();
		}

		public String getEffectiveDate() {
			return rates.get(0).getEffectiveDate();
		}

		public Double getMid() {
			return rates.get(0).getMid();
		}

		@Override
		public String toString() {
			return "[table=" + table + ", currency=" + currency + ", code=" + code + ", rates=" + rates + "]";
		}
	}

	private class Rates {
		private String no;
		private String effectiveDate;
		private Double mid;

		public String getNo() {
			return no;
		}

		public String getEffectiveDate() {
			return effectiveDate;
		}

		public Double getMid() {
			return mid;
		}

		@Override
		public String toString() {
			return "no=" + no + ", effectiveDate=" + effectiveDate + ", mid=" + mid;
		}
	}
}