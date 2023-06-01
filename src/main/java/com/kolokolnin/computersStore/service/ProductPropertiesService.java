package com.kolokolnin.computersStore.service;

import com.kolokolnin.computersStore.entity.ProductProperties;

import java.util.List;

public interface ProductPropertiesService<E extends ProductProperties> {
    List<E> allProducts();

    boolean createProduct(E pc);

    E readById(Long id);

    E readBySerialNumber(Long serialNumber);

    List<E> readByManufacturer(String manufacture);
    List<E> readByPrice(Long price);
    List<E> readByUnitsInStock(Long unitsInStock);

    boolean updateBySerialNumber(E laptop);
}
