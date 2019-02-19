package ee.ttu.eventspace.model;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Embedded
    private Name name;
    // TODO: Multiple places
    @OneToOne
    private Place rentedOutPlace; // pakkujana
    @OneToOne
    private Place chosenPlace; // rentnikuna
//    @ElementCollection
//    private List<Place> rentedOutPlaces;
//    @ElementCollection
//    private List<Place> chosenPlaces; // rentnikuna

    public User(Name name) {
        this.name = name;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Place getRentedOutPlace() {
        return rentedOutPlace;
    }

    public void setRentedOutPlace(Place rentedOutPlace) {
        this.rentedOutPlace = rentedOutPlace;
    }

    public Place getChosenPlace() {
        return chosenPlace;
    }

    public void setChosenPlace(Place chosenPlace) {
        this.chosenPlace = chosenPlace;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", rentedOutPlace=" + rentedOutPlace +
                ", chosenPlace=" + chosenPlace +
                '}';
    }
}
