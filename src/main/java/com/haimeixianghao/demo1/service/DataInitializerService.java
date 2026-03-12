package com.haimeixianghao.demo1.service;

import com.haimeixianghao.demo1.Device;
import com.haimeixianghao.demo1.store.DeviceStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DataInitializerService {

    private static final Logger log = LoggerFactory.getLogger(DataInitializerService.class);
    private final DeviceStore deviceStore;

    public DataInitializerService(DeviceStore deviceStore) {
        this.deviceStore = deviceStore;
    }

    @Transactional
    public void initializeDevices() {
        List<Device> devices = new ArrayList<>();

        // Device 1: 数控车床
        Device device1 = new Device();
        device1.setDeviceCode("DEV001");
        device1.setDeviceName("数控车床");
        device1.setManufacturer("沈阳机床");
        device1.setBrand("SMTCL");
        device1.setModel("CAK5085");
        device1.setSupplier("沈阳机床");
        device1.setProductionDate("2023-05-10");
        device1.setServiceLife("10");
        device1.setDepreciationMethod("年限平均法");
        device1.setLocation("A车间-01区");
        device1.setStatus("operating");
        device1.setType("机床");
        device1.setImage("https://images.unsplash.com/photo-1581091226033-d5c48150dbaa?w=400");
        device1.setTechnicalParams(createParamsJson(
            Map.of("主轴转速", "8000rpm", "加工精度", "±0.005mm", "功率", "15kW", "重量", "3500kg")
        ));
        device1.setCreateTime(LocalDateTime.now());
        device1.setUpdateTime(LocalDateTime.now());
        devices.add(device1);

        // Device 2: 三坐标测量仪
        Device device2 = new Device();
        device2.setDeviceCode("DEV002");
        device2.setDeviceName("三坐标测量");
        device2.setManufacturer("海克斯康");
        device2.setBrand("Hexagon");
        device2.setModel("GLOBAL S");
        device2.setSupplier("海克斯康");
        device2.setProductionDate("2023-08-15");
        device2.setServiceLife("8");
        device2.setDepreciationMethod("双倍余额递减");
        device2.setLocation("质检中心-03区");
        device2.setStatus("operating");
        device2.setType("测量仪");
        device2.setImage("https://images.unsplash.com/photo-1581092918056-0c4c3acd4c9f?w=400");
        device2.setTechnicalParams(createParamsJson(
            Map.of("测量范围", "1000x800x600mm", "精度", "1.5μm", "分辨率", "0.1μm")
        ));
        device2.setCreateTime(LocalDateTime.now());
        device2.setUpdateTime(LocalDateTime.now());
        devices.add(device2);

        // Device 3: 铸造机
        Device device3 = new Device();
        device3.setDeviceCode("DEV003");
        device3.setDeviceName("铸造机");
        device3.setManufacturer("铸造机械厂");
        device3.setBrand("Foundry");
        device3.setModel("ZJ-2000");
        device3.setSupplier("铸造机械厂");
        device3.setProductionDate("2023-02-20");
        device3.setServiceLife("15");
        device3.setDepreciationMethod("年限平均法");
        device3.setLocation("铸造车间-01区");
        device3.setStatus("idle");
        device3.setType("铸造机");
        device3.setImage("");
        device3.setTechnicalParams(createParamsJson(
            Map.of("合模力", "2000kN", "模板尺寸", "800x800mm", "加热功率", "45kW")
        ));
        device3.setCreateTime(LocalDateTime.now());
        device3.setUpdateTime(LocalDateTime.now());
        devices.add(device3);

        // Device 4: 数控铣床
        Device device4 = new Device();
        device4.setDeviceCode("DEV004");
        device4.setDeviceName("数控铣床");
        device4.setManufacturer("大连机床");
        device4.setBrand("DMTG");
        device4.setModel("XK714");
        device4.setSupplier("大连机床");
        device4.setProductionDate("2023-06-18");
        device4.setServiceLife("10");
        device4.setDepreciationMethod("年限平均法");
        device4.setLocation("加工车间-02区");
        device4.setStatus("operating");
        device4.setType("机床");
        device4.setImage("");
        device4.setTechnicalParams(createParamsJson(
            Map.of("主轴转速", "6000rpm", "工作台尺寸", "400x800mm", "功率", "11kW")
        ));
        device4.setCreateTime(LocalDateTime.now());
        device4.setUpdateTime(LocalDateTime.now());
        devices.add(device4);

        // Device 5: 叉车
        Device device5 = new Device();
        device5.setDeviceCode("DEV005");
        device5.setDeviceName("叉车");
        device5.setManufacturer("杭叉");
        device5.setBrand("HC");
        device5.setModel("CPD30");
        device5.setSupplier("杭叉集团");
        device5.setProductionDate("2023-09-05");
        device5.setServiceLife("8");
        device5.setDepreciationMethod("双倍余额递减");
        device5.setLocation("仓储中心");
        device5.setStatus("maintenance");
        device5.setType("叉车");
        device5.setImage("https://images.unsplash.com/photo-1581092335871-4c7c7d2b5b3d?w=400");
        device5.setTechnicalParams(createParamsJson(
            Map.of("额定载荷", "3000kg", "起升高度", "3000mm", "电池容量", "48V/600Ah")
        ));
        device5.setCreateTime(LocalDateTime.now());
        device5.setUpdateTime(LocalDateTime.now());
        devices.add(device5);

        // Device 6: 工业机器人
        Device device6 = new Device();
        device6.setDeviceCode("DEV006");
        device6.setDeviceName("工业机器人");
        device6.setManufacturer("ABB");
        device6.setBrand("ABB");
        device6.setModel("IRB 6700");
        device6.setSupplier("ABB");
        device6.setProductionDate("2023-11-20");
        device6.setServiceLife("12");
        device6.setDepreciationMethod("年限平均法");
        device6.setLocation("装配车间-05区");
        device6.setStatus("operating");
        device6.setType("机器人");
        device6.setImage("https://images.unsplash.com/photo-1581092335871-4c7c7d2b5b3d?w=400");
        device6.setTechnicalParams(createParamsJson(
            Map.of("负载能力", "150kg", "工作半径", "2.6m", "重复精度", "0.05mm")
        ));
        device6.setCreateTime(LocalDateTime.now());
        device6.setUpdateTime(LocalDateTime.now());
        devices.add(device6);

        // Device 7: 热处理炉
        Device device7 = new Device();
        device7.setDeviceCode("DEV007");
        device7.setDeviceName("热处理炉");
        device7.setManufacturer("热处理设备厂");
        device7.setBrand("HeatPro");
        device7.setModel("HT-1200");
        device7.setSupplier("热处理设备厂");
        device7.setProductionDate("2023-04-12");
        device7.setServiceLife("12");
        device7.setDepreciationMethod("年限平均法");
        device7.setLocation("热处理车间-01");
        device7.setStatus("idle");
        device7.setType("热处理");
        device7.setImage("");
        device7.setTechnicalParams(createParamsJson(
            Map.of("最高温度", "1200°C", "炉膛尺寸", "1000x800x600mm", "功率", "75kW")
        ));
        device7.setCreateTime(LocalDateTime.now());
        device7.setUpdateTime(LocalDateTime.now());
        devices.add(device7);

        // Device 8: 激光切割机
        Device device8 = new Device();
        device8.setDeviceCode("DEV008");
        device8.setDeviceName("激光切割机");
        device8.setManufacturer("大族激光");
        device8.setBrand("Han's Laser");
        device8.setModel("G3015F");
        device8.setSupplier("大族激光");
        device8.setProductionDate("2023-07-22");
        device8.setServiceLife("10");
        device8.setDepreciationMethod("年限平均法");
        device8.setLocation("切割车间-02区");
        device8.setStatus("offline");
        device8.setType("机床");
        device8.setImage("");
        device8.setTechnicalParams(createParamsJson(
            Map.of("激光功率", "3000W", "切割厚度", "20mm", "工作台面", "1500x3000mm")
        ));
        device8.setCreateTime(LocalDateTime.now());
        device8.setUpdateTime(LocalDateTime.now());
        devices.add(device8);

        // 保存所有设备
        log.info("准备保存 {} 个设备", devices.size());
        for (Device device : devices) {
            try {
                Device saved = deviceStore.save(device);
                log.info("已保存设备: {} - {}", saved.getId(), saved.getDeviceName());

                // 立即验证是否能查询到
                if (deviceStore.findById(saved.getId()).isEmpty()) {
                    log.error("警告：设备 {} 保存后无法查询到！", saved.getId());
                }
            } catch (Exception e) {
                log.error("保存设备失败: {}", device.getDeviceName(), e);
            }
        }
        log.info("所有设备保存完成");

        // 最终验证
        log.info("验证：尝试查询所有设备...");
        List<Device> allDevices = deviceStore.findAll();
        log.info("验证结果：数据库中共有 {} 个设备", allDevices.size());
    }

    private String createParamsJson(Map<String, String> params) {
        StringBuilder json = new StringBuilder("[");
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (!first) {
                json.append(",");
            }
            json.append("{\"name\":\"").append(entry.getKey())
                .append("\",\"value\":\"").append(entry.getValue()).append("\"}");
            first = false;
        }
        json.append("]");
        return json.toString();
    }
}

