package tn.TAKWIRAProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.TAKWIRAProject.entities.partenaire;

@Repository
public interface PartenaireRepository extends JpaRepository<partenaire, Long> {
}