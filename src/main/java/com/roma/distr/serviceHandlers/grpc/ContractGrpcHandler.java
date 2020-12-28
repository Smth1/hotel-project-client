package com.roma.distr.serviceHandlers.grpc;

import com.roma.distr.api.grpc.ContractServiceGrpc;
import com.roma.distr.api.grpc.ContractsRequestGet;
import com.roma.distr.api.grpc.ContractsResponseGet;
import com.roma.distr.entities.dto.HotelClientContractDTO;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.annotation.PreDestroy;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ContractGrpcHandler {
    private final String URL = "localhost";

    ManagedChannel channel;
    private final ContractServiceGrpc.ContractServiceBlockingStub contractStub;

    public ContractGrpcHandler() {
        channel = ManagedChannelBuilder.forAddress(URL, 6560).
                usePlaintext().build();

        contractStub = ContractServiceGrpc.newBlockingStub(channel);
    }

    public void printContracts() {
        ContractsResponseGet allContracts = contractStub.getAllContracts(ContractsRequestGet.newBuilder()
                .setRequest("Get all contracts")
                .build());
        List<HotelClientContractDTO> contracts = allContracts.getContractsTransferList().stream().map((el) -> HotelClientContractDTO.builder()
                .id(UUID.fromString(el.getId()))
                .hotelAdmin(UUID.fromString(el.getHotelAdmin()))
                .client(UUID.fromString(el.getClient()))
                .cashier(UUID.fromString(el.getCashier()))
                .porter(UUID.fromString(el.getPorter()))
                .room(UUID.fromString(el.getRoom()))
                .creationDate(el.getCreationDate())
                .isOpen(el.getIsOpen())
                .build()).collect(Collectors.toList());

        for (HotelClientContractDTO contract : contracts) {
            System.out.println(contract + "\n");
        }
    }

    @PreDestroy
    public void close() {
        channel.shutdown();
    }
}
