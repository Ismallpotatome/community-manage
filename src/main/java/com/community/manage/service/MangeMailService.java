package com.community.manage.service;

import com.community.manage.domain.dto.MangeActivityDto;
import com.community.manage.domain.dto.MangeMailDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.TbMangeMail;
import com.community.manage.util.ResponseEntity;

import java.util.List;

public interface MangeMailService {

    List<MangeMailDto> selectAll(SearchsDto searchsDto, int limit, int offset);


    ResponseEntity insert(MangeMailDto mangeMainDto);



    ResponseEntity updateAll(MangeMailDto mangeMainDto);

    ResponseEntity del(List<MangeMailDto> list);
}
