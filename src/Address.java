
public class Address {
	String street;	
	String apartment;
	String city;
	String state;
	String country;
	String zipcode;
	
	public Address(String street,String apartment,String city,String state,String country,String zipcode){
		this.street = street;
		this.apartment = apartment;
		this.city = city;
		this.state = state;
		this.country = country;	
		this.zipcode = zipcode;
	}
	
	
	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getApartment() {
		return apartment;
	}
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	

}
