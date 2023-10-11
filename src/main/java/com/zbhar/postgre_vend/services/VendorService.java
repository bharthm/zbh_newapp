package com.zbhar.postgre_vend.services;

//import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zbhar.postgre_vend.entities.*;

@Component
public class VendorService {

    @Autowired
    private IvendorPersitance vendorDB;

    // Read all vendors - Return a internal table
    public List<vendor> getAllVendors() {
        // Fire SELECT * FROM dbtab
        return vendorDB.findAll();
    }

    // Read single vendor by KEY - READ TABLE itab WITH KEY
    public Optional<vendor> readVendorById(String code) {
        return vendorDB.findById(code);
    }

    // Add new record to vendors - APPEND wa to ITAB
    public vendor createVendor(vendor newVendor) {
        return vendorDB.save(newVendor);
    }

    public vendor updateVendorById(String vendorId, vendor vendorData) {
        Optional<vendor> vendorFound = vendorDB.findById(vendorId);
        // vendorFound.setCompanyName(vendorData.getCompanyName());
        return vendorDB.save(vendorData);
    }

    public vendor changeVendor(vendor payload) {
        Optional<vendor> myVendor = vendorDB.findById(payload.getCode());
        if (!myVendor.isPresent()) {
            return new vendor();
        }
        return vendorDB.save(payload);
    }

    public String deleteVendor(String vendorId) {
        vendorDB.deleteById(vendorId);
        return "Object was deleted";
    }

    public java.util.List<vendor> searchByCompanyName(String companyName) {
        return vendorDB.findByCompanyName(companyName);
    }

    public java.util.List<vendor> lookupVendor(String compNam) {
        return vendorDB.lookupVendor(compNam);
    }
}
