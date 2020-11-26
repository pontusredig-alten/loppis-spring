package se.iths.loppis.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    private String category;
    private int quantity;
    private double price;
    private LocalDate createdAt;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "item_user")
    private User user;



    public Item(@NotEmpty String name, String category, int quantity, double price) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public Item() {

    }

    @PrePersist
    private void getCurrentDate() {
        setCreatedAt(LocalDate.now());
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
