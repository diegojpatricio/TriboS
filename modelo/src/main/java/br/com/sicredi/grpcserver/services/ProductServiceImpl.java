package br.com.sicredi.grpcserver.services;

import br.com.sicredi.grpcserver.domain.Product;
import br.com.sicredi.grpcserver.dto.ProductInputDTO;
import br.com.sicredi.grpcserver.dto.ProductOutputDTO;
import br.com.sicredi.grpcserver.exceptions.ProductNotFoundException;
import br.com.sicredi.grpcserver.repositories.ProductRepository;
import br.com.sicredi.grpcserver.utils.ProductConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductOutputDTO create(ProductInputDTO inputDTO) {
        var product = ProductConverterUtil.productInputDtoToProduct(inputDTO);
        var productCreated = this.productRepository.save(product);
        return ProductConverterUtil.productToProductOutputDto(productCreated);
    }

    @Override
    public ProductOutputDTO findById(Long id) {
        var product = this.productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return ProductConverterUtil.productToProductOutputDto(product);
    }

    @Override
    public void delete(Long id) {
        var product = this.productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        this.productRepository.delete(product);
    }

    @Override
    public List<ProductOutputDTO> findAll() {
        var products = this.productRepository.findAll();
        return products.stream()
                .map(ProductConverterUtil::productToProductOutputDto)
                .collect(Collectors.toList());
    }
}
