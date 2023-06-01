package com.kolokolnin.computersStore.service;

import com.kolokolnin.computersStore.entity.Monitors;
import com.kolokolnin.computersStore.repository.MonitorRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MonitorService extends AbstractProductService<Monitors, MonitorRepo> {

    @Autowired
    private MonitorRepo monitorRepo;

    public List<Monitors> readMonitorByDiagonal(Long diagonal) {
        return monitorRepo.findByDiagonal(diagonal);
    }

    @Override
    public boolean updateBySerialNumber(Monitors monitor) {
        Monitors monitorFromDB = defaultUpdateBySerialNumber(monitor);
        if (monitorFromDB == null) {
            return false;
        }
        if (monitor.getDiagonal() != null) {
            monitorFromDB.setDiagonal(monitor.getDiagonal());
        }
        monitorRepo.save(monitorFromDB);
        return true;
    }

}
