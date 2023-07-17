package service;

import model.InsuranceRequest;
import model.Policy;
import model.Proposal;
import model.Vehicle;

import java.util.ArrayList;

public class InsuranceRequestService {
    public InsuranceRequest createInsuranceRequest (Vehicle vehicle, Policy policy){
        InsuranceRequest insuranceRequest = new InsuranceRequest();
        insuranceRequest.setPolicy(policy);
        insuranceRequest.setVehicle(vehicle);
        return insuranceRequest;

    }

    public void addPropasalToInsuranceRequest(InsuranceRequest insuranceRequest, Proposal proposal){
        if (insuranceRequest.getProposalList()!= null){
            insuranceRequest.getProposalList().add(proposal);
        } else {
            ArrayList<Proposal> proposalList = new ArrayList<>();
            proposalList.add(proposal);
            insuranceRequest.setProposalList(proposalList);
        }
    }
}
