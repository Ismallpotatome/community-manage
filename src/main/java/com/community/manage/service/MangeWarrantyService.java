package com.community.manage.service;

import com.community.manage.domain.dto.MangeActivityDto;
import com.community.manage.domain.dto.MangeWarrantyDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.TbMangeActivity;
import com.community.manage.domain.entity.TbMangeWarranty;
import com.community.manage.util.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MangeWarrantyService {

    List<TbMangeWarranty> selectAll(SearchsDto searchsDto, int limit, int offset);


    ResponseEntity insert(MangeWarrantyDto mangeWarrantyDto);



    ResponseEntity updateAll(MangeWarrantyDto mangeWarrantyDto);

    ResponseEntity del(List<MangeWarrantyDto> list);
}
