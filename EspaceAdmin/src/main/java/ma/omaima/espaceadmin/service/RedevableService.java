package ma.omaima.espaceadmin.service;

import lombok.RequiredArgsConstructor;
import ma.omaima.espaceadmin.beans.Redevable;
import ma.omaima.espaceadmin.repository.RedevableRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class RedevableService {

    private final RedevableRepository redevableRepository;

    public List<Redevable> findAll() {
        return redevableRepository.findAll();
    }

    public <S extends Redevable> S save(S entity) {
        return redevableRepository.save(entity);
    }

    public Optional<Redevable> findById(Integer redId) {
        return redevableRepository.findById(redId);
    }

    public void deleteById(Integer catId) {
        redevableRepository.deleteById(catId);
    }

    public Optional<Redevable> updateRedevable(Integer redId, Redevable updatedRedevable) {
        Optional<Redevable> existingRedevableOptional = redevableRepository.findById(redId);

        if (existingRedevableOptional.isPresent()) {
            Redevable existingRedevable = existingRedevableOptional.get();
            existingRedevable.setNom(updatedRedevable.getNom());
            existingRedevable.setPrenom(updatedRedevable.getPrenom());
            existingRedevable.setMotDePasse(updatedRedevable.getMotDePasse());
            existingRedevable.setEmail(updatedRedevable.getEmail());
            existingRedevable.setTerrains(updatedRedevable.getTerrains());

            return Optional.of(redevableRepository.save(existingRedevable));
        } else {
            return Optional.empty();
        }
    }
}
