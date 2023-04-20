package tn.TAKWIRAProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.TAKWIRAProject.entities.terrain;

@Repository
public interface TerrainRepository extends JpaRepository<terrain, Long> {

	List<terrain> findByPartenaireId(Long idPartenaire);

}
