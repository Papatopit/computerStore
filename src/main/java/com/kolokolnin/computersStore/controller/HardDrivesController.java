package com.kolokolnin.computersStore.controller;

import com.kolokolnin.computersStore.entity.HardDrives;
import com.kolokolnin.computersStore.service.HardDrivesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hd")
@Slf4j
public class HardDrivesController extends AbstractProductRestController<HardDrives,HardDrivesService>{


    private final HardDrivesService hardDrivesService;
    @Autowired
    public HardDrivesController(HardDrivesService hardDrivesService) {
        super(hardDrivesService);
        this.hardDrivesService = hardDrivesService;
    }

    @Override
    public List<HardDrives> productByPropertyRequest(@RequestBody HardDrives hardDrive) {
        if (hardDrive.getCapacity() != null) {
            log.info("Capacity by HardDrivesController");
            return hardDrivesService.readByCapacity(hardDrive.getCapacity());
        }
        log.info("default value HardDrive");
        return getProductsByDefaultProperty(hardDrive);
    }

    @Override
    public boolean setProduct(@RequestBody HardDrives requestedHardDrive) {
        if (requestedHardDrive.getSerialNumber() != null) {
            log.info("Update by SerialNumber in HardDrivesController");
            return hardDrivesService.updateBySerialNumber(requestedHardDrive);
        }
        return false;
    }
}
