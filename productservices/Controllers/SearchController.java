package dev.avinash.productservices.Controllers;

import dev.avinash.productservices.dtos.SearchRequestDTO;
import dev.avinash.productservices.models.Product;
import dev.avinash.productservices.services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/search")
    public Page<Product> search(@RequestBody SearchRequestDTO searchRequestDTO){

        return searchService.search(searchRequestDTO.getQuery(),
                searchRequestDTO.getPagenumber(),
                searchRequestDTO.getPagesize());
    }
}
