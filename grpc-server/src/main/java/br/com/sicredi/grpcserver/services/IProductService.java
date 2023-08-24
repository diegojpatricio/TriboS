package br.com.sicredi.grpcserver.services;

import br.com.sicredi.grpcserver.dto.ProductInputDTO;
import br.com.sicredi.grpcserver.dto.ProductOutputDTO;

import java.util.List;

public interface IProductService {
    ProductOutputDTO create(ProductInputDTO inputDTO);
    ProductOutputDTO findById(Long id);
    void delete(Long id);
    List<ProductOutputDTO> findAll();
    ProductOutputDTO update(Long id, ProductInputDTO inputDTO);
}