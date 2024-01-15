package ma.omaima.espaceclient.controller;



import lombok.RequiredArgsConstructor;
import ma.omaima.espaceclient.beans.Redevable;
import ma.omaima.espaceclient.service.RedevableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/redevables")
public class RedevableController {
    private final RedevableService redevableService;

    @GetMapping("/all")
    public List<Redevable> findAll() {
        return redevableService.findAll();
    }
    @PostMapping("/save")
    public <S extends Redevable> S save(@RequestBody S entity) {
        return redevableService.save(entity);
    }

    @GetMapping("/redevable/{id}")
    public Optional<Redevable> findById(@PathVariable Integer id) {
        return redevableService.findById(id);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        redevableService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Redevable> updateRedevable(
            @PathVariable Integer id,
            @RequestBody Redevable updateRedevable
    ) {
        Optional<Redevable> updated = redevableService.updateRedevable(id, updateRedevable);

        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}

