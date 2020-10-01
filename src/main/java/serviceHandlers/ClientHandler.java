package serviceHandlers;

import entities.HotelClientContract;
import entities.dto.ContractsDTO;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ClientHandler {
    private static final String URL = "http://localhost:8081";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);
    public void printContracts() {
        ResponseEntity<ContractsDTO> response3 = restTemplate
                .exchange(URL + "/contracts", HttpMethod.GET, headersEntity, ContractsDTO.class);

        List<HotelClientContract> contracts = response3.getBody().getContracts();

        for (HotelClientContract contract : contracts) {
            System.out.println(contract + "\n");
        }
    }
}
