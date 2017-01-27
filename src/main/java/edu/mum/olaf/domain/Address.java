package edu.mum.olaf.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;

@Entity
@Table(name="ADDRESS")
public class Address {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(length = 255, nullable = false)
	@NotEmpty(message="{Address.street.empty}")
	@Size(min=4,max=50,message="{Address.street.size}")
	private String street;

    @Column(length = 16, nullable = false)
	private String zipcode;

    @Column(length = 255, nullable = false)
	private String city;
    @Column 
    private String state;
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Address() {}

	public Address(String street, String zipcode, String city) {
		this.street = street;
		this.zipcode = zipcode;
		this.city = city;
	}
	

	public String getStreet() { return street; }
	public void setStreet(String street) { this.street = street; }

	public String getZipcode() { return zipcode; }
	public void setZipcode(String zipcode) { this.zipcode = zipcode; }

	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }

	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Address)) return false;

		final Address address = (Address) o;

		if (!city.equals(address.city)) return false;
		if (!street.equals(address.street)) return false;
		if (!zipcode.equals(address.zipcode)) return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = street.hashCode();
		result = 29 * result + zipcode.hashCode();
		result = 29 * result + city.hashCode();
		return result;
	}

	public String toString() {
		return  "Street: '" + getStreet() + "', " +
				"Zipcode: '" + getZipcode() + "', " +
				"City: '" + getCity() + "'";
	}

	
}
