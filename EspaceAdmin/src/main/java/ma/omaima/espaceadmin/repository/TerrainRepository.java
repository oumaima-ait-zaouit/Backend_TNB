package ma.omaima.espaceadmin.repository;


import ma.omaima.espaceadmin.beans.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Integer> {
}
