package com.haimeixianghao.demo1.service;

import com.haimeixianghao.demo1.Device;
import com.haimeixianghao.demo1.entity.*;
import com.haimeixianghao.demo1.repository.*;
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
    private final PartRepository partRepository;
    private final WorkingPlanRepository workingPlanRepository;
    private final WorkingProcedureRepository workingProcedureRepository;
    private final BlankManufacturingRepository blankManufacturingRepository;
    private final MachiningRepository machiningRepository;
    private final ShaftMachiningRepository shaftMachiningRepository;
    private final DimensionalInspectingRepository dimensionalInspectingRepository;
    private final WarehousingRepository warehousingRepository;

    public DataInitializerService(DeviceStore deviceStore,
                                  PartRepository partRepository,
                                  WorkingPlanRepository workingPlanRepository,
                                  WorkingProcedureRepository workingProcedureRepository,
                                  BlankManufacturingRepository blankManufacturingRepository,
                                  MachiningRepository machiningRepository,
                                  ShaftMachiningRepository shaftMachiningRepository,
                                  DimensionalInspectingRepository dimensionalInspectingRepository,
                                  WarehousingRepository warehousingRepository) {
        this.deviceStore = deviceStore;
        this.partRepository = partRepository;
        this.workingPlanRepository = workingPlanRepository;
        this.workingProcedureRepository = workingProcedureRepository;
        this.blankManufacturingRepository = blankManufacturingRepository;
        this.machiningRepository = machiningRepository;
        this.shaftMachiningRepository = shaftMachiningRepository;
        this.dimensionalInspectingRepository = dimensionalInspectingRepository;
        this.warehousingRepository = warehousingRepository;
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
        device1.setImage("https://images.cncjichuang.com/2019-12-13/9207e642-2097-443d-9df9-b41d9a16ce30.jpg");
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
        device2.setImage("http://sendy-cmm.com/userfiles/image/20230607/20230607213825_9714.png");
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
        device3.setImage("http://www.kuntaizz.com/uploadfile/image/20210302/20210302141321_728049816.jpg");
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
        device4.setImage("https://images.cncjichuang.com/2019-12-13/9207e642-2097-443d-9df9-b41d9a16ce30.jpg");
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
        device5.setImage("http://www.hangchasz.com/UpLoad/202212/2022121656622217.jpg");
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
        device6.setImage("http://www.abbrobotgbs.com/uploads/191122/1-191122133334954.jpg");
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
        device7.setImage("http://www.tjsaiyang.cn/siteimages/19772/2019082611043812.jpg");
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

    @Transactional
    public void initializeMaterials() {
        LocalDateTime now = LocalDateTime.now();

        // MAT001 行星齿轮
        Part p1 = new Part();
        p1.setPartCode("MAT001");
        p1.setPartName("行星齿轮");
        p1.setSpecModel("XCL-20");
        p1.setSupplier("齿轮加工厂");
        p1.setStockQuantity(150);
        p1.setCreateTime(now);
        p1.setLastUpdateTime(now);
        partRepository.save(p1);
        log.info("已保存物料: MAT001 - 行星齿轮");

        // MAT002 深沟球轴承
        Part p2 = new Part();
        p2.setPartCode("MAT002");
        p2.setPartName("深沟球轴承");
        p2.setSpecModel("6204-2RS");
        p2.setSupplier("轴承厂");
        p2.setStockQuantity(45);
        p2.setCreateTime(now);
        p2.setLastUpdateTime(now);
        partRepository.save(p2);
        log.info("已保存物料: MAT002 - 深沟球轴承");

        // MAT003 O型密封圈
        Part p3 = new Part();
        p3.setPartCode("MAT003");
        p3.setPartName("O型密封圈");
        p3.setSpecModel("OR-30x3.5");
        p3.setSupplier("密封件厂");
        p3.setStockQuantity(320);
        p3.setCreateTime(now);
        p3.setLastUpdateTime(now);
        partRepository.save(p3);
        log.info("已保存物料: MAT003 - O型密封圈");

        // MAT004 行星架
        Part p4 = new Part();
        p4.setPartCode("MAT004");
        p4.setPartName("行星架");
        p4.setSpecModel("XJ-15");
        p4.setSupplier("铸造厂");
        p4.setStockQuantity(28);
        p4.setCreateTime(now);
        p4.setLastUpdateTime(now);
        partRepository.save(p4);
        log.info("已保存物料: MAT004 - 行星架");

        // MAT005 内六角螺钉
        Part p5 = new Part();
        p5.setPartCode("MAT005");
        p5.setPartName("内六角螺钉");
        p5.setSpecModel("M8x25");
        p5.setSupplier("标准件厂");
        p5.setStockQuantity(580);
        p5.setCreateTime(now);
        p5.setLastUpdateTime(now);
        partRepository.save(p5);
        log.info("已保存物料: MAT005 - 内六角螺钉");

        // MAT006 PCB板
        Part p6 = new Part();
        p6.setPartCode("MAT006");
        p6.setPartName("PCB板");
        p6.setSpecModel("DRV-8301");
        p6.setSupplier("电子厂");
        p6.setStockQuantity(85);
        p6.setCreateTime(now);
        p6.setLastUpdateTime(now);
        partRepository.save(p6);
        log.info("已保存物料: MAT006 - PCB板");

        log.info("所有物料保存完成，共 6 条");
    }

    @Transactional
    public void initializeWorkingPlansAndProcedures() {
        LocalDateTime now = LocalDateTime.now();

        // 工艺路线1: 中心轮零件加工
        WorkingPlan plan1 = new WorkingPlan();
        plan1.setPlanCode("ROUTE001");
        plan1.setPlanName("中心轮零件加工");
        plan1.setVersion("1.0");
        plan1.setEquipmentUsage("数控车床、数控铣床、铸造机、三坐标测量仪、叉车");
        plan1.setOperator("综合");
        plan1.setOperationTime(now);
        plan1.setCreateTime(now);
        plan1.setLastUpdateTime(now);
        WorkingPlan savedPlan = workingPlanRepository.save(plan1);
        log.info("已保存工艺: ROUTE001 - 中心轮零件加工, id={}", savedPlan.getId());

        // 独立工序数据 (processes)
        // P001 毛坯制造
        WorkingProcedure proc1 = new WorkingProcedure();
        proc1.setProcedureCode("P001");
        proc1.setProcedureName("毛坯制造");
        proc1.setProductionStep("铸造/锻造");
        proc1.setOperator("张三");
        proc1.setStartTime(LocalDateTime.of(2024, 1, 1, 8, 0));
        proc1.setEndTime(LocalDateTime.of(2024, 1, 1, 12, 0));
        proc1.setPlan2PartId(savedPlan.getId());
        proc1.setCreateTime(now);
        proc1.setLastUpdateTime(now);
        workingProcedureRepository.save(proc1);
        log.info("已保存工序: P001 - 毛坯制造");

        // P002 粗加工
        WorkingProcedure proc2 = new WorkingProcedure();
        proc2.setProcedureCode("P002");
        proc2.setProcedureName("粗加工");
        proc2.setProductionStep("铣削、钻孔");
        proc2.setOperator("李四");
        proc2.setStartTime(LocalDateTime.of(2024, 1, 1, 13, 0));
        proc2.setEndTime(LocalDateTime.of(2024, 1, 1, 17, 0));
        proc2.setPlan2PartId(savedPlan.getId());
        proc2.setCreateTime(now);
        proc2.setLastUpdateTime(now);
        workingProcedureRepository.save(proc2);
        log.info("已保存工序: P002 - 粗加工");

        // P003 精加工
        WorkingProcedure proc3 = new WorkingProcedure();
        proc3.setProcedureCode("P003");
        proc3.setProcedureName("精加工");
        proc3.setProductionStep("车削、磨削");
        proc3.setOperator("王五");
        proc3.setStartTime(LocalDateTime.of(2024, 1, 2, 8, 0));
        proc3.setEndTime(LocalDateTime.of(2024, 1, 2, 16, 0));
        proc3.setPlan2PartId(savedPlan.getId());
        proc3.setCreateTime(now);
        proc3.setLastUpdateTime(now);
        workingProcedureRepository.save(proc3);
        log.info("已保存工序: P003 - 精加工");

        // P004 检测
        WorkingProcedure proc4 = new WorkingProcedure();
        proc4.setProcedureCode("P004");
        proc4.setProcedureName("检测");
        proc4.setProductionStep("三坐标测量");
        proc4.setOperator("赵六");
        proc4.setStartTime(LocalDateTime.of(2024, 1, 3, 9, 0));
        proc4.setEndTime(LocalDateTime.of(2024, 1, 3, 11, 0));
        proc4.setPlan2PartId(savedPlan.getId());
        proc4.setCreateTime(now);
        proc4.setLastUpdateTime(now);
        workingProcedureRepository.save(proc4);
        log.info("已保存工序: P004 - 检测");

        // P005 入库
        WorkingProcedure proc5 = new WorkingProcedure();
        proc5.setProcedureCode("P005");
        proc5.setProcedureName("入库");
        proc5.setProductionStep("包装、入库");
        proc5.setOperator("钱七");
        proc5.setStartTime(LocalDateTime.of(2024, 1, 3, 14, 0));
        proc5.setEndTime(LocalDateTime.of(2024, 1, 3, 16, 0));
        proc5.setPlan2PartId(savedPlan.getId());
        proc5.setCreateTime(now);
        proc5.setLastUpdateTime(now);
        workingProcedureRepository.save(proc5);
        log.info("已保存工序: P005 - 入库");

        // P006 热处理
        WorkingProcedure proc6 = new WorkingProcedure();
        proc6.setProcedureCode("P006");
        proc6.setProcedureName("热处理");
        proc6.setProductionStep("淬火、回火");
        proc6.setOperator("孙八");
        proc6.setStartTime(LocalDateTime.of(2024, 1, 4, 8, 0));
        proc6.setEndTime(LocalDateTime.of(2024, 1, 4, 12, 0));
        proc6.setPlan2PartId(savedPlan.getId());
        proc6.setCreateTime(now);
        proc6.setLastUpdateTime(now);
        workingProcedureRepository.save(proc6);
        log.info("已保存工序: P006 - 热处理");

        log.info("所有工艺及工序保存完成");
    }

    @Transactional
    public void initializeProcessChain() {
        LocalDateTime now = LocalDateTime.now();

        // 入库记录
        Warehousing warehousing = new Warehousing();
        warehousing.setCreateTime(now);
        warehousing.setLastUpdateTime(now);
        Warehousing savedWarehousing = warehousingRepository.save(warehousing);
        log.info("已保存入库记录, id={}", savedWarehousing.getId());

        // 尺寸检测（IQC 关联入库）
        DimensionalInspecting iqc = new DimensionalInspecting();
        iqc.setIqcWarehousingId(savedWarehousing.getId());
        iqc.setCreateTime(now);
        iqc.setLastUpdateTime(now);
        DimensionalInspecting savedIqc = dimensionalInspectingRepository.save(iqc);
        log.info("已保存尺寸检测(IQC), id={}", savedIqc.getId());

        // 轴类零件加工（FQC 关联尺寸检测）
        ShaftMachining shaftMachining = new ShaftMachining();
        shaftMachining.setFqcDimensionalInspectingId(savedIqc.getId());
        shaftMachining.setCreateTime(now);
        shaftMachining.setLastUpdateTime(now);
        ShaftMachining savedShaft = shaftMachiningRepository.save(shaftMachining);
        log.info("已保存轴类零件加工, id={}", savedShaft.getId());

        // 机械加工（关联轴类零件加工）
        Machining machining = new Machining();
        machining.setMachiningShaftMachiningId(savedShaft.getId());
        machining.setCreateTime(now);
        machining.setLastUpdateTime(now);
        Machining savedMachining = machiningRepository.save(machining);
        log.info("已保存机械加工, id={}", savedMachining.getId());

        // 毛坯制造（关联机械加工）
        BlankManufacturing blankManufacturing = new BlankManufacturing();
        blankManufacturing.setMachiningId(savedMachining.getId());
        blankManufacturing.setCreateTime(now);
        blankManufacturing.setLastUpdateTime(now);
        BlankManufacturing savedBlank = blankManufacturingRepository.save(blankManufacturing);
        log.info("已保存毛坯制造, id={}", savedBlank.getId());

        log.info("工艺过程链初始化完成");
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

