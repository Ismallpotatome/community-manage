package com.community.manage.controller;

import com.community.manage.util.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/charge")
public class ChargeController {
    @RequestMapping("shows")
    public ResponseEntity showAllCharge(){
        return null;
    }
}
