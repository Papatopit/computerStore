package com.kolokolnin.computersStore.repository;

import com.kolokolnin.computersStore.entity.ProductProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductPropertiesRepo<E extends ProductProperties> extends CrudRepository<E, Long> {
    List<E> findAll();

    E findProductById(Long id);

    E findBySerialNumber(Long serialNumber);
    List<E> findByManufacturer(String manufacturer);
    List<E> findByPrice(Long price);
    List<E> findByUnitsInStock(Long unitsInStock);
}
