package dev.avinash.productservices.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private String title;
    private String description;
    private double price;
    private String image;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;

    public Product() {
        // Default constructor
    }
}
