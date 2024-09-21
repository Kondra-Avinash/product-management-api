package dev.avinash.productservices.Controllers;

import dev.avinash.productservices.dtos.CreateProductRequestDTO;
import dev.avinash.productservices.models.Categories;
import dev.avinash.productservices.models.Category;
import dev.avinash.productservices.models.Product;
import dev.avinash.productservices.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    ProductService productservice;

    public ProductController(@Qualifier("selfproductservice") ProductService productservice) {

        this.productservice = productservice;
    }

    @PostMapping("/products")
    public Product createproduct(@RequestBody CreateProductRequestDTO productRequestDTO) {
        return productservice.createProduct(
                productRequestDTO.getTitle(),
                productRequestDTO.getDescription(),
                Double.parseDouble(productRequestDTO.getPrice()),
                productRequestDTO.getCategory(),
                productRequestDTO.getImage()
        );
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productservice.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productservice.getSingleProduct(id);

    }

    public void deleteProductBy(Long id) {

    }

    @GetMapping("/categories")
    public List<String> getallcategories() {
        return productservice.getAllCategory();
    }

    @GetMapping("/category/{name}")
    public Categories getcategoriesbyname(@PathVariable("name") String name) {
        return productservice.getcategoriesbyname(name);
    }
}


// @RequestBody is used to convert the requestbody that we are getting from fakestoreapi and
// convert it into CreateProductRequestDTO