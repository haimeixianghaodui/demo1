package com.haimeixianghao.demo1.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 工序 (DM07182035)
 */
@Data
@Table("working_procedure")
public class WorkingProcedure {

    @Id
    private Long id;

    /** 工序编号 */
    private String procedureCode;

    /** 工序名称 */
    private String procedureName;

    /** 开始时间 */
    private LocalDateTime startTime;

    /** 结束时间 */
    private LocalDateTime endTime;

    /** 操作人 */
    private String operator;

    /** 生产步骤描述 */
    private String productionStep;

    /** 关联部件ID */
    private Long plan2PartId;

    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
}

