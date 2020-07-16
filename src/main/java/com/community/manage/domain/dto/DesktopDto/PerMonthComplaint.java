package com.community.manage.domain.dto.DesktopDto;

import lombok.Data;

import java.io.Serializable;
@Data
public class PerMonthComplaint implements Serializable {
    private String month;
    private Integer complaintCount;
}
