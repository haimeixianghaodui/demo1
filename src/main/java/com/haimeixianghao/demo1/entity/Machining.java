package com.haimeixianghao.demo1.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 机械加工 (DM07192658)
 */
@Data
@Table("machining")
public class Machining {

    @Id
    private Long id;

    /** 加工 - 关联 ShaftMachining ID */
    private Long machiningShaftMachiningId;

    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
}

