package ma.omaima.espaceadmin.repository;

import ma.omaima.espaceadmin.beans.Redevable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedevableRepository extends JpaRepository<Redevable, Integer> {
}
