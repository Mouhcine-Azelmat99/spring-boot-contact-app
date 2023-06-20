package com.mouhcine.ContactSpringBoot.services;

import com.mouhcine.ContactSpringBoot.bo.Groupe;

import java.util.List;
import java.util.Optional;

public interface IGroupeService {
    public List getGroupes();
    public void createGroupe(Groupe groupe);
    public void updateGroupe(Groupe groupe);
    public void deleteGroupe(Long id);
    public Optional<Groupe> getById(Long id);

    public List<Groupe> getByNom(String nom);

}
