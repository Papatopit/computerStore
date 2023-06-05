package com.kolokolnin.computersStore.service;

import com.kolokolnin.computersStore.entity.Product;
import com.kolokolnin.computersStore.repository.ProductPropertiesRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractProductService<E extends Product,
        R extends ProductPropertiesRepo<E>> implements ProductPropertiesService<E> {

    private R DAO;

    public List<E> allProducts() {
        return DAO.findAll();
    }

    public boolean createProduct(E product) {
        E pcFromDB = DAO.findBySerialNumber(product.getSerialNumber());
        if (pcFromDB != null) {
            return false;
        }
        product.setId(null);
        DAO.save(product);
        return true;
    }

    public E getById(UUID id) {
        return DAO.findProductById(id);
    }

    public E getBySerialNumber(Long serialNumber) {
        return DAO.findBySerialNumber(serialNumber);
    }

    public List<E> getByManufacturer(String manufacture) {
        return DAO.findByManufacturer(manufacture);
    }

    public List<E> getByPrice(Long price) {
        return DAO.findByPrice(price);
    }

    public List<E> getByUnitsInStock(Long unitsInStock) {
        return DAO.findByUnitsInStock(unitsInStock);
    }

    public E defaultUpdateBySerialNumber(E product) {
        E productFromDB = DAO.findBySerialNumber(product.getSerialNumber());
        if (productFromDB == null) {
            return null;
        }
        if (product.getManufacturer() != null) {
            productFromDB.setManufacturer(product.getManufacturer());
        }
        if (product.getPrice() != null) {
            productFromDB.setPrice(product.getPrice());
        }
        if (product.getUnitsInStock() != null) {
            productFromDB.setUnitsInStock(product.getUnitsInStock());
        }
        return productFromDB;
    }
}
