package tn.TAKWIRAProject.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.TAKWIRAProject.entities.adminmarketing;
import tn.TAKWIRAProject.entities.publicite;
import tn.TAKWIRAProject.repository.AdminMarketingRepository;
import tn.TAKWIRAProject.repository.PubliciteRepository;

@Service
public class PubliciteService implements IPubliciteService {
	@Autowired
    private PubliciteRepository publiciteRepository;

    @Autowired
    private AdminMarketingRepository adminMarketingRepository;

    
    public publicite addPublicite(publicite pub, Long adminm_id) {
        Optional<adminmarketing> adminm = adminMarketingRepository.findById(adminm_id);
        if (adminm.isPresent()) {
            pub.setAdminm(adminm.get());
            return publiciteRepository.save(pub);
        } else {
        	throw new NoSuchElementException("Admin marketing not found with id: " + adminm_id);
        }		
    }
    
    public List<publicite> getAllPublicitesByAdminMarketing(Long adminm_id) {
        Optional<adminmarketing> adminm = adminMarketingRepository.findById(adminm_id);
        if (adminm.isPresent()) {
            return publiciteRepository.findByAdminm(adminm.get());
        } else {
            throw new NoSuchElementException("Admin marketing not found with id: " + adminm_id);
        }		
    }
    
    public publicite getPubliciteByAdminMarketing(Long adminm_id, Long publicite_id) {
        Optional<adminmarketing> adminm = adminMarketingRepository.findById(adminm_id);
        if (adminm.isPresent()) {
            Optional<publicite> publicite = publiciteRepository.findByAdminmAndIdpub(adminm.get(), publicite_id);
            if (publicite.isPresent()) {
                return publicite.get();
            } else {
                throw new NoSuchElementException("Publicite not found with id: " + publicite_id);
            }
        } else {
            throw new NoSuchElementException("Admin marketing not found with id: " + adminm_id);
        }		
    }
    
    public publicite updatePubliciteByAdminMarketing(Long adminm_id, Long publicite_id, publicite pub) {
        Optional<adminmarketing> adminm = adminMarketingRepository.findById(adminm_id);
        if (adminm.isPresent()) {
            Optional<publicite> publicite = publiciteRepository.findByAdminmAndIdpub(adminm.get(), publicite_id);
            if (publicite.isPresent()) {
                publicite updatedPublicite = publicite.get();
                updatedPublicite.setTitre(pub.getTitre());
                updatedPublicite.setDescription(pub.getDescription());
                updatedPublicite.setImageUrl(pub.getImageUrl());
                updatedPublicite.setStatut(pub.getStatut());
                return publiciteRepository.save(updatedPublicite);
            } else {
                throw new NoSuchElementException("Publicite not found with id: " + publicite_id);
            }
        } else {
            throw new NoSuchElementException("Admin marketing not found with id: " + adminm_id);
        }		
    }
    
    public void deletePubliciteByAdminMarketing(Long adminm_id, Long publicite_id) {
        Optional<adminmarketing> adminm = adminMarketingRepository.findById(adminm_id);
        if (adminm.isPresent()) {
            Optional<publicite> publicite = publiciteRepository.findByAdminmAndIdpub(adminm.get(), publicite_id);
            if (publicite.isPresent()) {
                publiciteRepository.deleteById(publicite_id);
            } else {
                throw new NoSuchElementException("Publicite not found with id: " + publicite_id);
            }
        } else {
            throw new NoSuchElementException("Admin marketing not found with id: " + adminm_id);
        }		
    }
}
