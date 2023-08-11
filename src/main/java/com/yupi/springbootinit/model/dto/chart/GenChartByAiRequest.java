package com.yupi.springbootinit.model.dto.chart;

import lombok.Data;

/**
 * @author 季 雷
 * @version 1.0
 * @Date 2023/07/22/22:53
 */
@Data
public class GenChartByAiRequest {

    /**
     * 名称
     */
    private String name;

    /**
     * 分析目标
     */
    private String goal;

    /**
     * 图表类型
     */
    private String chartType;


    private static final long serialVersionUID = 1L;
}
