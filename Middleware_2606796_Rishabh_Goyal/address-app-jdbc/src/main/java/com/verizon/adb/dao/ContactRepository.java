package com.verizon.adb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.adb.model.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
