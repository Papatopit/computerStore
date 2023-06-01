package com.kolokolnin.computersStore.service;

import com.kolokolnin.computersStore.entity.Laptops;
import com.kolokolnin.computersStore.repository.LaptopRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LaptopService extends AbstractProductService<Laptops, LaptopRepo> {
    @Autowired
    private LaptopRepo laptopRepo;

    public List<Laptops> readByScreenDiagonal(Laptops.ScreenInch screenInch) {
        return laptopRepo.findByScreenInch(screenInch);
    }

    @Override
    public boolean updateBySerialNumber(Laptops laptop) {
        Laptops laptopFromDB = defaultUpdateBySerialNumber(laptop);
        if (laptopFromDB == null) {
            return false;
        }
        if (laptop.getScreenInch() != null) {
            laptopFromDB.setScreenInch(laptop.getScreenInch());
        }
        laptopRepo.save(laptopFromDB);
        return true;
    }

}
