-- ==============================
-- 设备 (Equitment / DM07175446)
-- ==============================
DROP TABLE IF EXISTS "devices";
CREATE TABLE "devices" (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    DEVICE_CODE VARCHAR(100),
    DEVICE_NAME VARCHAR(10),
    MANUFACTURER VARCHAR(20),
    BRAND VARCHAR(20),
    MODEL VARCHAR(20),
    SUPPLIER VARCHAR(20),
    PRODUCTION_DATE VARCHAR(20),
    SERVICE_LIFE VARCHAR(20),
    DEPRECIATION_METHOD VARCHAR(20),
    LOCATION VARCHAR(30),
    STATUS VARCHAR(20),
    TYPE VARCHAR(50),
    IMAGE VARCHAR(500),
    TECHNICAL_PARAMS TEXT,
    SPARE_PARTS_INFO TEXT,
    CREATE_TIME TIMESTAMP,
    UPDATE_TIME TIMESTAMP
);

-- ==============================
-- 部件 (Part / DM07181957)
-- ==============================
DROP TABLE IF EXISTS "part";
CREATE TABLE "part" (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    PART_CODE VARCHAR(200),
    PART_NAME VARCHAR(200),
    SPEC_MODEL VARCHAR(200),
    SUPPLIER VARCHAR(200),
    STOCK_QUANTITY INTEGER DEFAULT 0,
    USED_EQUIPMENT_ID BIGINT,
    CREATE_TIME TIMESTAMP,
    LAST_UPDATE_TIME TIMESTAMP
);

-- ==============================
-- 工艺 (WorkingPlan / DM07182087)
-- ==============================
DROP TABLE IF EXISTS "working_plan";
CREATE TABLE "working_plan" (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    PLAN_CODE VARCHAR(200),
    PLAN_NAME VARCHAR(200),
    VERSION VARCHAR(200),
    OPERATION_TIME TIMESTAMP,
    EQUIPMENT_USAGE VARCHAR(200),
    OPERATOR VARCHAR(200),
    PLAN1_PART_ID BIGINT,
    CREATE_TIME TIMESTAMP,
    LAST_UPDATE_TIME TIMESTAMP
);

-- ==============================
-- 工序 (WorkingProcedure / DM07182035)
-- ==============================
DROP TABLE IF EXISTS "working_procedure";
CREATE TABLE "working_procedure" (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    PROCEDURE_CODE VARCHAR(200),
    PROCEDURE_NAME VARCHAR(200),
    START_TIME TIMESTAMP,
    END_TIME TIMESTAMP,
    OPERATOR VARCHAR(200),
    PRODUCTION_STEP VARCHAR(200),
    PLAN2_PART_ID BIGINT,
    CREATE_TIME TIMESTAMP,
    LAST_UPDATE_TIME TIMESTAMP
);

-- ==============================
-- 入库 (Warehousing / DM07192686)
-- ==============================
DROP TABLE IF EXISTS "warehousing";
CREATE TABLE "warehousing" (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    IN_PART_ID BIGINT,
    CREATE_TIME TIMESTAMP,
    LAST_UPDATE_TIME TIMESTAMP
);

-- ==============================
-- 尺寸检测 (DimensionalInspecting / DM07192683)
-- ==============================
DROP TABLE IF EXISTS "dimensional_inspecting";
CREATE TABLE "dimensional_inspecting" (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    IQC_WAREHOUSING_ID BIGINT,
    CREATE_TIME TIMESTAMP,
    LAST_UPDATE_TIME TIMESTAMP
);

-- ==============================
-- 轴类零件加工 (ShaftMachining / DM07192672)
-- ==============================
DROP TABLE IF EXISTS "shaft_machining";
CREATE TABLE "shaft_machining" (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    FQC_DIMENSIONAL_INSPECTING_ID BIGINT,
    CREATE_TIME TIMESTAMP,
    LAST_UPDATE_TIME TIMESTAMP
);

-- ==============================
-- 机械加工 (Machining / DM07192658)
-- ==============================
DROP TABLE IF EXISTS "machining";
CREATE TABLE "machining" (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    MACHINING_SHAFT_MACHINING_ID BIGINT,
    CREATE_TIME TIMESTAMP,
    LAST_UPDATE_TIME TIMESTAMP
);

-- ==============================
-- 毛坯制造 (BlankManufacturing / DM07182563)
-- ==============================
DROP TABLE IF EXISTS "blank_manufacturing";
CREATE TABLE "blank_manufacturing" (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    MACHINING_ID BIGINT,
    CREATE_TIME TIMESTAMP,
    LAST_UPDATE_TIME TIMESTAMP
);