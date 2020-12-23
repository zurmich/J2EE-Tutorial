package de.dpunkt.myaktion.data;

import de.dpunkt.myaktion.model.Account;
import de.dpunkt.myaktion.model.Campaign;
import de.dpunkt.myaktion.model.Donation;
import de.dpunkt.myaktion.model.Donation.Status;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@SessionScoped
@Named
public class CampaignListProducer implements Serializable {
	private static final long serialVersionUID = -182866064791747156L;
	private List<Campaign> campaigns;

	public CampaignListProducer() {
		campaigns = createMockCampaigns();
	}

	public List<Campaign> getCampaigns() {
		return campaigns;
	}
	
	private List<Campaign> createMockCampaigns() {
		Donation donation1 = new Donation();
		donation1.setDonorName("Heinz Schmidt");
		donation1.setAmount(20d);
		donation1.setReceiptRequested(true);
		donation1.setStatus(Status.TRANSFERRED);
		donation1.setAccount(new Account(donation1.getDonorName(),
		"XXX Bank","DE44876543210000123456"));
		
		Donation donation2 = new Donation();
		donation2.setDonorName("Karl Meier");
		donation2.setAmount(30d);
		donation2.setReceiptRequested(false);
		donation2.setStatus(Status.IN_PROCESS);
		donation2.setAccount(new Account(donation2.getDonorName(),
		"YYY Bank","DE44864275310000654321"));

		Donation donation3 = new Donation();
		donation3.setDonorName("Franz Schubert");
		donation3.setAmount(100d);
		donation3.setReceiptRequested(true);
		donation3.setStatus(Status.TRANSFERRED);
		donation3.setAccount(new Account(donation3.getDonorName(),
		"ZZZ Bank","DE44876543210078123456"));

		Donation donation4 = new Donation();
		donation4.setDonorName("Max Mustermann");
		donation4.setAmount(200d);
		donation4.setReceiptRequested(true);
		donation4.setStatus(Status.TRANSFERRED);
		donation4.setAccount(new Account(donation4.getDonorName(),
		"AAA Bank","DE44876543210000123456"));

		
		
		
		List<Donation> spenden1 = new LinkedList<>();
		spenden1.add(donation1);
		spenden1.add(donation2);

		List<Donation> spenden2 = new LinkedList<>();
		spenden2.add(donation3);
		spenden2.add(donation4);
		
		Campaign campaign1 = new Campaign();
		campaign1.setName("Trikots für A-Jugend");
		campaign1.setTargetAmount(1000d);
		campaign1.setAmountDonatedSoFar(258d);
		campaign1.setDonationMinimum(20d);
		campaign1.setId(1L);
		campaign1.setAccount(new Account("Max Mustermann", "ABC Bank",
		"DE44123456780100200300"));
		campaign1.setDonations(spenden1);
		
		
		Campaign campaign2 = new Campaign();
		campaign2.setName("Rollstuhl für Maria");
		campaign2.setTargetAmount(2500d);
		campaign2.setAmountDonatedSoFar(742d);
		campaign2.setDonationMinimum(25d);
		campaign2.setId(2L);
		campaign2.setAccount(campaign1.getAccount());
		campaign2.setDonations(spenden2);

		List<Campaign> ret = new LinkedList<>();
		ret.add(campaign1);
		ret.add(campaign2);

		return ret;
	}
}