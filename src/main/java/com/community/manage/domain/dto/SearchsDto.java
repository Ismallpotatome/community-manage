package com.community.manage.domain.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * "分页搜索"公共类
 */
@Data
public class SearchsDto {
    /**
     * 关键字
     */
    private String keyword;
    /**
     * 起始时间
     */
    private String startDate;
    /**
     * 截至时间
     */
    private String endData;
    /**
     * 当前页码
     */
    private int page;
    /**
     * 显示条数
     */
    private int size;
}
