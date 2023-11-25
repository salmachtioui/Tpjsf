
import java.util.Date;
import ma.projet.beans.Employe;
import ma.projet.beans.Service;
import ma.projet.service.EmployeService;
import ma.projet.service.ServiceService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LACHGAR
 */
public class Test1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmployeService ms = new EmployeService();
        ServiceService ss = new ServiceService();
        //Création des employes
        ms.create(new Employe("HP", "HZ23", "", new Date() ,ss.getById(1),new Employe("SAMSUNG", "HZ88", "", new Date(), ss.getById(1))));
        ms.create(new Employe("HP", "HZ77", "", new Date(), ss.getById(1)));
        //Afficher les employes par salle
        for(Service s : ss.getAll()){
            System.out.println("Service  : "+s.getCode()+" : ");
            for(Employe m : s.getEmployes())
                System.out.println("\t"+m.getPrenom());
        }
    }
}
