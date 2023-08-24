package br.com.sicredi.grpcserver.utils;

import br.com.sicredi.grpcserver.domain.Product;
import br.com.sicredi.grpcserver.dto.ProductInputDTO;
import br.com.sicredi.grpcserver.dto.ProductOutputDTO;

public class ProductConverterUtil {
    public static Product productInputDtoToProduct(ProductInputDTO product) {
        return new Product(
                null,
                product.getName(),
                product.getPrice(),
                product.getQuantityInStock()
        );
    }
    public static ProductOutputDTO productToProductOutputDto(Product product) {
        return new ProductOutputDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantityInStock()
        );
    }
}
