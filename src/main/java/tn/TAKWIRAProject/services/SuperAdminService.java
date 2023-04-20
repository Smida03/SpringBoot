package tn.TAKWIRAProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.TAKWIRAProject.entities.superadmin;
import tn.TAKWIRAProject.repository.SuperAdminRepository;

@Service
public class SuperAdminService implements ISuperAdminService {
    @Autowired
    private SuperAdminRepository superAdminRepository;

    public List<superadmin> getAllSuperAdmins() {
        return superAdminRepository.findAll();
    }

    public superadmin getSuperAdminById(Long id) {
        return superAdminRepository.findById(id).orElse(null);
    }

    public superadmin addSuperAdmin(superadmin superAdmin) {
        return superAdminRepository.save(superAdmin);
    }

    public superadmin updateSuperAdmin(superadmin superAdmin) {
        return superAdminRepository.save(superAdmin);
    }

    public void deleteSuperAdmin(Long id) {
        superAdminRepository.deleteById(id);
    }
}