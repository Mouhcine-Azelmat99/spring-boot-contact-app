package com.mouhcine.ContactSpringBoot.dao;

import com.mouhcine.ContactSpringBoot.bo.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IContactDao extends JpaRepository<Contact,Long> {
    public List<Contact> findAllByOrderByNomAsc();
    public List<Contact> findByNomContainingIgnoreCase(String nom);
    public List<Contact> findByTel1ContainingIgnoreCase(String tel);
    public List<Contact> findByTel2ContainingIgnoreCase(String tel);

}
