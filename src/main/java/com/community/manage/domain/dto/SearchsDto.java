package com.community.manage.domain.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
//"分页搜索"公共类
public class SearchsDto {
    private String keyword;
    private String startDate;
    private String endData;
    private int page;
    private int size;
}
