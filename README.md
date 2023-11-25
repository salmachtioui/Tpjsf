# Tpjsf
# Gestion des Employés et Services
Cette application web de gestion des employés et des services a été développée en utilisant les technologies suivantes : JSF, Hibernate, et MySQL.

# Fonctionnalités
Ajouter, supprimer, et modifier les informations d'un employé.
Filtrer les employés par service.
Afficher un graphique représentant le nombre d'employés par service.
# Technologies Utilisées
JavaServer Faces (JSF)
Hibernate
MySQL
# Configuration du Projet
Cloner le Projet :

bash
Copy code
git clone https://github.com/salmachtioui/Tpjsf.git
cd gestion-employes-services
# Configurer la Base de Données :

Créer une base de données MySQL nommée "jsftp".
Mettre à jour le fichier src/main/resources/META-INF/persistence.xml avec vos informations de connexion à la base de données.
Exécuter l'Application :

Assurez-vous d'avoir Maven installé.
Exécutez la commande :
bash
Copy code
mvn clean install
Démarrez le serveur intégré ou déployez le projet sur un serveur compatible JSF.
# Accéder à l'Application :

Accédez à l'application depuis votre navigateur à l'URL : http://localhost:24017/jsf7_1/faces/web/employe/employeForm.xhtml
# Structure du Projet
src/main/java: Contient les packages Java pour les beans, les entités, etc.
src/main/webapp: Contient les pages JSF, les fichiers de ressources, etc.
src/main/resources: Contient les fichiers de configuration, comme persistence.xml.
![image](https://github.com/salmachtioui/Tpjsf/assets/147477621/e20650d4-3a6d-4b33-8bfc-d2e4c604d2f4)
# Modele de base de donnes :
![image](https://github.com/salmachtioui/Tpjsf/assets/147477621/435de442-7026-4524-89fb-b656a416a905)

# Captures d'Écran
# Capture d'Écran 1: Page d'authentification 
![im8](https://github.com/salmachtioui/Tpjsf/assets/147477621/3458adef-1263-4441-8e2e-66e885e79c5b)
# Lorsque l'empolye va taper un login correct 
![im9](https://github.com/salmachtioui/Tpjsf/assets/147477621/9996594e-4fcc-453f-a067-af548a541c4f)
# L'employe clique sur "Logout" ,il revient à la page d'authtification precedente
![im10](https://github.com/salmachtioui/Tpjsf/assets/147477621/aa383059-b9d7-452a-9c62-2fa40d22d5cd)
# Lorsque l"empolye va taper un login incorrect 
![im11](https://github.com/salmachtioui/Tpjsf/assets/147477621/f86f6593-1170-4f18-8ab0-39fba078090f)
# Capture d'Écran 2:Ajout employe
![im1](https://github.com/salmachtioui/Tpjsf/assets/147477621/ffd5e4a7-fdbf-4e78-a8b9-336dd39deb84)
![im2](https://github.com/salmachtioui/Tpjsf/assets/147477621/a7ef70f5-bb62-4ad5-a368-09f28837e985)
# Capture d'Écran 2:Modifier employe
![im3](https://github.com/salmachtioui/Tpjsf/assets/147477621/b5ca7cc3-a963-423c-904d-920aed72d87d)
# Capture d'Écran 2:Supprimer employe
![im4](https://github.com/salmachtioui/Tpjsf/assets/147477621/0147a3f9-d7d9-46be-b9e8-047521607182)
# Capture d'Écran 2:Filtrage emplyes par service
![im5](https://github.com/salmachtioui/Tpjsf/assets/147477621/20f38326-6a5d-4316-b9c6-862a1555025f)
# Capture d'Écran 2:Graphe de nombre des  emplyes par service
![im6](https://github.com/salmachtioui/Tpjsf/assets/147477621/ee8406c2-43b0-4a3b-96f5-8c8872c8b179)
# Capture d'Écran 2:Interface pour l'ajout des services
![im7](https://github.com/salmachtioui/Tpjsf/assets/147477621/40f08316-2c4e-4828-86f5-e85ba49a318f)


