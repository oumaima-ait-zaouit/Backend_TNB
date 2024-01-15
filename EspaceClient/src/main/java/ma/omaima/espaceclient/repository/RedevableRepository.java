package ma.omaima.espaceclient.repository;

import ma.omaima.espaceclient.beans.Redevable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedevableRepository extends JpaRepository<Redevable, Integer> {
}
