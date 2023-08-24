package br.com.sicredi.grpcserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductOutputDTO {
    private Long id;
    private String name;
    private Double price;
    private Integer quantityInStock;
}
