package tn.TAKWIRAProject.services;

import java.util.List;

import tn.TAKWIRAProject.entities.publicite;

public interface IPubliciteService {
	public publicite addPublicite(publicite pub, Long adminm_id);
	public List<publicite> getAllPublicitesByAdminMarketing(Long adminm_id);
	public publicite getPubliciteByAdminMarketing(Long adminm_id, Long publicite_id);
	public publicite updatePubliciteByAdminMarketing(Long adminm_id, Long publicite_id, publicite pub);
	public void deletePubliciteByAdminMarketing(Long adminm_id, Long publicite_id);
}
