package com.haimeixianghao.demo1.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 毛坯制造 (DM07182563)
 */
@Data
@Table("blank_manufacturing")
public class BlankManufacturing {

    @Id
    private Long id;

    /** 加工 - 关联 Machining ID */
    private Long machiningId;

    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
}

