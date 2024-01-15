package ma.omaima.espaceadmin.repository;

import ma.omaima.espaceadmin.beans.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
}
