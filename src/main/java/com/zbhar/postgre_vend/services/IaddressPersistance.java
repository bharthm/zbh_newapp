package com.zbhar.postgre_vend.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zbhar.postgre_vend.entities.address;

public interface IaddressPersistance extends JpaRepository<address, String> {

}
