
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
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServiceService ss = new ServiceService();
        //création des Salles
        ss.create(new Service("I", "Informatique"));
        ss.create(new Service("A", "Arabe"));
        ss.create(new Service("C", "Comptailité"));
        //La liste des salles
        for (Service s : ss.getAll()) {
            System.out.println("" + s.getCode());
        }
    }
}
