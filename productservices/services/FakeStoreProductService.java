package dev.avinash.productservices.services;

import dev.avinash.productservices.dtos.FakeStoreCategoryDTO;
import dev.avinash.productservices.dtos.FakeStoreProductDTO;
import dev.avinash.productservices.models.Categories;
import dev.avinash.productservices.models.Category;
import dev.avinash.productservices.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("fakestoreservice")
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate
                .getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);

        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImage(fakeStoreProductDTO.getImage());

        Category category = new Category();
        category.setTitle(fakeStoreProductDTO.getTitle());
        product.setCategory(category);

        return product;
    }

    @Override
    public Product createProduct(String title, String description, double price, String category, String image) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setImage(image); // Ensure image is set correctly
        fakeStoreProductDTO.setCategory(category); // Set category as String

        FakeStoreProductDTO response = restTemplate
                .postForObject("https://fakestoreapi.com/products",
                        fakeStoreProductDTO, FakeStoreProductDTO.class );

        return response.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] response = restTemplate
                .getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDTO[].class);
        List<Product> products = new ArrayList<Product>();
        for (FakeStoreProductDTO fakeStoreProductDTO : response) {
            products.add(fakeStoreProductDTO.toProduct());
        }

        return products;
    }

    @Override
    public List<String> getAllCategory(){
        String[] response = restTemplate
                .getForObject("https://fakestoreapi.com/products/categories",
                        String[].class);

        List<Category> categories = new ArrayList<Category>();

        if (response != null){
            return Arrays.asList(response);
        }
        else{
            return new ArrayList<>();
        }


    }

    @Override
    public Categories getcategoriesbyname(String name) {
        // Fetch the list of products for the specified category
        Product[] products = restTemplate
                .getForObject("https://fakestoreapi.com/products/category/" + name, Product[].class);

        // Check if the response is null or empty
        if (products == null || products.length == 0) {
            return null; // Or handle the error as needed
        }

        // For this example, let's return the first product in the category
        Product firstProduct = products[0];
        Categories categories = new Categories();
        categories.setId(firstProduct.getId());
        categories.setTitle(firstProduct.getTitle());
        categories.setPrice(firstProduct.getPrice());
        categories.setCategory(firstProduct.getCategory().getTitle());
        categories.setDescription(firstProduct.getDescription());
        categories.setImage(firstProduct.getImage());

        return categories;


    }
}
