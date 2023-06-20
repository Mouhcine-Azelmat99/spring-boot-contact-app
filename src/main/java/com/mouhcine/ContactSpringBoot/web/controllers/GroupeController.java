package com.mouhcine.ContactSpringBoot.web.controllers;

import com.mouhcine.ContactSpringBoot.bo.Contact;
import com.mouhcine.ContactSpringBoot.bo.Groupe;
import com.mouhcine.ContactSpringBoot.services.IContactService;
import com.mouhcine.ContactSpringBoot.services.IGroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class GroupeController {
    @Autowired
    IGroupeService groupeService;
    @Autowired
    IContactService contactService;

    @GetMapping("/groupes")
    public String index(Model model){
        List<Groupe> groupeList=groupeService.getGroupes();
        model.addAttribute("groupeModel",new Groupe());
        model.addAttribute("data",groupeList);
        return "groupe";
    }

    @PostMapping("addGroupe")
    public String add(@ModelAttribute("groupeModel") Groupe groupeModel,Model model){
        groupeService.createGroupe(groupeModel);
        return "redirect:/groupes";
    }

    @RequestMapping(value = "/deleteGroupe",method = RequestMethod.POST)
    public String deleteGroupe(HttpServletRequest request) {
        Long id= Long.valueOf(request.getParameter("groupeId"));
        System.out.println("delete groupe id : "+id);
        groupeService.deleteGroupe(id);
        return "redirect:/groupes";
    }

    @RequestMapping(value = "searchGroupe",method = RequestMethod.GET)
    public String search(HttpServletRequest request,Model model){
        String search_value=request.getParameter("search_value");
        List<Groupe> groupes = groupeService.getByNom(search_value);
        model.addAttribute("data",groupes);
        model.addAttribute("groupeModel",new Groupe());
        return "groupe";
    }

    @GetMapping("/groupes/{id}")
    public String manage(@PathVariable("id") Long id,Model model){
        Optional<Groupe> groupe = groupeService.getById(id);
        model.addAttribute("groupe",groupe.get());
        return "managegroupe";
    }

    @GetMapping("/groupe/addContact/{id}")
    public String addContacttogroupe(@PathVariable("id") Long id,Model model){
        Optional<Groupe> groupe = groupeService.getById(id);
        model.addAttribute("groupe",groupe.get());
        List<Contact> contacts=contactService.getContacts();
        model.addAttribute("contactsList",contacts);
        return "addContactsToGroupe";
    }

    @RequestMapping(value = "/groupe/addToGroupe",method = RequestMethod.POST)
    public String addToGroupe(HttpServletRequest request) {
        System.out.println("groupe/addToGroupe");
        Long groupeId= Long.valueOf(request.getParameter("groupeId"));
        Long contactId= Long.valueOf(request.getParameter("contactId"));
        Optional<Groupe> groupe = groupeService.getById(groupeId);
        Optional<Contact> contact = contactService.getById(contactId);
        contact.get().getGroupes().add(groupe.get());
        groupeService.updateGroupe(groupe.get());
        return "redirect:/groupes";
    }

//    @RequestMapping(value = "/deleteContactGroupe",method = RequestMethod.POST)
//    public String deleteContactGroupe(HttpServletRequest request) {
//        Long id= Long.valueOf(request.getParameter("groupeId"));
//        System.out.println("delete groupe id : "+id);
//        groupeService.deleteGroupe(id);
//        return "redirect:/groupes";
//    }
}
