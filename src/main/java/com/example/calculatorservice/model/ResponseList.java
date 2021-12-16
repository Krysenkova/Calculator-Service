package com.example.calculatorservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter
@ToString
public class ResponseList {
        List<Product> productList;
        public ResponseList() {

        }
        public ResponseList(List<Product> productList) {
            this.productList = productList;
        }
}
