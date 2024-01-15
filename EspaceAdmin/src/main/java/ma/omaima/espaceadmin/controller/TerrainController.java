package ma.omaima.espaceadmin.controller;

import lombok.RequiredArgsConstructor;
import ma.omaima.espaceadmin.beans.Terrain;
import ma.omaima.espaceadmin.service.TerrainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/terrains")
public class TerrainController {

    private final TerrainService terrainService;

    @GetMapping("/all")
    public List<Terrain> findAll() {
        return terrainService.findAll();
    }

    @PostMapping("/save")
    public <S extends Terrain> S save(@RequestBody S entity) {
        return terrainService.save(entity);
    }

    @GetMapping("/{id}")
    public Optional<Terrain> findById(@PathVariable Integer id) {
        return terrainService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        terrainService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Terrain> updateTerrain(
            @PathVariable Integer id,
            @RequestBody Terrain updatedTerrain
    ) {
        Optional<Terrain> updated = terrainService.updateTerrain(id, updatedTerrain);

        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
