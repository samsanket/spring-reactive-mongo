package com.javatechie.springReactive.dto;

public class ProductDto {



    private  String id;
    private String name;
    private Long quanity;

    private  Double price;

    public ProductDto() {
    }

    public ProductDto(String id, String name, Long quanity, Double price) {
        this.id = id;
        this.name = name;
        this.quanity = quanity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuanity() {
        return quanity;
    }

    public void setQuanity(Long quanity) {
        this.quanity = quanity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
