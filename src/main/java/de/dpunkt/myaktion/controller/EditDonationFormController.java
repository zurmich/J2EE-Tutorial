/**
 * 
 */
package de.dpunkt.myaktion.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import de.dpunkt.myaktion.data.CampaignProducer;

/**
 * @author micha
 *
 */
@SessionScoped
@Named
public class EditDonationFormController implements Serializable {
	private static final long serialVersionUID = -4210085664588144340L;
	private String textColor = "000000";
	private String bgColor = "ffffff";
	
	@Inject
	private CampaignProducer campaignProducer;
	
	/**
	 * 
	 * @return
	 */
	private String getAppUrl() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String scheme = req.getScheme();
		String serverName = req.getServerName();
		int serverPort = req.getServerPort();
		String contextPath = req.getContextPath();
		return scheme + "://" + serverName + ":" + serverPort + contextPath;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public String doOk() {
		return Pages.LIST_CAMPAIGNS;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getUrl() {
		return getAppUrl() + "/" + Pages.DONATE_MONEY + ".jsf" + "?bgColor="
				+ bgColor + "&textColor=" + textColor + "&campaignId="
				+ campaignProducer.getSelectedCampaign().getId();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTextColor() {
		return textColor;
	}
	
	/**
	 * 
	 * @param textColor
	 */
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getBgColor() {
		return bgColor;
	}
	
	/**
	 * 
	 * @param bgColor
	 */
	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
}
