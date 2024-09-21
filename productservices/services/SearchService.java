package dev.avinash.productservices.services;


import dev.avinash.productservices.models.Product;
import dev.avinash.productservices.repositories.ProductRepository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> search(String query, int pagenumber, int pagesize) {

        Sort sort = Sort.by("title").ascending();

//        For multiple sorting values
//        List<String> sortvalues = new ArrayList<String>();
//        for (String sortvalue: sortvalues) {
//            sort = Sort.by(sortvalue).ascending();
//        }


        Pageable pageable = PageRequest.of(pagenumber, pagesize, sort);
        return productRepository.findByTitleContaining(query, pageable);

    }
}
