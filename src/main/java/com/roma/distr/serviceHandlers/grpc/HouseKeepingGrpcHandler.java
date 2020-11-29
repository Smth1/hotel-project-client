package com.roma.distr.serviceHandlers.grpc;

import com.roma.distr.api.grpc.*;
import com.roma.distr.entities.dto.CleaningReportDTO;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.annotation.PreDestroy;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class HouseKeepingGrpcHandler {
    private final String URL = "localhost";

    ManagedChannel channel;
    private final HouseKeepingServiceGrpc.HouseKeepingServiceBlockingStub houseKeepingStub;

    public HouseKeepingGrpcHandler() {
        channel = ManagedChannelBuilder.forAddress(URL, 6565).
                usePlaintext().build();

        houseKeepingStub = HouseKeepingServiceGrpc.newBlockingStub(channel);
    }

    public void cleanRooms() {
        CleanResponse cleanResponse = houseKeepingStub.clean(CleanRequest.newBuilder()
                .setRequestString("Clean rooms")
                .build());
        System.out.println("cleanResponse = " + cleanResponse.getResponseString());
    }

    public void printReports() {
        ReportsResponseGet reportList = houseKeepingStub.getAllReports(ReportsRequestGet.newBuilder()
                .setRequest("Get all reports")
                .build());

        List<CleaningReportDTO> reports = reportList.getCleaningReportTransferList().stream().map((el) -> CleaningReportDTO.builder()
                .id(UUID.fromString(el.getAdminId()))
                .administratorId(UUID.fromString(el.getAdminId()))
                .maidId(UUID.fromString(el.getMaidId()))
                .rooms(el.getRooms())
                .creationDate(el.getCreationDate())
                .build()).collect(Collectors.toList());

        for (CleaningReportDTO report : reports) {
            System.out.println(report + "\n");
        }
    }

    @PreDestroy
    public void close() {
        channel.shutdown();
    }
}
