package com.roma.distr.serviceHandlers.rest;

import com.roma.distr.entities.dto.ContractsDTO;
import com.roma.distr.entities.dto.HotelClientContractDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ContractRestHandler {
    private static final String URL = "http://localhost:8080";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    public void printContracts() {
        ResponseEntity<ContractsDTO> response3 = restTemplate
                .exchange(URL + "/contracts", HttpMethod.GET, headersEntity, ContractsDTO.class);

        List<HotelClientContractDTO> contracts = response3.getBody().getContracts();

        for (HotelClientContractDTO contract : contracts) {
            System.out.println(contract + "\n");
        }
    }
}
