package fr.univtln.bab.project.personne;


import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.persistence.*;

import javax.xml.bind.annotation.XmlRootElement;

@Getter@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString

@Entity
@XmlRootElement
public class Personne {


    String name;
    @Id
    int id;

    public Personne(String name,int id ) {
        this.name=name;
        this.id=id;

    }

    public Personne() {

    }




}
