package com.kolokolnin.computersStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "monitor")
@Getter
@Setter
public class Monitors extends Product {
    @Column(name = "diagonal")
    private Long diagonal;
}
