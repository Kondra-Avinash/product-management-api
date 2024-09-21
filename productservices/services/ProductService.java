package dev.avinash.productservices.services;

import dev.avinash.productservices.models.Categories;
import dev.avinash.productservices.models.Category;
import dev.avinash.productservices.models.Product;
import java.util.List;


public interface ProductService {

    public Product getSingleProduct(Long id);

    public Product createProduct(String Title, String Description , double Price
    , String Category, String image);

    public List<Product> getAllProducts();

    public List<String> getAllCategory();

    public Categories getcategoriesbyname(String name);
}
