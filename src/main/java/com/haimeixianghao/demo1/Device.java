package com.haimeixianghao.demo1;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;

@Data
@Table("devices")
public class Device {
    
    @Id
    private Long id;
    
    // 基本信息
    private String deviceCode;        // 设备编码
    private String deviceName;        // 设备名称
    private String manufacturer;      // 生产厂家
    private String brand;            // 品牌
    private String model;            // 规格型号
    private String supplier;         // 供应商
    private LocalDate productionDate; // 生产日期
    private Integer serviceLife;      // 使用年限（年）
    private String depreciationMethod; // 折旧方式
    private String location;         // 位置
    
    // 扩展信息
    private String technicalParams;  // 技术参数信息
    private String sparePartsInfo;   // 备品备件信息
    
    // 系统字段
    private LocalDate createTime;
    private LocalDate updateTime;
}