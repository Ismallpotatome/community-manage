package com.community.manage.domain.dto;

import com.community.manage.domain.entity.TbParkingUser;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ParkingUseDto extends TbParkingUser  implements Serializable {
    List<ParkingUseDto> list;

}
