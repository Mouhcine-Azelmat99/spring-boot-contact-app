package com.mouhcine.ContactSpringBoot.web.controllers;

import com.mouhcine.ContactSpringBoot.bo.Contact;
import com.mouhcine.ContactSpringBoot.services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {

    @Autowired
    private IContactService contactService;

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String home(ModelMap modelMap) {
        ArrayList<Contact> items = (ArrayList<Contact>) contactService.getContacts();
        modelMap.put("data",items);
        return "home";
    }

    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String add(@ModelAttribute("contact_model") Contact c) {
        return "add";
    }

    @RequestMapping(value = "/addcontact",method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact_model") Contact c,Model model) {
        contactService.createContact(c);
        model.addAttribute("msg","contact added successfully");
        return "redirect:/";

    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(HttpServletRequest request, Model model) {
//        contactService.updateContact(c);
        Long id=Long.valueOf(request.getParameter("contact_id"));
        Optional<Contact> contact=contactService.getById(id);
        model.addAttribute("contactModel",contact.get());
        return "edit";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String edit(@ModelAttribute("contactModel") Contact c,Model model) {
        System.out.println(c);
        contactService.updateContact(c);
        return "redirect:/";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(HttpServletRequest request) {
        Long id= Long.valueOf(request.getParameter("contactId"));
        System.out.println("delete id : "+id);
        contactService.deleteContact(id);
        return "home";
    }

    @RequestMapping(value = "search",method = RequestMethod.GET)
    public String search(HttpServletRequest request,Model model){
        String typeSearch = request.getParameter("typeSearch");
        String search_value=request.getParameter("search_value");
        System.out.println("type : "+typeSearch);
        List<Contact> contacts;
        if(typeSearch.equals("nom")){
            contacts =contactService.getByNom(search_value);
        } else if (typeSearch.equals("tel1")) {
            contacts=contactService.getByTel1(search_value);
        } else if (typeSearch.equals("tel2")){
            contacts=contactService.getByTel2(search_value);
        }else{
            contacts=null;
        }
        model.addAttribute("data",contacts);
        return "home";
    }
}
