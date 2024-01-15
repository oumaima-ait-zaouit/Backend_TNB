package ma.omaima.espaceadmin.service;

import lombok.RequiredArgsConstructor;
import ma.omaima.espaceadmin.beans.TaxeTNB;
import ma.omaima.espaceadmin.repository.TaxeTNBRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class TaxeTNBService {
    private final TaxeTNBRepository taxeTNBRepository;

    public List<TaxeTNB> findAll() {
        return taxeTNBRepository.findAll();
    }

    public <S extends TaxeTNB> S save(S entity) {
        return taxeTNBRepository.save(entity);
    }

    public Optional<TaxeTNB> findById(Integer taxeTNBId) {
        return taxeTNBRepository.findById(taxeTNBId);
    }

    public void deleteById(Integer taxeTNBId) {
        taxeTNBRepository.deleteById(taxeTNBId);
    }

    public Optional<TaxeTNB> updateTaxeTNB(Integer taxeTNBId, TaxeTNB updatedTaxeTNB) {
        Optional<TaxeTNB> existingTaxeTNBOptional = taxeTNBRepository.findById(taxeTNBId);

        if (existingTaxeTNBOptional.isPresent()) {
            TaxeTNB existingTaxeTNB = existingTaxeTNBOptional.get();
            existingTaxeTNB.setMontantTNB(updatedTaxeTNB.getMontantTNB());
            existingTaxeTNB.setDateFacturation(updatedTaxeTNB.getDateFacturation());
            existingTaxeTNB.setAnnée(updatedTaxeTNB.getAnnée());
            existingTaxeTNB.setTerrain(updatedTaxeTNB.getTerrain());

            return Optional.of(taxeTNBRepository.save(existingTaxeTNB));
        } else {
            return Optional.empty();
        }
    }
}
