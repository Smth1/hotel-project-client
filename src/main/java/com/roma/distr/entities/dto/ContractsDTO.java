package com.roma.distr.entities.dto;

import lombok.Data;

import java.util.List;

@Data
public final class ContractsDTO {
    private List<HotelClientContractDTO> contracts;
}
