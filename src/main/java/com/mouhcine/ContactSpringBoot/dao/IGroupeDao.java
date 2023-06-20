package com.mouhcine.ContactSpringBoot.dao;

import com.mouhcine.ContactSpringBoot.bo.Contact;
import com.mouhcine.ContactSpringBoot.bo.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGroupeDao extends JpaRepository<Groupe,Long> {
    public List<Groupe> findByNomContainingIgnoreCase(String nom);

}
