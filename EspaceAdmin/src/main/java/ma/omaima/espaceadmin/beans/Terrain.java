package ma.omaima.espaceadmin.beans;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
public class Terrain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameTer;
    private String adresse;
    private double surface;
    private LocalDate dateAcquisition;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "redevable_id")
    private Redevable redevable;

    @JsonIgnore
    @OneToMany(mappedBy = "terrain")
    private List<TaxeTNB> taxeTNBS;

    public Terrain() {
    }

    public Terrain(String nameTer, String adresse, double surface, LocalDate dateAcquisition, Categorie categorie, Redevable redevable, List<TaxeTNB> taxeTNBS) {
        this.nameTer = nameTer;
        this.adresse = adresse;
        this.surface = surface;
        this.dateAcquisition = dateAcquisition;
        this.categorie = categorie;
        this.redevable = redevable;
        this.taxeTNBS = taxeTNBS;
    }
}
