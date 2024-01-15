package ma.omaima.espaceadmin.beans;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;



@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomCat;
    private String description;


    @JsonIgnore
    @OneToMany(mappedBy = "categorie")
    private List<Terrain> terrains;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Taux taux;


    public Categorie() {
    }

    public Categorie(int id, String nomCat, String description, List<Terrain> terrains, Taux taux) {
        this.id = id;
        this.nomCat = nomCat;
        this.description = description;
        this.terrains = terrains;
        this.taux = taux;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Terrain> getTerrains() {
        return terrains;
    }

    public void setTerrains(List<Terrain> terrains) {
        this.terrains = terrains;
    }

    public Taux getTaux() {
        return taux;
    }

    public void setTaux(Taux taux) {
        this.taux = taux;
    }
}
