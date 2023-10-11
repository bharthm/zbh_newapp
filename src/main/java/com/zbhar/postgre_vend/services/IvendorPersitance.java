package com.zbhar.postgre_vend.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zbhar.postgre_vend.entities.vendor;

public interface IvendorPersitance extends JpaRepository<vendor, String> {
    List<vendor> findByCompanyName(String companyName);

    @Query(nativeQuery = true, value = "SELECT * FROM public.pgvendor where lower(COMPANY_NAME) LIKE %?1%")
    List<vendor> lookupVendor(String companyName);
}
