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
import java.util.List;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String category;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<Booking> bookings;
    @OneToOne
    private User owner;

    public Place(String name, String category, String description, Address address) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.address = address;
    }

    public Place(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    public Place() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", address=" + address +
                ", bookings=" + bookings +
                ", ownerId=" + owner +
                '}';
    }

}
