package entities.dto;

import entities.HotelClient;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public final class ClientsDTO {
    private List<HotelClientDTO> clients;
}
