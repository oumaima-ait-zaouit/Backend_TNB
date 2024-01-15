package ma.omaima.espaceadmin.service;

import lombok.RequiredArgsConstructor;
import ma.omaima.espaceadmin.beans.Categorie;
import ma.omaima.espaceadmin.repository.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@RequiredArgsConstructor
@Service
public class CategorieService {

    private final CategorieRepository categorieRepository;

    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    public <S extends Categorie> S save(S entity) {
        return categorieRepository.save(entity);
    }

    public Optional<Categorie> findById(Integer catId) {
        return categorieRepository.findById(catId);
    }

    public void deleteById(Integer catId) {
        categorieRepository.deleteById(catId);
    }

    public Optional<Categorie> updateCategorie(Integer catId, Categorie updatedCategorie) {

        Optional<Categorie> existingCategorieOptional = categorieRepository.findById(catId);

        if (existingCategorieOptional.isPresent()) {

            Categorie existingCategorie = existingCategorieOptional.get();
            existingCategorie.setNomCat(updatedCategorie.getNomCat());
            existingCategorie.setDescription(updatedCategorie.getDescription());
            existingCategorie.setTerrains(updatedCategorie.getTerrains());
            existingCategorie.setTaux(updatedCategorie.getTaux());

            return Optional.of(categorieRepository.save(existingCategorie));
        } else {
            return Optional.empty();
        }
    }
}
