package tn.TAKWIRAProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.TAKWIRAProject.entities.client;

@Repository
public interface ClientRepository extends JpaRepository<client,Long> {

}
