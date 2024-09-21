package dev.avinash.productservices.services;

import dev.avinash.productservices.models.Categories;
import dev.avinash.productservices.models.Category;
import dev.avinash.productservices.models.Product;
import dev.avinash.productservices.repositories.CategoryRepository;
import dev.avinash.productservices.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service("selfproductservice")
public class SelfProductService implements ProductService {

    private final CategoryRepository categoryRepository;
    ProductRepository productRepository;
    CategoryRepository CategoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository CategoryRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.CategoryRepository = CategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) {
        return null;
    }

    @Override
    public Product createProduct(String title, String description, double price, String categorytitle, String image) {

        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImage(image);

        Category categoryFromDatabase = categoryRepository.findByTitle(categorytitle);

        if (categoryFromDatabase == null) {
            Category newCategory = new Category();
            newCategory.setTitle(categorytitle);
            categoryFromDatabase = newCategory;
            //categoryFromDatabase = categoryRepository.save(newCategory);
        }

        product.setCategory(categoryFromDatabase);

        return productRepository.save(product);


    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public List<String> getAllCategory() {
        return List.of();
    }

    @Override
    public Categories getcategoriesbyname(String name) {
        return null;
    }
}
