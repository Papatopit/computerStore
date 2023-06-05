package com.kolokolnin.computersStore.service;

import com.kolokolnin.computersStore.entity.HardDrives;
import com.kolokolnin.computersStore.repository.HardDrivesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HardDrivesService extends AbstractProductService<HardDrives, HardDrivesRepo> {


   private final HardDrivesRepo hardDrivesRepo;

    public HardDrivesService(HardDrivesRepo hardDrivesRepo) {
        super(hardDrivesRepo);
        this.hardDrivesRepo = hardDrivesRepo;
    }

    public List<HardDrives> readByCapacity(Long capacity) {
        return hardDrivesRepo.findByCapacity(capacity);
    }

    @Override
    public boolean updateBySerialNumber(HardDrives hardDrives) {
        HardDrives hardDriveFromDB = defaultUpdateBySerialNumber(hardDrives);
        if (hardDriveFromDB == null) {
            return false;
        }
        if (hardDrives.getCapacity() != null) {
            hardDriveFromDB.setCapacity(hardDrives.getCapacity());
        }
        hardDrivesRepo.save(hardDriveFromDB);
        return true;
    }
}

