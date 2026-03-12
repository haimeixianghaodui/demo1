package com.haimeixianghao.demo1.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 轴类零件加工 (DM07192672)
 */
@Data
@Table("shaft_machining")
public class ShaftMachining {

    @Id
    private Long id;

    /** 出货检测 - 关联 DimensionalInspecting ID */
    private Long fqcDimensionalInspectingId;

    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
}

