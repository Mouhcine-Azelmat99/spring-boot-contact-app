package com.mouhcine.ContactSpringBoot.bo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    private String prenome;
    private String tel1;
    private String tel2;
    private String adress;
    private String emailProf;
    private String genre;

    @Column(unique = true)
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "contact_group",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Groupe> groupes;

    public String getGenre() {
        return genre;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }


    public List<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(List<Groupe> groupes) {
        this.groupes = groupes;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenome() {
        return prenome;
    }

    public void setPrenome(String prenome) {
        this.prenome = prenome;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmailProf() {
        return emailProf;
    }

    public void setEmailProf(String emailProf) {
        this.emailProf = emailProf;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenome='" + prenome + '\'' +
                ", tel1='" + tel1 + '\'' +
                ", tel2='" + tel2 + '\'' +
                ", adress='" + adress + '\'' +
                ", emailProf='" + emailProf + '\'' +
                ", genre=" + genre +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }


}
