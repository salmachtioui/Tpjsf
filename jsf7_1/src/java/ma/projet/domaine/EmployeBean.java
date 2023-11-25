/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.domaine;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import ma.projet.beans.Employe;
import ma.projet.beans.Service;
import ma.projet.service.EmployeService;
import ma.projet.service.ServiceService;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author hp
 */
@WebServlet("/Upload")
@MultipartConfig(maxFileSize = 16177215)

@ManagedBean(name = "employeBean")
public class EmployeBean {

    private Employe employe;

    private Service service;
    private List<Employe> employes;
    private List<Employe> employesBetweenDates;
    private EmployeService employeService;
    private ServiceService serviceService;
    private static ChartModel barModel;
    private Date date1;
    private Date date2;

    public EmployeBean() {
        employe = new Employe();
        employeService = new EmployeService();
        serviceService = new ServiceService();

    }

    public List<Employe> getEmployes() {
        if (employes == null) {
            employes = employeService.getAll();
        }
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public EmployeService getEmployeService() {
        return employeService;
    }

    public void setEmployeService(EmployeService employeService) {
        this.employeService = employeService;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public String onCreateAction() {
        employeService.create(employe);
        employe = new Employe();
        return null;
    }

    public String onDeleteAction() {

        employeService.delete(employeService.getById(employe.getId()));
        return null;
    }

    public List<Employe> serviceLoad() {
        for (Employe m : employeService.getAll()) {
            if (m.getService().equals(service)) {
                employes.add(m);
            }
        }
        return employes;

    }

    public void load() {
        System.out.println(service.getLibelle());
        service = serviceService.getById(service.getId());
        getEmployes();
    }

    public void onEdit(RowEditEvent event) {
        employe = (Employe) event.getObject();
        Service service = serviceService.getById(this.employe.getService().getId());
        employe.setService(service);
        employe.getService().setLibelle(service.getLibelle());
        employeService.update(employe);
    }

    public void onCancel(RowEditEvent event) {
    }

    public ChartModel getBarModel() {
        return barModel;
    }

    public ChartModel initBarModel() {
        CartesianChartModel model = new CartesianChartModel();
        ChartSeries employes = new ChartSeries();
        employes.setLabel("employes");
        model.setAnimate(true);
        for (Object[] m : employeService.nbemploye()) {
            employes.set(m[1], Integer.parseInt(m[0].toString()));
        }
        model.addSeries(employes);

        return model;
    }

    public List<Employe> employeLoad() {
        employesBetweenDates = employeService.getbydates(date1, date2);
        return null;

    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Employe> getEmployesBetweenDates() {
        return employesBetweenDates;
    }

    public void setEmployesBetweenDates(List<Employe> employesBetweenDates) {
        this.employesBetweenDates = employesBetweenDates;
    }

    public void handleFileUpload(FileUploadEvent event) {
        UploadedFile uploadedFile = event.getFile();
        String filename = uploadedFile.getFileName();
        String folderPath = "/path/to/your/uploaded/images/"; // Spécifiez le chemin où vous souhaitez stocker les images téléchargées

        // Enregistrez le fichier dans le chemin spécifié
        try (InputStream input = uploadedFile.getInputstream()) {
            Files.copy(input, Paths.get(folderPath, filename), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
        }

        // Mettez à jour le chemin de la photo dans l'objet employé
        employe.setPhoto("/path/to/your/uploaded/images/" + filename);
    }
}
