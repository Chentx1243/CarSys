package com.xshxy.carsysdemo.bean;

import dev.langchain4j.model.output.structured.Description;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@Description("驾驶行为分析与预测结果，包含原始传感器数据和衍生分析指标")
public class AutoAnalysis {
    // =============== 原始数据字段 ===============
    @Description("车辆唯一标识符，关联vehicle_info和vehicle_ownership表")
    private Integer vehicleId;

    @Description("车辆型号名称，如'Audi Q5'")
    private String vehicleModel;

    @Description("驾驶员唯一标识符，关联driver_info表")
    private Integer driverId;

    @Description("驾驶员真实姓名，如果没有提取到数据，就默认填写默认值：默认返回值值是'狗修金杀马'")
    private String driverName;

    @Description("当前瞬时车速（单位：km/h）")
    private Float currentSpeed;

    @Description("环境温度（单位：摄氏度）")
    private Float temperature;

    @Description("环境湿度（单位：百分比 0-100%）")
    private Float humidity;

    @Description("每分钟眨眼次数，用于疲劳检测")
    private Integer blinkFrequency;

    @Description("每小时打哈欠次数，用于疲劳检测")
    private Integer yawningCount;

    // =============== 预测/分析字段 ===============
    // 1. 风险预测类
    @Description("疲劳风险综合评分（0-100分），值越高风险越大")
    private Float fatigueRiskScore;

    @Description("疲劳等级分类（LOW/MEDIUM/HIGH）")
    private String fatigueLevel;

    @Description("激进驾驶评分（0-100分），基于急加减速和超速行为")
    private Float aggressiveDrivingScore;

    @Description("天气风险标志，true表示高温/高湿等危险天气条件")
    private Boolean isWeatherRisk;

    // 2. 效率分析类
    @Description("车辆日均使用时长（单位：小时）")
    private Float dailyUsageHours;

    @Description("最常出现的高频驾驶时段（如18:30表示下班高峰）")
    private LocalTime peakDrivingTime;

    // 3. 驾驶员画像类
    @Description("驾驶风格分类（CONSERVATIVE-保守型/NORMAL-正常/AGGRESSIVE-激进型）")
    private String drivingStyle;

    @Description("夜间驾驶时间占比（0.0-1.0，如0.25表示25%行程在夜间）")
    private Float nightDrivingRatio;

    @Description("对本次驾驶分析的一个文字性的总结与描述，要求语言专业，热情，关怀，字数180字左右")
    private String summarize;
}
