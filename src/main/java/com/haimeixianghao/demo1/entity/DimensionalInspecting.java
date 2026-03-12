package com.haimeixianghao.demo1.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 尺寸检测 (DM07192683)
 */
@Data
@Table("dimensional_inspecting")
public class DimensionalInspecting {

    @Id
    private Long id;

    /** 入库检测 - 关联 Warehousing ID */
    private Long iqcWarehousingId;

    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
}

