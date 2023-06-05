package com.kolokolnin.computersStore.controller;

import com.kolokolnin.computersStore.entity.DesktopComputers;
import com.kolokolnin.computersStore.service.DesktopComputerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pc")
@Slf4j
public class DesktopComputerController extends AbstractProductRestController<DesktopComputers, DesktopComputerService> {

    private final DesktopComputerService desktopComputerService;
    @Autowired
    public DesktopComputerController(DesktopComputerService desktopComputerService) {
        super(desktopComputerService);
        this.desktopComputerService = desktopComputerService;
    }

    @Override
    public List<DesktopComputers> productByPropertyRequest(@RequestBody DesktopComputers pc) {
        if (pc.getFormFactor() != null) {
            log.info("get formFactor from DesktopComputerController");
            return desktopComputerService.readDesktopComputerByFormFactor(pc.getFormFactor());
        }
        log.info("default value DesktopComputer");
        return getProductsByDefaultProperty(pc);
    }

    @Override
    public boolean setProduct(@RequestBody DesktopComputers requestedPC) {
        if (requestedPC.getSerialNumber() != null) {
            log.info("Update by serialNumber from DesktopComputerController");
            return desktopComputerService.updateBySerialNumber(requestedPC);
        }
        return false;
    }

}
