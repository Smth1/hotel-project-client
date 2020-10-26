package entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class HotelClientDTO {
    private UUID clientId;
    private String clientName;

    public HotelClientDTO(String clientName) {
        this.clientName = clientName;
        this.clientId = UUID.randomUUID();
    }
}
