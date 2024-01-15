package ma.omaima.espaceadmin.service;

import lombok.RequiredArgsConstructor;
import ma.omaima.espaceadmin.beans.Categorie;
import ma.omaima.espaceadmin.beans.Taux;
import ma.omaima.espaceadmin.repository.CategorieRepository;
import ma.omaima.espaceadmin.repository.TauxRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class TauxService {

    private final TauxRepository tauxRepository;

    public List<Taux> findAll() {
        return tauxRepository.findAll();
    }

    public <S extends Taux> S save(S entity) {
        return tauxRepository.save(entity);
    }

    public Optional<Taux> findById(Integer taId) {
        return tauxRepository.findById(taId);
    }

    public void deleteById(Integer taId) {
        tauxRepository.deleteById(taId);
    }

    public Optional<Taux> updateTaux(Integer taId, Taux updatedTaux) {

        Optional<Taux> existingTauxOptional = tauxRepository.findById(taId);

        if (existingTauxOptional.isPresent()) {

            Taux existingTaux = existingTauxOptional.get();
            existingTaux.setTaux(updatedTaux.getTaux());
            existingTaux.setAnnée(updatedTaux.getAnnée());
            existingTaux.setCategories(updatedTaux.getCategories());


            return Optional.of(tauxRepository.save(existingTaux));
        } else {
            return Optional.empty();
        }
    }
}
