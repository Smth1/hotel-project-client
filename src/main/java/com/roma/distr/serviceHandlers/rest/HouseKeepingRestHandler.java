package com.roma.distr.serviceHandlers.rest;

import com.roma.distr.entities.dto.CleaningReportDTO;
import com.roma.distr.entities.dto.CleaningReportsDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class HouseKeepingRestHandler {
    private static final String URL = "http://localhost:8080";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    public void cleanRooms() {
        ResponseEntity<Void> responseEntity1 = restTemplate
                .exchange(URL + "/housekeeping/clean-rooms", HttpMethod.PUT, null, Void.class);

        System.out.println(responseEntity1.getStatusCode());
    }

    public void printReports() {
        ResponseEntity<CleaningReportsDTO> response = restTemplate
                .exchange(URL + "/housekeeping/reports", HttpMethod.GET, headersEntity, CleaningReportsDTO.class);

        List<CleaningReportDTO> reports = response.getBody().getReports();

        for (CleaningReportDTO report : reports) {
            System.out.println(report + "\n");
        }
    }
}
