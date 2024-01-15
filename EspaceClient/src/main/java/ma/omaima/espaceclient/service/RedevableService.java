package ma.omaima.espaceclient.service;


import lombok.RequiredArgsConstructor;
import ma.omaima.espaceclient.beans.Redevable;
import ma.omaima.espaceclient.repository.RedevableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class RedevableService {

    private final RedevableRepository redevableRepository;

    @Autowired
    private RestTemplate restTemplate;

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





    /*public ResponseEntity<?> fetchRedevableById(Integer redId) {
        Optional<Redevable> redevable = redevableRepository.findById(redId);

        if (redevable.isPresent()) {
            Terrain terrain = restTemplate.getForObject("http://localhost:9090/terrain" + redevable.get().getTerrains(), Terrain.class);

            // Create a response object with Redevable and associated Terrain information
            RedevableResponse redevableResponse = new RedevableResponse(
                    redevable.get().getId(),
                    redevable.get().getNom(),
                    redevable.get().getPrenom(),
                    redevable.get().getMotDePasse(),
                    redevable.get().getEmail(),
                    terrain
            );

            return new ResponseEntity<>(redevableResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Redevable Found", HttpStatus.NOT_FOUND);
        }
    }*/
}

