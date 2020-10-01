package serviceHandlers;

import entities.CleaningReport;
import entities.dto.CleaningReportDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class HouseKeepingHandler {
    private static final String URL = "http://localhost:8081";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);
    public void cleanRooms() {
        ResponseEntity<Void> responseEntity1 = restTemplate
                .exchange(URL + "/housekeeping/clean-rooms", HttpMethod.PUT, null, Void.class);

        System.out.println(responseEntity1.getStatusCode());
    }

    public void printContracts() {
        ResponseEntity<CleaningReportDTO> response = restTemplate
                .exchange(URL + "/housekeeping/reports", HttpMethod.GET, headersEntity, CleaningReportDTO.class);

        List<CleaningReport> reports = response.getBody().getReports();

        for (CleaningReport report : reports) {
            System.out.println(report + "\n");
        }
    }
}
