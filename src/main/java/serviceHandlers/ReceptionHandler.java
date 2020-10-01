package serviceHandlers;

import entities.*;
import entities.dto.ClientsDTO;
import entities.dto.HotelClientDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

public class ReceptionHandler {
    private static final String URL = "http://localhost:8081";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);
    public void serveClients() {
        String clientsUrl = "/reception/client";
        HotelClientDTO client1 = new HotelClientDTO("Asher");
        HotelClientDTO client2 = new HotelClientDTO("Oliver");
        HotelClientDTO client3 = new HotelClientDTO("Silas");
        HotelClientDTO client4 = new HotelClientDTO("Atticus");

        HttpEntity<HotelClientDTO> deliverClient = new HttpEntity<>(client1, headers);

        ResponseEntity<Void> responseEntity1 = restTemplate
                .exchange(URL + clientsUrl, HttpMethod.POST, deliverClient, Void.class);

        deliverClient = new HttpEntity<>(client2, headers);
        ResponseEntity<Void> responseEntity2 = restTemplate
                .exchange(URL + clientsUrl, HttpMethod.POST, deliverClient, Void.class);

        deliverClient = new HttpEntity<>(client3, headers);
        ResponseEntity<Void> responseEntity3 = restTemplate
                .exchange(URL + clientsUrl, HttpMethod.POST, deliverClient, Void.class);

        deliverClient = new HttpEntity<>(client4, headers);
        ResponseEntity<Void> responseEntity4 = restTemplate
                .exchange(URL + clientsUrl, HttpMethod.POST, deliverClient, Void.class);

        System.out.println(client1);
        System.out.println(client2);
        System.out.println(client3);
        System.out.println(client4);
        System.out.println(responseEntity1.getStatusCode());
    }

    public void moveOutClients() {

        ResponseEntity<ClientsDTO> response3 = restTemplate
                .exchange(URL + "/clients", HttpMethod.GET, headersEntity, ClientsDTO.class);
        List<HotelClient> clients = response3.getBody().getClients();
        Random random = new Random();

        HotelClient client = clients.get(random.nextInt(clients.size()));
        System.out.println("Settling out client " + client.getName());
        ResponseEntity<Void> responseEntity1 = restTemplate
               .exchange(URL + "/reception/clients/" + client.getClientId(), HttpMethod.DELETE, null, Void.class);

        System.out.println(response3.getStatusCode());
    }
}
