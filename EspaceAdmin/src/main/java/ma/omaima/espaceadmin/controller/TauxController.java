package ma.omaima.espaceadmin.controller;

import lombok.RequiredArgsConstructor;
import ma.omaima.espaceadmin.beans.Taux;
import ma.omaima.espaceadmin.service.TauxService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/taux")
public class TauxController {

    private final TauxService tauxService;

    @GetMapping("/all")
    public List<Taux> findAll() {
        return tauxService.findAll();
    }

    @PostMapping("/save")
    public <S extends Taux> S save(@RequestBody S entity) {
        return tauxService.save(entity);
    }

    @GetMapping("/{id}")
    public Optional<Taux> findById(@PathVariable Integer id) {
        return tauxService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        tauxService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Taux> updateTaux(
            @PathVariable Integer id,
            @RequestBody Taux updatedTaux
    ) {
        Optional<Taux> updated = tauxService.updateTaux(id, updatedTaux);

        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
