package com.controller;

import com.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import com.model.Product;

import com.service.ProductService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verifyZeroInteractions;

public class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }


    @Test
    public void testGetAllProducts() throws Exception{

        List<Product> products = new ArrayList<Product>();
        products.add(new Product());
        products.add(new Product());

        Mockito.when(productService.getAllProducts()).thenReturn((List) products);

        mockMvc.perform(MockMvcRequestBuilders.get("/getAllProducts"))
                .andExpect(MockMvcResultMatchers.status().isOk()) //the status is okay
                .andExpect(MockMvcResultMatchers.view().name("productList")) //the name is productList
                .andExpect(MockMvcResultMatchers.model().size(1)); //and at the moment we only have one product in our database
    }

    @Test
    public void testGetProductById() throws Exception{
        String id = "1";

        Mockito.when(productService.getProductById(id)).thenReturn(new Product());

        mockMvc.perform(MockMvcRequestBuilders.get("/getProductById/1"))
                .andExpect(MockMvcResultMatchers.status().isOk()) //the status is okay
                .andExpect(MockMvcResultMatchers.view().name("productPage")) //the name is productPage
                .andExpect(MockMvcResultMatchers.model().size(1));
    }


    @Test
    public void testgetProductForm() throws Exception {

        verifyZeroInteractions(productService);
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/product/addProduct"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("productFormObj", instanceOf(Product.class)));
    }


}