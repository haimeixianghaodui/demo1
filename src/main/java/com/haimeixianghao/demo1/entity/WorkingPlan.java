package com.haimeixianghao.demo1.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * 工艺 (DM07182087)
 */
@Data
@Table("working_plan")
public class WorkingPlan {

    @Id
    private Long id;

    /** 工艺编号 */
    private String planCode;

    /** 工艺名称 */
    private String planName;

    /** 版本号 */
    private String version;

    /** 操作时间 */
    private LocalDateTime operationTime;

    /** 设备使用情况 */
    private String equipmentUsage;

    /** 操作人员 */
    private String operator;

    /** 关联部件ID（组合关系） */
    private Long plan1PartId;

    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
}

