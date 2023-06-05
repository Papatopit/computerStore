package com.kolokolnin.computersStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Entity
@Table(name = "hard_drive")
@Getter
@Setter
public class HardDrives extends Product {
    @Column(name = "capacity")
    private Long capacity;
}
