package com.example.calculatorservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Product {
    private Long itemId;
    private String name;
    private String description;
    private String material;
    private String colour;
    private String weight;
    private Long timeOfDelivery;
    private Double priceWithoutVat;
    private Double priceWithVat;

    public Product() {
    }

    /**
     * constructor without id
     */
    public Product(Long itemId, String name, String description, String material, String colour, String weight, Long timeOfDelivery, Double priceWithoutVat, Double priceWithVat) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.material = material;
        this.colour = colour;
        this.weight = weight;
        this.timeOfDelivery = timeOfDelivery;
        this.priceWithoutVat = priceWithoutVat;
        this.priceWithVat = priceWithVat;
    }
}
