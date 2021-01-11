/**
 * 
 */
package de.dpunkt.myaktion.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @author micha
 *
 */
@SessionScoped
@Named
public class ListDonationsController implements Serializable {

	private static final long serialVersionUID = 437878972432L;
	
	/**
	 * 
	 * @return
	 */
	public String doOk() {
		return Pages.LIST_CAMPAIGNS;
	}
	
	
}
