package ma.omaima.espaceadmin.beans;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Setter
@Getter
@Entity

public class Redevable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String motDePasse;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "redevable", cascade = CascadeType.ALL)
    private List<Terrain> terrains;

    public Redevable() {
    }

    public Redevable(String nom, String prenom, String motDePasse, String email, List<Terrain> terrains) {
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.email = email;
        this.terrains = terrains;
    }
}
