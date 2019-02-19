package ee.ttu.eventspace.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String country;
    private String state;
    private String city;
    private String street;
    private String houseNumber;
    private String zipCode;

    public Address(String country, String state, String city, String street, String houseNumber, String zipCode) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
