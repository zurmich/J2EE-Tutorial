package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.data.CampaignProducer;
import de.dpunkt.myaktion.model.Campaign;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
@SessionScoped
@Named
public class ListCampaignsController implements Serializable {
	private static final long serialVersionUID = 8693277383648025822L;

	@Inject
	private CampaignProducer campaignProducer;
	
	public String doAddCampaign() {
		campaignProducer.prepareAddCampaign();
		return Pages.EDIT_CAMPAIGN;
	}
	public String doEditCampaign(Campaign campaign) {
		campaignProducer.prepareEditCampaign(campaign);
		return Pages.EDIT_CAMPAIGN;
	}
	public String doEditDonationForm(Campaign campaign) {
		System.out.println("Edit Donation Form of Campaign " + campaign);
	return Pages.EDIT_DONATION_FORM;
	}
	public String doListDonations(Campaign campaign) {
		campaign.getDonations().forEach(don->{
			System.out.println(printFacesContextMsg( "Camp: " + campaign.getName() + " <<<" + don.toString() ));
		});
		
	return Pages.LIST_DONATIONS;
	}
	public void doDeleteCampaign(Campaign campaign) {
		
		System.out.println("Deletion not implemented, yet!");
	}
	
	private String printFacesContextMsg(String str) {
		String out = new String(str);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
				out, null));
		return out;
	}
	
	
}



