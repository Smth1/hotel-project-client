package com.roma.distr.serviceHandlers.grpc;

import com.roma.distr.api.grpc.*;
import com.roma.distr.entities.Room;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.annotation.PreDestroy;

public class RoomGrpcHandler {
    private final String URL = "localhost";

    private final ManagedChannel channel;
    private final RoomServiceGrpc.RoomServiceBlockingStub roomStub;

    public RoomGrpcHandler() {
        channel = ManagedChannelBuilder.forAddress(URL, 6565).
                usePlaintext().build();

        roomStub = RoomServiceGrpc.newBlockingStub(channel);
    }

    public void addRooms() {
        Room room1 = new Room(1,2);
        Room room2 = new Room(2,4);
        Room room3 = new Room(3,2);
        Room room4 = new Room(4,3);

        sendRoom(room1);
        sendRoom(room2);
        sendRoom(room3);
        sendRoom(room4);
    }

    private void sendRoom(Room room1) {
        RoomTransfer roomTransfer = RoomTransfer.newBuilder()
                .setNumber(room1.getNumber())
                .setClientNumber(room1.getClientNumber())
                .build();
        RoomRequestAdd requestAdd = RoomRequestAdd.newBuilder()
                .setRoom(roomTransfer)
                .build();
        RoomResponseAdd roomResponseAdd = roomStub.addRoom(requestAdd);

        System.out.println("roomResponseAdd = " + roomResponseAdd);
    }

    @PreDestroy
    public void close() {
        channel.shutdown();
    }
}
