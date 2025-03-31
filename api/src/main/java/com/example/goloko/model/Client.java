package com.example.goloko.model;

import com.example.goloko.enums.SubscriptionStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.Point;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "coordinates", columnDefinition = "geometry(Point, 4326)")
    private Point coordinates;

    @Enumerated(EnumType.STRING)
    @Column(name="subscription_status")
    private SubscriptionStatus subscriptionStatus;

    public Client(User user, String businessName, Point coordinates, SubscriptionStatus subscriptionStatus){
        this.user=user;
        this.businessName=businessName;
        this.coordinates=coordinates;
        this.subscriptionStatus=subscriptionStatus;
    }

    public Client() {}

    private Client(Builder builder) {
        this.user = builder.user;
        this.businessName = builder.businessName;
        this.coordinates = builder.coordinates;
        this.subscriptionStatus = builder.subscriptionStatus;
    }

    public static class Builder {
        private User user;
        private String businessName;
        private Point coordinates;
        private SubscriptionStatus subscriptionStatus;

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder businessName(String businessName) {
            this.businessName = businessName;
            return this;
        }

        public Builder coordinates(Point coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        public Builder subscriptionStatus(SubscriptionStatus subscriptionStatus) {
            this.subscriptionStatus = subscriptionStatus;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    public SubscriptionStatus getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }
}
