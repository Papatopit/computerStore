package com.kolokolnin.computersStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Table(name = "desktop_computer")
@NoArgsConstructor
@Entity
@Getter
@Setter
public class DesktopComputers extends Product {
    @Column(name = "form_factor")
    private FormFactor formFactor;

    public enum FormFactor {
        DESKTOP,
        NETTOP,
        MONOBLOCK
    }
}
