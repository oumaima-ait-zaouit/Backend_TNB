package ma.omaima.espaceadmin.repository;

import ma.omaima.espaceadmin.beans.TaxeTNB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeTNBRepository extends JpaRepository<TaxeTNB, Integer> {
}
