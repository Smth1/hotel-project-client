package serviceHandlers;

import entities.*;
import entities.dto.ClientsDTO;
import entities.dto.ContractsDTO;
import entities.dto.HotelClientContractDTO;
import entities.dto.HotelClientDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ContractHandler {
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
