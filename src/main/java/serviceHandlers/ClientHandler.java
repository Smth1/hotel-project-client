package serviceHandlers;

import entities.HotelClient;
import entities.HotelClientContract;
import entities.dto.ClientsDTO;
import entities.dto.ContractsDTO;

import entities.dto.HotelClientDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class ClientHandler {
    private static final String URL = "http://localhost:8080";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    public void serveClients() {
        String clientsUrl = "/client";
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

        ResponseEntity<ClientsDTO> responseEntity = restTemplate
                .exchange(URL + "/clients", HttpMethod.GET, headersEntity, ClientsDTO.class);
        System.out.println(responseEntity.getBody());
        List<HotelClientDTO> clients = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(responseEntity.getBody());
        JSONArray jsonArray = jsonObject.getJSONArray("clients");

        System.out.println(jsonArray.toString());
        for (int i = 0; i < jsonArray.length(); i++) {
            HotelClientDTO hotelClientDTO = new HotelClientDTO();
            hotelClientDTO.setClientId(UUID.fromString(jsonArray
                    .getJSONObject(i).getString("clientId")));

            hotelClientDTO.setClientName(jsonArray
                    .getJSONObject(i).getString("clientName"));

            clients.add(hotelClientDTO);
        }
        Random random = new Random();

        HotelClientDTO client = clients.get(random.nextInt(clients.size()));
        System.out.println("Settling out client " + client.getClientName());
        ResponseEntity<Void> responseEntity1 = restTemplate
                .exchange(URL + "/clients/" + client.getClientId(),
                        HttpMethod.DELETE, null, Void.class);

        System.out.println(responseEntity.getStatusCode());
    }
}
