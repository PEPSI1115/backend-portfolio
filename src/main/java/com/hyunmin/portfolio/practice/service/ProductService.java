package com.hyunmin.portfolio.practice.service;

import com.hyunmin.portfolio.practice.domain.Product;
import com.hyunmin.portfolio.practice.exception.ProductNotFoundException;
import com.hyunmin.portfolio.practice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(String name, int price) {
        Product product = new Product(name, price);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
}