package dev.avinash.productservices.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import java.sql.ClientInfoStatus;

@Entity
@Getter
@Setter
public class Category extends BaseModel {
    private String title;

    public Category() {
        // Default constructor
    }

    @OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE})
    @JsonIgnore
    private List<Product> products;


    public Category(String title) {
        this.title = title;
    }
}
