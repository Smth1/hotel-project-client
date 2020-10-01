package entities.dto;

import entities.HotelClientContract;

import java.util.List;

public class ContractsDTO {
    List<HotelClientContract> contracts;

    public ContractsDTO(List<HotelClientContract> contracts) {
        this.contracts = contracts;
    }

    public List<HotelClientContract> getContracts() {
        return contracts;
    }

    public void setContracts(List<HotelClientContract> contracts) {
        this.contracts = contracts;
    }
}
