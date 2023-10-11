package com.zbhar.postgre_vend.controller;

//import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zbhar.postgre_vend.entities.*;
import com.zbhar.postgre_vend.services.*;

@RestController
public class VendorController {
    @Autowired
    public VendorService myVendorSrv;

    @RequestMapping("/pgvendor")
    public List<vendor> getAll() {
        return myVendorSrv.getAllVendors();
    }

    @RequestMapping("/pgvendor/search")
    public List<vendor> searchByCompanyName(@RequestParam String company) {
        return myVendorSrv.searchByCompanyName(company);
    }

    @RequestMapping("/pgvendor/lookup/{comp}")
    public List<vendor> lookupVendor(@PathVariable("comp") String compNam) {
        return myVendorSrv.lookupVendor(compNam);
    }

    @RequestMapping("/pgvendor/{vendorCode}")
    public vendor getVendorById(@PathVariable("vendorCode") String code) {
        Optional<vendor> searchResult = myVendorSrv.readVendorById(code);
        if (!searchResult.isPresent()) {
            return new vendor();
        }
        return searchResult.get();
    }

    @PostMapping("/crvendor")
    public vendor createVendor(@RequestBody vendor myPostBody) {
        return myVendorSrv.createVendor(myPostBody);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/vendor")
    public vendor changeVendor(@RequestBody vendor vendor) {
        return myVendorSrv.changeVendor(vendor);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/pgvendor/{code}")
    public String removeVendor(@PathVariable("code") String code) {
        return myVendorSrv.deleteVendor(code);
    }
}
