package dev.avinash.productservices.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Categories {

    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;


    public Categories(){

    }

    public Categories(int id, String title, double price, String category, String description, String image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.category = category;
        this.description = description;
        this.image = image;

    }
}
