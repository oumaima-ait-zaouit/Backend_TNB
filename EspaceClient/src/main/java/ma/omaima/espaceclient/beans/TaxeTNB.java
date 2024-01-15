package ma.omaima.espaceclient.beans;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;

@Setter
@Getter
@Entity
public class TaxeTNB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double montantTNB;
    private LocalDate dateFacturation;
    private LocalDate année;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "terrain_id")
    private Terrain terrain;

    public TaxeTNB() {
    }

    public TaxeTNB(double montantTNB, LocalDate dateFacturation, LocalDate année, Terrain terrain) {
        this.montantTNB = montantTNB;
        this.dateFacturation = dateFacturation;
        this.année = année;
        this.terrain = terrain;
    }
}
