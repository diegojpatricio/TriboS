package br.com.sicredi.grpcserver.resources;

import br.com.sicredi.grpcserver.dto.ProductInputDTO;
import br.com.sicredi.grpcserver.dto.ProductOutputDTO;
import br.com.sicredi.grpcserver.services.IProductService;
import com.example.demo.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class ProductResource extends ProductServiceGrpc.ProductServiceImplBase {
    @Autowired
    private IProductService productService;

    @Override
    public void create(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        ProductInputDTO inputDTO = new ProductInputDTO(
                request.getName(),
                request.getPrice(),
                request.getQuantityInStock()
        );

        ProductOutputDTO outputDTO = this.productService.create(inputDTO);

        ProductResponse response = ProductResponse.newBuilder()
                .setId(outputDTO.getId())
                .setName(outputDTO.getName())
                .setPrice(outputDTO.getPrice())
                .setQuantityInStock(outputDTO.getQuantityInStock())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(RequestById request, StreamObserver<EmptyResponse> responseObserver) {
        productService.delete(request.getId());
        responseObserver.onNext(EmptyResponse.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void findById(RequestById request, StreamObserver<ProductResponse> responseObserver) {
        ProductOutputDTO outputDTO = productService.findById(request.getId());
        ProductResponse response = ProductResponse.newBuilder()
                .setId(outputDTO.getId())
                .setName(outputDTO.getName())
                .setPrice(outputDTO.getPrice())
                .setQuantityInStock(outputDTO.getQuantityInStock())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void findAll(EmptyRequest request, StreamObserver<ProductResponseList> responseObserver) {
        List<ProductOutputDTO> outputDTOList = productService.findAll();
        List<ProductResponse> productResponseList = outputDTOList.stream()
                .map(outputDTO ->
                        ProductResponse.newBuilder()
                                .setId(outputDTO.getId())
                                .setName(outputDTO.getName())
                                .setPrice(outputDTO.getPrice())
                                .setQuantityInStock(outputDTO.getQuantityInStock())
                                .build())
                .collect(Collectors.toList());

        ProductResponseList response = ProductResponseList.newBuilder()
                .addAllProducts(productResponseList)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void update(RequestById request, StreamObserver<ProductResponse> responseObserver) {
        // Primeiro, recupere o produto existente pelo ID
        ProductOutputDTO existingProduct = productService.findById(request.getId());

        // Verifique se o produto existe
        if (existingProduct == null) {
            // Produto não encontrado, envie uma resposta de erro ou vazia, dependendo do caso
            // Aqui estou enviando uma resposta vazia
            responseObserver.onNext(ProductResponse.newBuilder().build());
            responseObserver.onCompleted();
            return;
        }

        // Você pode realizar ações de atualização aqui, se necessário
        // Por exemplo, atualizar propriedades como nome, preço ou quantidade em estoque

        // No exemplo abaixo, estou apenas reenviando o mesmo produto como resposta, pois não estou realizando atualizações reais.
        ProductResponse response = ProductResponse.newBuilder()
                .setId(existingProduct.getId())
                .setName(existingProduct.getName())
                .setPrice(existingProduct.getPrice())
                .setQuantityInStock(existingProduct.getQuantityInStock())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


}
