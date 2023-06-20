package com.mouhcine.ContactSpringBoot.services;

import com.mouhcine.ContactSpringBoot.bo.Contact;
import com.mouhcine.ContactSpringBoot.bo.Groupe;
import com.mouhcine.ContactSpringBoot.dao.IContactDao;
import com.mouhcine.ContactSpringBoot.dao.IGroupeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImp implements IContactService{

    private IContactDao contactDao;

    @Override
    public List getContacts() {
        return contactDao.findAllByOrderByNomAsc();
    }

    @Override
    public void createContact(Contact c) {
        contactDao.save(c);
    }

    @Override
    public void updateContact(Contact c) {
        this.contactDao.save(c);
    }

    public ContactServiceImp() {}

    @Autowired
    public ContactServiceImp(IContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public void deleteContact(Long id) {
        this.contactDao.deleteById(id);
    }

    @Override
    public Optional<Contact> getById(Long id) {
        return contactDao.findById(id);
    }

    @Override
    public List<Contact> getByNom(String nom) {
        return contactDao.findByNomContainingIgnoreCase(nom);
    }

    @Override
    public List<Contact> getByTel1(String tel) {
        return contactDao.findByTel1ContainingIgnoreCase(tel);
    }

    @Override
    public List<Contact> getByTel2(String tel) {
        return contactDao.findByTel2ContainingIgnoreCase(tel);
    }

}
