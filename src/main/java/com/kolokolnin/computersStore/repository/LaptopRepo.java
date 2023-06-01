package com.kolokolnin.computersStore.repository;

import com.kolokolnin.computersStore.entity.Laptops;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepo extends ProductPropertiesRepo<Laptops> {
    List<Laptops> findByScreenInch(Laptops.ScreenInch screenInch);
}
