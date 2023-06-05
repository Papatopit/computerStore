package com.kolokolnin.computersStore.repository;

import com.kolokolnin.computersStore.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface ProductPropertiesRepo<E extends Product> extends CrudRepository<E, Long> {
    @NonNull
    List<E> findAll();

    E findProductById(UUID id);

    E findBySerialNumber(Long serialNumber);
    List<E> findByManufacturer(String manufacturer);
    List<E> findByPrice(Long price);
    List<E> findByUnitsInStock(Long unitsInStock);
}
