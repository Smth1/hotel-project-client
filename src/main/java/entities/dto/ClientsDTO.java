package entities.dto;

import entities.HotelClient;

import lombok.Data;

import java.util.List;

@Data
public final class ClientsDTO {
    private final List<HotelClient> clients;
}
