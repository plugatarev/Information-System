package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "region_brigade")
@Getter
@Setter
public class RegionBrigade extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "region", referencedColumnName = "id")
    private DepartmentRegion region;

    @ManyToOne
    @JoinColumn(name = "brigade", referencedColumnName = "id")
    private Brigade brigade;
}