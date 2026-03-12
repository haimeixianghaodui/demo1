package com.haimeixianghao.demo1.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 入库 (DM07192686)
 */
@Data
@Table("warehousing")
public class Warehousing {

    @Id
    private Long id;

    /** 入库关联部件ID */
    private Long inPartId;

    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
}

