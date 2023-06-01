package com.kolokolnin.computersStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
@Table(name = "laptop")
public class Laptops extends ProductProperties{
    @Column(name = "screen_inch")
    private ScreenInch screenInch;

    public enum ScreenInch {
        INCH_13,
        INCH_14,
        INCH_15,
        INCH_17,
    }

}
