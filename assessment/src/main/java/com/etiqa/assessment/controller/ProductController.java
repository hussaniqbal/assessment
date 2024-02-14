package com.etiqa.assessment.controller;

import com.etiqa.assessment.model.Customer;
import com.etiqa.assessment.model.Product;
import com.etiqa.assessment.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.etiqa.assessment.config.Constants.HttpCodes.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Get all products")
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_200_CODE, message = HTTP_200_OK_MESSAGE, response = Product.class),
            @ApiResponse(code = HTTP_400_CODE, message = HTTP_400_MESSAGE),
            @ApiResponse(code = HTTP_401_CODE, message = HTTP_401_MESSAGE),
            @ApiResponse(code = HTTP_403_CODE, message = HTTP_403_MESSAGE),
            @ApiResponse(code = HTTP_404_CODE, message = HTTP_404_MESSAGE),
            @ApiResponse(code = HTTP_429_CODE, message = HTTP_429_MESSAGE),
            @ApiResponse(code = HTTP_500_CODE, message = HTTP_500_MESSAGE)})
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @ApiOperation(value = "Get product by id")
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_200_CODE, message = HTTP_200_OK_MESSAGE, response = Customer.class),
            @ApiResponse(code = HTTP_400_CODE, message = HTTP_400_MESSAGE),
            @ApiResponse(code = HTTP_401_CODE, message = HTTP_401_MESSAGE),
            @ApiResponse(code = HTTP_403_CODE, message = HTTP_403_MESSAGE),
            @ApiResponse(code = HTTP_404_CODE, message = HTTP_404_MESSAGE),
            @ApiResponse(code = HTTP_429_CODE, message = HTTP_429_MESSAGE),
            @ApiResponse(code = HTTP_500_CODE, message = HTTP_500_MESSAGE)})
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @ApiOperation(value = "Create new product")
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_200_CODE, message = HTTP_200_OK_MESSAGE, response = Customer.class),
            @ApiResponse(code = HTTP_400_CODE, message = HTTP_400_MESSAGE),
            @ApiResponse(code = HTTP_401_CODE, message = HTTP_401_MESSAGE),
            @ApiResponse(code = HTTP_403_CODE, message = HTTP_403_MESSAGE),
            @ApiResponse(code = HTTP_404_CODE, message = HTTP_404_MESSAGE),
            @ApiResponse(code = HTTP_429_CODE, message = HTTP_429_MESSAGE),
            @ApiResponse(code = HTTP_500_CODE, message = HTTP_500_MESSAGE)})
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @ApiOperation(value = "Update product by id")
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_200_CODE, message = HTTP_200_OK_MESSAGE, response = Customer.class),
            @ApiResponse(code = HTTP_400_CODE, message = HTTP_400_MESSAGE),
            @ApiResponse(code = HTTP_401_CODE, message = HTTP_401_MESSAGE),
            @ApiResponse(code = HTTP_403_CODE, message = HTTP_403_MESSAGE),
            @ApiResponse(code = HTTP_404_CODE, message = HTTP_404_MESSAGE),
            @ApiResponse(code = HTTP_429_CODE, message = HTTP_429_MESSAGE),
            @ApiResponse(code = HTTP_500_CODE, message = HTTP_500_MESSAGE)})
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }

    @ApiOperation(value = "Delete product by id")
    @ApiResponses(value = {
            @ApiResponse(code = HTTP_200_CODE, message = HTTP_200_OK_MESSAGE, response = Customer.class),
            @ApiResponse(code = HTTP_400_CODE, message = HTTP_400_MESSAGE),
            @ApiResponse(code = HTTP_401_CODE, message = HTTP_401_MESSAGE),
            @ApiResponse(code = HTTP_403_CODE, message = HTTP_403_MESSAGE),
            @ApiResponse(code = HTTP_404_CODE, message = HTTP_404_MESSAGE),
            @ApiResponse(code = HTTP_429_CODE, message = HTTP_429_MESSAGE),
            @ApiResponse(code = HTTP_500_CODE, message = HTTP_500_MESSAGE)})
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
