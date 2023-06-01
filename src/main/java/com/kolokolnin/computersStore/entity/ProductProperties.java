package com.kolokolnin.computersStore.entity;

import jakarta.persistence.*;
import lombok.*;
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "serial_number")
    private Long serialNumber;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "price")
    private Long price;
    @Column(name = "units_in_stock")
    private Long unitsInStock;
}
