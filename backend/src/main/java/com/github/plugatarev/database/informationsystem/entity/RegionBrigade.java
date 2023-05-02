package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "region_brigade")
@Getter
@Setter
public class RegionBrigade extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region", referencedColumnName = "id")
    private DepartmentRegion region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brigade", referencedColumnName = "id")
    private Brigade brigade;
}