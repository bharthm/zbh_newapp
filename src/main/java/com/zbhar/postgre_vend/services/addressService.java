package com.zbhar.postgre_vend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zbhar.postgre_vend.entities.address;
import com.zbhar.postgre_vend.entities.vendor;

@Component
public class addressService {
    @Autowired
    private IaddressPersistance addressDB;

    public List<address> getAllAddress() {
        return addressDB.findAll();
    }

    public address createVendor(address newAddress) {
        return addressDB.save(newAddress);
    }
}
