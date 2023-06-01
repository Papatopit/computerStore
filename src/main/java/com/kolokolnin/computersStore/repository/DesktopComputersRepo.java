package com.kolokolnin.computersStore.repository;


import com.kolokolnin.computersStore.entity.DesktopComputers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesktopComputersRepo extends ProductPropertiesRepo<DesktopComputers> {
    List<DesktopComputers> findByFormFactor(DesktopComputers.FormFactor formFactor);
}
