package com.community.manage.controller;

import com.community.manage.domain.bo.Desktop;
import com.community.manage.service.DesktopService;
import com.community.manage.util.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DesktopController {
    @Resource
    DesktopService desktopService;

    /**
     * 返回对应的所有的信息
     * @return
     */
    @RequestMapping("desktop")
    public ResponseEntity<Desktop> showDesktop(){

        Desktop desktop = desktopService.packageDesktop();

        return ResponseEntity.success(desktop);
    }
}
