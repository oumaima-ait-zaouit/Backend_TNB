package ma.omaima.espaceadmin.service;

import lombok.RequiredArgsConstructor;
import ma.omaima.espaceadmin.beans.Terrain;
import ma.omaima.espaceadmin.repository.TerrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class TerrainService {

    private final TerrainRepository terrainRepository;

    public List<Terrain> findAll() {
        return terrainRepository.findAll();
    }

    public <S extends Terrain> S save(S entity) {
        return terrainRepository.save(entity);
    }

    public Optional<Terrain> findById(Integer terrainId) {
        return terrainRepository.findById(terrainId);
    }

    public void deleteById(Integer terrainId) {
        terrainRepository.deleteById(terrainId);
    }

    public Optional<Terrain> updateTerrain(Integer terrainId, Terrain updatedTerrain) {
        Optional<Terrain> existingTerrainOptional = terrainRepository.findById(terrainId);

        if (existingTerrainOptional.isPresent()) {
            Terrain existingTerrain = existingTerrainOptional.get();
            existingTerrain.setNameTer(updatedTerrain.getNameTer());
            existingTerrain.setAdresse(updatedTerrain.getAdresse());
            existingTerrain.setSurface(updatedTerrain.getSurface());
            existingTerrain.setDateAcquisition(updatedTerrain.getDateAcquisition());
            existingTerrain.setCategorie(updatedTerrain.getCategorie());
            existingTerrain.setRedevable(updatedTerrain.getRedevable());
            existingTerrain.setTaxeTNBS(updatedTerrain.getTaxeTNBS());

            return Optional.of(terrainRepository.save(existingTerrain));
        } else {
            return Optional.empty();
        }
    }
}
