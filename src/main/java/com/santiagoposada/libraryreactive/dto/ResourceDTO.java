package com.santiagoposada.libraryreactive.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ResourceDTO {

    private String id;
    private String name;
    private String category;
    private String type;
    private LocalDate lastBorrow;
    private Integer unitsOwed;
    private Integer unitsAvailable;
}
