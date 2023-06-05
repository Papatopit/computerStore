package com.kolokolnin.computersStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Entity
@Table(name = "laptop")
@Getter
@Setter
public class Laptops extends Product {
    @Column(name = "screen_inch")
    private ScreenInch screenInch;

    public enum ScreenInch {
        INCH_13,
        INCH_14,
        INCH_15,
        INCH_17,
    }

}
