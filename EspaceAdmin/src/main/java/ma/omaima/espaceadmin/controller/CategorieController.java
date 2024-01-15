package ma.omaima.espaceadmin.controller;

import lombok.RequiredArgsConstructor;
import ma.omaima.espaceadmin.beans.Categorie;
import ma.omaima.espaceadmin.service.CategorieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategorieController {

    private final CategorieService categorieService;

    @GetMapping("/all")
    public List<Categorie> findAll() {
        return categorieService.findAll();
    }
    @PostMapping("/save")
    public <S extends Categorie> S save(@RequestBody S entity) {
        return categorieService.save(entity);
    }

    @GetMapping("/categorie/{id}")
    public Optional<Categorie> findById(@PathVariable Integer id) {
        return categorieService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        categorieService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Categorie> updateCategorie(
            @PathVariable Integer id,
            @RequestBody Categorie updatedCategorie
    ) {
        Optional<Categorie> updated = categorieService.updateCategorie(id, updatedCategorie);

        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
