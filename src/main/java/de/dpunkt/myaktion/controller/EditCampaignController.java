/**
 * 
 */
package de.dpunkt.myaktion.controller;

import java.io.Serializable;

import javax.inject.Inject;

import de.dpunkt.myaktion.data.CampaignListProducer;
import de.dpunkt.myaktion.data.CampaignProducer;

/**
 * @author micha
 *
 */
public class EditCampaignController implements Serializable {
	private static final long serialVersionUID = 2815796004558360299L;

	/**
	 * 
	 */
	@Inject
	private CampaignListProducer campaignListProducer;

	/**
	 * 
	 */
	@Inject
	private CampaignProducer campaignProducer;

	/**
	 * 
	 * @return
	 */
	public String doSave() {
		if (campaignProducer.isAddMode()) {
		campaignListProducer.getCampaigns().add(
		campaignProducer.getSelectedCampaign());
		}
		return Pages.LIST_CAMPAIGNS;
	}

	/**
	 * 
	 * @return
	 */
	public String doCancel() {
		return Pages.LIST_CAMPAIGNS;
	}
}
