package entities.dto;

import entities.HotelClientContract;

import lombok.Data;

import java.util.List;

@Data
public final class ContractsDTO {
    private final List<HotelClientContract> contracts;
}
