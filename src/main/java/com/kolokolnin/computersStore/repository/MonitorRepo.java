package com.kolokolnin.computersStore.repository;

import com.kolokolnin.computersStore.entity.Monitors;
import org.springframework.stereotype.Repository;

import javax.management.monitor.Monitor;
import java.util.List;

@Repository
public interface MonitorRepo extends ProductPropertiesRepo<Monitors> {
    List<Monitors> findByDiagonal(Long diagonal);
}
