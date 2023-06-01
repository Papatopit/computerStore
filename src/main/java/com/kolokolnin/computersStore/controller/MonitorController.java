package com.kolokolnin.computersStore.controller;

import com.kolokolnin.computersStore.entity.Monitors;
import com.kolokolnin.computersStore.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/monitor")
public class MonitorController extends AbstractProductRestController<Monitors, MonitorService> {

    @Autowired
    private MonitorService monitorService;
    @Autowired
    public MonitorController(MonitorService monitorService) {
        super(monitorService);
        this.monitorService = monitorService;
    }

    @Override
    public List<Monitors> getProductsByProperty(@RequestBody Monitors monitor) {
        if (monitor.getDiagonal() != null) {
            return monitorService.readMonitorByDiagonal(monitor.getDiagonal());
        }
        return getProductsByDefaultProperty(monitor);
    }

    @Override
    public boolean setProduct(@RequestBody Monitors requestedMonitor) {
        if (requestedMonitor.getSerialNumber() != null) {
            return monitorService.updateBySerialNumber(requestedMonitor);
        }
        return false;
    }
}
