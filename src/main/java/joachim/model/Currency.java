package joachim.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	@Column
	private String name;

	@Column
	private String code;

	@Column
	private String number;

	@Column
	private String date;

	@Column
	private Double mid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getMid() {
		return mid;
	}

	public void setMid(Double mid) {
		this.mid = mid;
	}

	public Currency withId(final Long id) {
		this.id = id;
		return this;
	}

	public Currency withName(final String name) {
		this.name = name;
		return this;
	}

	public Currency withCode(final String code) {
		this.code = code;
		return this;
	}

	public Currency withNumber(final String number) {
		this.number = number;
		return this;
	}

	public Currency withDate(final String date) {
		this.date = date;
		return this;
	}

	public Currency withMid(final Double mid) {
		this.mid = mid;
		return this;
	}

	@Override
	public String toString() {
		return "CurrencyModel [id=" + id + ", name=" + name + ", code=" + code + ", number=" + number + ", date=" + date
				+ ", mid=" + mid + "]";
	}

}