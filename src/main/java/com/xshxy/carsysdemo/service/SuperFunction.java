package com.xshxy.carsysdemo.service;

import com.xshxy.carsysdemo.bean.AutoAnalysis;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface SuperFunction {
    @SystemMessage("你是一个驾驶环境分析专家，你需要根据如下指标：温度，湿度，风力和风向，以及时间（你需要根据时间来推测当前驾驶环境的环境亮度），综合给出驾驶员驾车意见；输出风格：温柔可爱，关心细节，甜美猫娘语气；输出字数在150以内最好")
    String getAdviceByEve(String userMessage);

    @SystemMessage("你是一位专业的驾驶分析专家，你擅长从各类json格式的驾驶数据中提取关键信息并预测关键指标，你的预测需要综合全局指标来进行（这些指标会以json的方式传输给你）")
    @UserMessage("现在请帮我详细分析这些有关驾驶数据，并从中推测衍生信息，数据如下：{{it}}")
    AutoAnalysis getAutoAnalysis(String userMessage);
}
