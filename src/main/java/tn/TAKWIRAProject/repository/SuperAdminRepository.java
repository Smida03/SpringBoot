package tn.TAKWIRAProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.TAKWIRAProject.entities.superadmin;

@Repository
public interface SuperAdminRepository extends JpaRepository<superadmin, Long> {

}
