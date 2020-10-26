package serviceHandlers;

import entities.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RoomHandler {
    private static final String URL = "http://localhost:8080";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    public void addRooms() {
        Room room1 = new Room(1,2);
        Room room2 = new Room(2,4);
        Room room3 = new Room(3,2);
        Room room4 = new Room(4,3);

        HttpEntity<Room> deliverRoom = new HttpEntity<>(room1, headers);
        ResponseEntity<Void> responseEntity1 = restTemplate
                .exchange(URL + "/room", HttpMethod.POST, deliverRoom, Void.class);

        deliverRoom = new HttpEntity<>(room2, headers);
        ResponseEntity<Void> responseEntity2 = restTemplate
                .exchange(URL + "/room", HttpMethod.POST, deliverRoom, Void.class);

        deliverRoom = new HttpEntity<>(room3, headers);
        ResponseEntity<Void> responseEntity3 = restTemplate
                .exchange(URL + "/room", HttpMethod.POST, deliverRoom, Void.class);

        deliverRoom = new HttpEntity<>(room4, headers);
        ResponseEntity<Void> responseEntity4 = restTemplate
                .exchange(URL + "/room", HttpMethod.POST, deliverRoom, Void.class);

        System.out.println(room1);
        System.out.println(room2);
        System.out.println(room3);
        System.out.println(room4);
        System.out.println(responseEntity1.getStatusCode());
    }
}
