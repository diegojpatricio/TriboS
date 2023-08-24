package br.com.sicredi.grpcserver.repositories;

import br.com.sicredi.grpcserver.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}