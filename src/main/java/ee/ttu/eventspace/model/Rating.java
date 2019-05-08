package ee.ttu.eventspace.model;

import javax.persistence.*;

@Entity
//@Table(uniqueConstraints={
//        @UniqueConstraint(columnNames = {"customer_id", "place_id"})})
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer rating;
    @OneToOne
    private User user;
    @OneToOne
    private Place place;

    public Rating(Integer rating) {
        this.rating = rating; }

    public Rating() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Place getPlace() { return place; }

    public void setPlace(Place place) { this.place = place; }

    public Integer getRating() { return rating; }

    public void setRating(Integer rating) { this.rating = rating; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    @Override
    public String toString() {
        return "Rating{" +
                "place=" + place +
                ", rating=" + rating +
                ", user=" + user +
                '}';
    }
}