package com.kolokolnin.computersStore.controller;

import com.kolokolnin.computersStore.entity.Laptops;
import com.kolokolnin.computersStore.service.LaptopService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/laptop")
@Slf4j
public class LaptopController extends AbstractProductRestController<Laptops, LaptopService> {
   private final LaptopService laptopService;
    @Autowired
    public LaptopController(LaptopService laptopService) {
        super(laptopService);
        this.laptopService = laptopService;
    }

    @Override
    public List<Laptops> productByPropertyRequest(@RequestBody Laptops laptop) {
        if (laptop.getScreenInch() != null) {
            log.info("get Screen Inch by LaptopController");
            return laptopService.readByScreenDiagonal(laptop.getScreenInch());
        }
        log.info("default value Laptop");
        return getProductsByDefaultProperty(laptop);
    }

    @Override
    public boolean setProduct(@RequestBody Laptops requestedLaptop) {
        if (requestedLaptop.getSerialNumber() != null) {
            log.info("Update by SerialNumber in LaptopController");
            return laptopService.updateBySerialNumber(requestedLaptop);
        }
        return false;
    }

}
