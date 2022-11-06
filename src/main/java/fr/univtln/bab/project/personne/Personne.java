package fr.univtln.bab.project.personne;


import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.persistence.*;



@Getter@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString

@Entity
@XmlRootElement
public class Personne {


    String name;
    @Id
    @GeneratedValue
    int id;

    public Personne(String name) {
        this.name=name;

    }

    public Personne() {

    }




}
