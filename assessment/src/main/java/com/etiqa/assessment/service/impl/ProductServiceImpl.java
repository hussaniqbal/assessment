package com.etiqa.assessment.service.impl;

import com.etiqa.assessment.model.Product;
import com.etiqa.assessment.repository.ProductRepository;
import com.etiqa.assessment.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        logger.info("Fetching all products");
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        logger.info("Fetching product with id: {}", id);
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public Product createProduct(Product product) {
        logger.info("Creating product: {}", product);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = getProductById(id);

        existingProduct.setBookTitle(updatedProduct.getBookTitle());
        existingProduct.setBookPrice(updatedProduct.getBookPrice());
        existingProduct.setBookQuantity(updatedProduct.getBookQuantity());

        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        logger.info("Deleting product with id: {}", id);
        productRepository.deleteById(id);
    }
}
