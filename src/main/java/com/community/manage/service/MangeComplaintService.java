package com.community.manage.service;

import com.community.manage.domain.dto.MangeComplaintDto;
import com.community.manage.domain.dto.SearchsDto;
import com.community.manage.domain.entity.TbMangeComplaint;
import com.community.manage.util.ResponseEntity;

import java.util.List;

public interface MangeComplaintService {
    List<TbMangeComplaint> selectAll(SearchsDto searchsDto, int limit, int offset);


    ResponseEntity insert(MangeComplaintDto mangeComplaintDto);



    ResponseEntity updateAll(MangeComplaintDto mangeComplaintDto);

    ResponseEntity del(List<MangeComplaintDto> list);
}
