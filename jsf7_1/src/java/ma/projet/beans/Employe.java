/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Employe {

    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private String photo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    @ManyToOne
    private Employe chef_service;
    @OneToMany(mappedBy = "chef_service", fetch = FetchType.EAGER)
    private List<Employe> subordinates;
    @ManyToOne
    private Service service;

    public Employe(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Employe> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employe> subordinates) {
        this.subordinates = subordinates;
    }

    public Employe() {
        service = new Service();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employe(String nom, String prenom, String photo, Date dateNaissance, Service service, Employe chef_service) {
        this.nom = nom;
        this.prenom = prenom;
        this.photo = photo;
        this.dateNaissance = dateNaissance;
        this.service = service;
        this.chef_service = chef_service;
    }

    public Employe getChef_service() {
        return chef_service;
    }

    public void setChef_service(Employe chef_service) {
        this.chef_service = chef_service;
    }

    public List<Employe> getEmployes() {
        return subordinates;
    }

    public void setEmployes(List<Employe> Employes) {
        this.subordinates = subordinates;
    }

    public Employe(String nom, String prenom, String photo, Date dateNaissance, Service service) {
        this.nom = nom;
        this.prenom = prenom;
        this.photo = photo;
        this.dateNaissance = dateNaissance;
        this.service = service;

    }
}
