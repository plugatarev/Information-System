package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "region_brigade")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegionBrigade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "region", referencedColumnName = "id")
    private DepartmentRegion region;

    @ManyToOne
    @JoinColumn(name = "brigade", referencedColumnName = "id")
    private Brigade brigade;
}