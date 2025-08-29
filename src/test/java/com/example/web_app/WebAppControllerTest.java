package com.example.web_app;

import com.example.web_app.controller.WebAppController;
import com.example.web_app.product.Product;
import com.example.web_app.product.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class WebAppControllerTest {

    @Mock
    private ProductRepository repo;

    @InjectMocks
    private WebAppController controller;

    Product prod;

    @BeforeEach
    void beforeEach() {
        prod = new Product(1, "test");
    }

	@Test
	void getHelloTest() {
        String result = controller.getHello();

        assertEquals("Hello app", result);
	}

    @Test
    void getAllProductsTest() {
        List<Product> test_list = List.of(prod);
        when(repo.findAll()).thenReturn(test_list);

        List<Product> result_list = controller.getAllProducts();

        assertEquals(test_list, result_list);
        verify(repo, times(1)).findAll();
    }

    @Test
    void getProductByIdTest_Positive_FoundProduct() {
        ResponseEntity<Product> return_val = new ResponseEntity<>(prod, HttpStatus.OK);
        when(repo.findById(prod.getId())).thenReturn(Optional.of(prod));

        ResponseEntity<Product> result = controller.getProductById(prod.getId());

//        assertEquals(return_val.getStatusCode(), result.getStatusCode());
//        assertEquals(return_val.getBody(), result.getBody());
        assertEquals(return_val, result);
        verify(repo, times(1)).findById(prod.getId());
    }

    @Test
    void getProductByIdTest_Negative_NotFoundProduct() {
        ResponseEntity<Product> return_val = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        when(repo.findById(prod.getId())).thenReturn(Optional.empty());

        ResponseEntity<Product> result = controller.getProductById(prod.getId());

        assertEquals(return_val, result);
        verify(repo, times(1)).findById(prod.getId());
    }

    @Test
    void addProdTest_Positive_ProductAdded() throws JsonProcessingException {
        Product product_id_null = new Product(null, "test");
        when(repo.save(product_id_null)).thenReturn(prod);
        ResponseEntity<Product> return_val = new ResponseEntity<>(prod, HttpStatus.OK);

        ResponseEntity<Product> result = controller.addProd(product_id_null);

        assertEquals(result, return_val);
        verify(repo, times(1)).save(product_id_null);
    }

    @Test
    void addProdTest_Negative_NotValidProduct() throws JsonProcessingException {
        ResponseEntity<Product> return_val = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        ResponseEntity<Product> result = controller.addProd(prod);

        assertEquals(result, return_val);
        verify(repo, times(0)).save(prod);
    }
}
