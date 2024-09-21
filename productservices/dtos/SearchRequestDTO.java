package dev.avinash.productservices.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchRequestDTO {

    private String query;
    private int pagenumber;
    private int pagesize;

//    For multiple sorting values
//    private List<String> SortValue;
}
