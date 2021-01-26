// Définition de la classe Utilisateur

package accessingdatamysql;

/********* Import des librairies nécesssaires au fonctionnement du projet ************/
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //Ce mot cle indique à Hibernate de creer un tableau dans MySQL à partir de cette classe
public class User {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  
  
  private Long id;

  private String nom;

  private String prenom;

/********* Réalisation des Getters et Setter pour les interactions avec les attributs ************/
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
}