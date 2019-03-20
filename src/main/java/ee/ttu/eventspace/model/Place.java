package ee.ttu.eventspace.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String category;
    private Long[] ratingList;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<Booking> bookings;
    @OneToOne
    private User owner;

    public Place(String name, String description, Address address, String category, Long[] ratingList) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.category = category;
        this.ratingList = ratingList;
    }

    public Place(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Place() {
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Long[] getRatingList() {
        return ratingList;
    }

    public void setRatingList(Long[] ratingList) {
        this.ratingList = ratingList;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", address=" + address +
                ", bookings=" + bookings +
                ", owner=" + owner +
                ", ratingList=" + ratingList +
                '}';
    }
}
