package com.kolokolnin.computersStore.controller;

import com.kolokolnin.computersStore.entity.Product;
import com.kolokolnin.computersStore.service.ProductPropertiesService;
import com.kolokolnin.computersStore.utils.ProductValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
public abstract class AbstractProductRestController<E extends Product,
        S extends ProductPropertiesService<E>> implements ProductPropertiesController<E> {

    private final S service;


    protected AbstractProductRestController(S service) {
        this.service = service;
    }

    @Override
    public List<E> getAllProducts() {
        log.info("get all products {}", service.allProducts());
        return service.allProducts();
    }


    @Override
    public boolean addProductRequest(@RequestBody E addProductRequest) {

        if (addProductRequest.getSerialNumber() != null) {
            log.info("add Product {}", service.createProduct(addProductRequest));
            return service.createProduct(addProductRequest);
        }

        return false;
    }

    @Override
    public E getProductBySerialNumberOrId(@RequestBody E requestedProduct) {
        if (requestedProduct.getId() != null) {
            log.info("requested ID Product {}", service.getById(requestedProduct.getId()));
            return service.getById(requestedProduct.getId());
        }

        if (requestedProduct.getSerialNumber() != null) {
            log.info("requested SerialNumber Product {}", service.getBySerialNumber(requestedProduct.getSerialNumber()));
            return service.getBySerialNumber(requestedProduct.getSerialNumber());
        }

        return null;
    }

    public List<E> getProductsByDefaultProperty(E requestedProduct) {
        if (requestedProduct.getManufacturer() != null) {
            return service.getByManufacturer(requestedProduct.getManufacturer());
        }
        if (requestedProduct.getPrice() != null) {
            return service.getByPrice(requestedProduct.getPrice());
        }
        if (requestedProduct.getUnitsInStock() != null) {
            return service.getByUnitsInStock(requestedProduct.getUnitsInStock());
        }

        return null;
    }
}