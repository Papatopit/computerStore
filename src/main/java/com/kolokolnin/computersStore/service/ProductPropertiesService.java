package com.kolokolnin.computersStore.service;

import com.kolokolnin.computersStore.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductPropertiesService<E extends Product> {
    List<E> allProducts();

    boolean createProduct(E pc);

    E getById(Long id);

    E getBySerialNumber(Long serialNumber);

    List<E> getByManufacturer(String manufacture);
    List<E> getByPrice(Long price);
    List<E> getByUnitsInStock(Long unitsInStock);

    boolean updateBySerialNumber(E laptop);
}
