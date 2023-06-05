package com.kolokolnin.computersStore.service;

import com.kolokolnin.computersStore.entity.DesktopComputers;
import com.kolokolnin.computersStore.repository.DesktopComputersRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DesktopComputerService extends AbstractProductService<DesktopComputers, DesktopComputersRepo> {

   private final DesktopComputersRepo desktopComputersRepo;

    public List<DesktopComputers> readDesktopComputerByFormFactor(DesktopComputers.FormFactor formFactor) {
        return desktopComputersRepo.findByFormFactor(formFactor);
    }

    @Override
    public boolean updateBySerialNumber(DesktopComputers desktopComputers) {
        DesktopComputers pcFromDB = defaultUpdateBySerialNumber(desktopComputers);
        if (pcFromDB == null) {
            return false;
        }
        if (desktopComputers.getFormFactor() != null) {
            pcFromDB.setFormFactor(desktopComputers.getFormFactor());
        }

        desktopComputersRepo.save(pcFromDB);
        return true;
    }
}

