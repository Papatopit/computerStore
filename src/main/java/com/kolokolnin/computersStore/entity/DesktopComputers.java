package com.kolokolnin.computersStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Data
@Table(name = "desktop_computer")
@NoArgsConstructor
@Entity
public class DesktopComputers extends ProductProperties {
    @Column(name = "form_factor")
    private FormFactor formFactor;

    public enum FormFactor {
        DESKTOP,
        NETTOP,
        MONOBLOCK
    }
}
