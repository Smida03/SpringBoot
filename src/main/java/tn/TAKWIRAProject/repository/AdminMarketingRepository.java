package tn.TAKWIRAProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.TAKWIRAProject.entities.adminmarketing;

@Repository
public interface AdminMarketingRepository extends JpaRepository<adminmarketing, Long> {

}
