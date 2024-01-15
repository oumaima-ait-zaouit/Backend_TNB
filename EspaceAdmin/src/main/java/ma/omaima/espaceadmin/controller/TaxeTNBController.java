package ma.omaima.espaceadmin.controller;

import lombok.RequiredArgsConstructor;
import ma.omaima.espaceadmin.beans.TaxeTNB;
import ma.omaima.espaceadmin.service.TaxeTNBService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/taxe-tnb")
public class TaxeTNBController {

    private final TaxeTNBService taxeTNBService;

    @GetMapping("/all")
    public List<TaxeTNB> findAll() {
        return taxeTNBService.findAll();
    }

    @PostMapping("/save")
    public <S extends TaxeTNB> S save(@RequestBody S entity) {
        return taxeTNBService.save(entity);
    }

    @GetMapping("/{id}")
    public Optional<TaxeTNB> findById(@PathVariable Integer id) {
        return taxeTNBService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        taxeTNBService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaxeTNB> updateTaxeTNB(
            @PathVariable Integer id,
            @RequestBody TaxeTNB updatedTaxeTNB
    ) {
        Optional<TaxeTNB> updated = taxeTNBService.updateTaxeTNB(id, updatedTaxeTNB);

        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}