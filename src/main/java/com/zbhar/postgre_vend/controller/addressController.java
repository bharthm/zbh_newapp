package com.zbhar.postgre_vend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zbhar.postgre_vend.entities.address;
import com.zbhar.postgre_vend.services.addressService;

@RestController
public class addressController {
    @Autowired
    public addressService myAdrSrv;

    @RequestMapping("/pgaddress")
    public List<address> getAllAddress() {
        return myAdrSrv.getAllAddress();

    }

    @PostMapping("/craddress")
    public address createAddress(@RequestBody address myPostBody) {
        return myAdrSrv.createVendor(myPostBody);

    }

}
