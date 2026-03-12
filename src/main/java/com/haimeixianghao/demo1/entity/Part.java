package com.haimeixianghao.demo1.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 部件 (DM07181957)
 */
@Data
@Table("part")
public class Part {

    @Id
    private Long id;

    /** 物料编号 */
    private String partCode;

    /** 物料名称 */
    private String partName;

    /** 规格型号 */
    private String specModel;

    /** 供应商 */
    private String supplier;

    /** 库存数量 */
    private Integer stockQuantity;

    /** 参考设备ID（关联 Equitment） */
    private Long usedEquipmentId;

    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
}

