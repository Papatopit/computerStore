package com.kolokolnin.computersStore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "serial_number")
    private Long serialNumber;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "price")
    private Long price;
    @Column(name = "units_in_stock")
    private Long unitsInStock;
}
