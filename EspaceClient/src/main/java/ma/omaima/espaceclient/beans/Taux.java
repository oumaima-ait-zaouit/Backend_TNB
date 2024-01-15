package ma.omaima.espaceclient.beans;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
@Entity
public class Taux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double taux;
    private LocalDate année;

    @JsonIgnore
    @OneToMany(mappedBy = "taux")
    private List<Categorie> categories;

    public Taux() {
    }

    public Taux(double taux, LocalDate année, List<Categorie> categories) {
        this.taux = taux;
        this.année = année;
        this.categories = categories;
    }
}

