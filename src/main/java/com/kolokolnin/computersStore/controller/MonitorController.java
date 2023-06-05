package com.kolokolnin.computersStore.controller;

import com.kolokolnin.computersStore.entity.Monitors;
import com.kolokolnin.computersStore.service.MonitorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/monitor")
@Slf4j
public class MonitorController extends AbstractProductRestController<Monitors, MonitorService> {


    private final MonitorService monitorService;
    @Autowired
    public MonitorController(MonitorService monitorService) {
        super(monitorService);
        this.monitorService = monitorService;
    }

    @Override
    public List<Monitors> productByPropertyRequest(@RequestBody Monitors monitor) {
        if (monitor.getDiagonal() != null) {
            log.info("get Screen Inch by MonitorController");
            return monitorService.getMonitorByDiagonal(monitor.getDiagonal());
        }
        log.info("default value Monitor");
        return getProductsByDefaultProperty(monitor);
    }

    @Override
    public boolean setProduct(@RequestBody Monitors requestedMonitor) {
        if (requestedMonitor.getSerialNumber() != null) {
            log.info("Update by SerialNumber in MonitorController");
            return monitorService.updateBySerialNumber(requestedMonitor);
        }
        return false;
    }
}
