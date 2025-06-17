package com.ucc.product.service;

import com.ucc.product.model.Product;
import com.ucc.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Metodo obtener los productos guardados
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //Metodo obtener un producto por id
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    //Metodo crear un producto
    public void  createProduct(Product product) {
        productRepository.save(product);
    }

    //Metodo actualizar un producto
    public void updateProduct(Long id, Product updatedProduct) {
        Product existing = getProductById(id);
        existing.setName(updatedProduct.getName());
        existing.setPrice(updatedProduct.getPrice());
        existing.setDescription(updatedProduct.getDescription());
        existing.setStock(updatedProduct.getStock());
        existing.setStatus(updatedProduct.getStatus());
        productRepository.save(existing);
    }

    //Metodo eliminar un producto
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
