package com.kolokolnin.computersStore.repository;

import com.kolokolnin.computersStore.entity.HardDrives;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HardDrivesRepo extends ProductPropertiesRepo<HardDrives> {
    List<HardDrives> findByCapacity(Long capacity);
}
