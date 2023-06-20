package com.mouhcine.ContactSpringBoot.services;

import com.mouhcine.ContactSpringBoot.bo.Contact;
import com.mouhcine.ContactSpringBoot.bo.Groupe;
import com.mouhcine.ContactSpringBoot.dao.IContactDao;
import com.mouhcine.ContactSpringBoot.dao.IGroupeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class GroupeServiceImp implements IGroupeService{
    @Autowired
    IGroupeDao groupeDao;

    @Autowired
    IContactDao contactDao;
    @Override
    public List getGroupes() {
        return groupeDao.findAll();
    }

    @Override
    public void createGroupe(Groupe groupe) {
        groupeDao.save(groupe);
    }

    @Override
    public void updateGroupe(Groupe groupe) {
        groupeDao.save(groupe);
    }

    @Override
    @Transactional
    public void deleteGroupe(Long id) {
        Groupe group = groupeDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Group not found"));

        for (Contact contact : group.getContacts()) {
            contact.getGroupes().remove(group);
        }
        contactDao.saveAll(group.getContacts());

        groupeDao.delete(group);

    }

    @Override
    public Optional<Groupe> getById(Long id) {
        return groupeDao.findById(id);
    }

    @Override
    public List<Groupe> getByNom(String nom) {
        return groupeDao.findByNomContainingIgnoreCase(nom);
    }
}
