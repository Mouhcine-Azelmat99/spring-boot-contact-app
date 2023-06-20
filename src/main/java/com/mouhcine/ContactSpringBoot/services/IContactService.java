package com.mouhcine.ContactSpringBoot.services;

import com.mouhcine.ContactSpringBoot.bo.Contact;

import java.util.List;
import java.util.Optional;

public interface IContactService {

    public List getContacts();
    public void createContact(Contact contact);
    public void updateContact(Contact contact);
    public void deleteContact(Long id);
    public Optional<Contact> getById(Long id);

    public List<Contact> getByNom(String nom);
    public List<Contact> getByTel1(String tel);
    public List<Contact> getByTel2(String tel);

}
