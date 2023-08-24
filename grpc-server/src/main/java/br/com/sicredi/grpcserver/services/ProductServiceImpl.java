package br.com.sicredi.grpcserver.services;

import br.com.sicredi.grpcserver.dto.ProductInputDTO;
import br.com.sicredi.grpcserver.dto.ProductOutputDTO;
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
        var productCreated = productRepository.save(product);
        return ProductConverterUtil.productToProductOutputDto(productCreated);
    }

    @Override
    public ProductOutputDTO findById(Long id) {
        var product = productRepository.findById(id);
        return ProductConverterUtil.productToProductOutputDto(product.get());
    }

    @Override
    public void delete(Long id) {
        var product = productRepository.findById(id);
        productRepository.delete(product.get());
    }

    @Override
    public List<ProductOutputDTO> findAll() {
        var products = productRepository.findAll();
        return products.stream()
                .map(ProductConverterUtil::productToProductOutputDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductOutputDTO update(Long id, ProductInputDTO inputDTO) {
        var existingProduct = productRepository.findById(id);

        if (existingProduct.isEmpty()) {
            System.out.println("Produto nao existe");
        }

        var productToUpdate = existingProduct.get();

        // Atualize as propriedades do produto com base no ProductInputDTO recebido
        productToUpdate.setName(inputDTO.getName());
        productToUpdate.setPrice(inputDTO.getPrice());
        productToUpdate.setQuantityInStock(inputDTO.getQuantityInStock());

        var updatedProduct = productRepository.save(productToUpdate);

        return ProductConverterUtil.productToProductOutputDto(updatedProduct);
    }

}
