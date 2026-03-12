package com.haimeixianghao.demo1.config;

import com.haimeixianghao.demo1.service.DataInitializerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);
    private final DataInitializerService dataInitializerService;

    public DataInitializer(DataInitializerService dataInitializerService) {
        this.dataInitializerService = dataInitializerService;
    }

    @Override
    public void run(String... args) {
        log.info("开始初始化设备数据...");
        dataInitializerService.initializeDevices();
        log.info("设备数据初始化完成");

        log.info("开始初始化物料数据...");
        dataInitializerService.initializeMaterials();
        log.info("物料数据初始化完成");

        log.info("开始初始化工艺及工序数据...");
        dataInitializerService.initializeWorkingPlansAndProcedures();
        log.info("工艺及工序数据初始化完成");

        log.info("开始初始化工艺过程链数据...");
        dataInitializerService.initializeProcessChain();
        log.info("工艺过程链数据初始化完成");
    }
}
