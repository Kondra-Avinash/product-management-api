package dev.avinash.productservices.dtos;


import dev.avinash.productservices.models.Categories;
import dev.avinash.productservices.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCategoryDTO {

    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

    public Categories ToCategory(){
        Categories categories = new Categories();
        categories.setId(getId());
        categories.setTitle(getTitle());
        categories.setPrice(getPrice());
        categories.setCategory(getCategory());
        categories.setDescription(getDescription());
        categories.setImage(getImage());

        return categories;
    }
}
