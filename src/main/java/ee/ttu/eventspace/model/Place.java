package ee.ttu.eventspace.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer maxCapacity;
    private String category;
    private Long[] ratingList;
    private BigDecimal price;
    private String imageURL;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<Booking> bookings;
    @OneToOne
    private User owner;

    public Place(String name, String description, Integer maxCapacity, Address address, String category, Long[] ratingList, BigDecimal price, String imageURL) {
        this.name = name;
        this.description = description;
        this.maxCapacity = maxCapacity;
        this.address = address;
        this.category = category;
        this.ratingList = ratingList;
        this.price = price;
        this.imageURL = imageURL;
    }

    // should be used
    public Place(String name, String description, Integer maxCapacity, Address address, String category, User owner) {
        this.name = name;
        this.description = description;
        this.maxCapacity = maxCapacity;
        this.address = address;
        this.category = category;
        this.owner = owner;
    }

    public Place(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Place() {
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
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

    public BigDecimal getPrice() {return price;}

    public void setPrice(BigDecimal price) {this.price = price;}

    public String getImageURL() { return imageURL; }

    public void setImageURL(String imageURL) { this.imageURL = imageURL; }

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
                ", price=" + price +
                ", imageURL=" + imageURL +
                '}';
    }
}
