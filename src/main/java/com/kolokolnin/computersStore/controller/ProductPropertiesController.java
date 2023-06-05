package com.kolokolnin.computersStore.controller;

import com.kolokolnin.computersStore.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface ProductPropertiesController<E extends Product> {
    @GetMapping("/all")
    @ResponseBody
    List<E> getAllProducts();

    @GetMapping("/all")
    @ResponseBody
    List<E> productByPropertyRequest(@RequestBody E requestedProduct);

    @PostMapping("/add")
    @ResponseBody
    boolean addProductRequest(@RequestBody E addProductRequest);

    @GetMapping("/api/v1/product/{{id}")
    @ResponseBody
    E getProductBySerialNumberOrId(@RequestBody E requestedProduct);

    @PostMapping("/api/v1/product/update/{{id}}")
    @ResponseBody
    boolean setProduct(@RequestBody E requestedProduct);
}
