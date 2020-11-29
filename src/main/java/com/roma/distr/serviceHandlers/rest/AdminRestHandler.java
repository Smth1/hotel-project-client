package com.roma.distr.serviceHandlers.rest;

import com.roma.distr.entities.Administrator;
import com.roma.distr.entities.Cashier;
import com.roma.distr.entities.Maid;
import com.roma.distr.entities.Porter;
import com.roma.distr.entities.dto.AdministratorDTO;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AdminRestHandler {
    private static final String URL = "http://localhost:8080";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    public void addEmployees() {
        AdministratorDTO admin = new AdministratorDTO("woeifj",234,"alksdjf");
        Porter porter = new Porter("Jack", 25);
        Maid maid = new Maid("Amelia", 39);
        Cashier cashier = new Cashier("Ella", 30);

        HttpEntity<AdministratorDTO> deliverObject = new HttpEntity<>(admin, headers);
        ResponseEntity<Void> responseEntity1 = restTemplate
                .exchange(URL + "/administration/admin", HttpMethod.POST, deliverObject, Void.class);

        HttpEntity<Porter> deliverObjectPorter = new HttpEntity<>(porter, headers);
        ResponseEntity<Void> responseEntity2 = restTemplate
                .exchange(URL + "/administration/porter", HttpMethod.POST, deliverObjectPorter, Void.class);

        HttpEntity<Maid> deliverObjectMaid = new HttpEntity<>(maid, headers);
        ResponseEntity<Void> responseEntity3 = restTemplate
                .exchange(URL + "/administration/maid", HttpMethod.POST, deliverObjectMaid, Void.class);

        HttpEntity<Cashier> deliverObjectCashier = new HttpEntity<>(cashier, headers);
        ResponseEntity<Void> responseEntity4 = restTemplate
                .exchange(URL + "/administration/cashier", HttpMethod.POST, deliverObjectCashier, Void.class);

        ResponseEntity<Administrator> response3 = restTemplate
                .exchange(URL + "/administration/admin", HttpMethod.GET, headersEntity, Administrator.class);

        System.out.println(admin);
        System.out.println(porter);
        System.out.println(maid);
        System.out.println(cashier);
        System.out.println(response3.getStatusCode());
    }
}
