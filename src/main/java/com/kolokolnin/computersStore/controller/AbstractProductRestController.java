package com.kolokolnin.computersStore.controller;

import com.kolokolnin.computersStore.entity.ProductProperties;
import com.kolokolnin.computersStore.service.ProductPropertiesService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class AbstractProductRestController <E extends ProductProperties,
        S extends ProductPropertiesService<E>> implements ProductPropertiesController<E> {

    private final S service;

    protected AbstractProductRestController(S service) {
        this.service = service;
    }

    @Override
    public List<E> getAllProducts() {
        return service.allProducts();
    }

    @Override
    public boolean addProduct(@RequestBody E requestedProduct) {
        if (requestedProduct.getSerialNumber() != null) {
            return service.createProduct(requestedProduct);
        }

        return false;
    }

    @Override
    public E getProductBySerialNumberOrId(@RequestBody E requestedProduct) {
        if (requestedProduct.getId() != null) {
            return service.readById(requestedProduct.getId());
        }

        if (requestedProduct.getSerialNumber() != null) {
            return service.readBySerialNumber(requestedProduct.getSerialNumber());
        }

        return null;
    }

    public List<E> getProductsByDefaultProperty(E requestedProduct) {
        if (requestedProduct.getManufacturer() != null) {
            return service.readByManufacturer(requestedProduct.getManufacturer());
        }
        if (requestedProduct.getPrice() != null) {
            return service.readByPrice(requestedProduct.getPrice());
        }
        if (requestedProduct.getUnitsInStock() != null) {
            return service.readByUnitsInStock(requestedProduct.getUnitsInStock());
        }

        return null;
    }
}