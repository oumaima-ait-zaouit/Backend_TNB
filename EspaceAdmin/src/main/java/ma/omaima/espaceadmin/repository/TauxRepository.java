package ma.omaima.espaceadmin.repository;

import ma.omaima.espaceadmin.beans.Taux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxRepository extends JpaRepository<Taux, Integer> {
}
