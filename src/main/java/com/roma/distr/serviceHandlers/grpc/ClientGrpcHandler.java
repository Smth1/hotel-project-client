package com.roma.distr.serviceHandlers.grpc;

import com.roma.distr.api.grpc.*;
import com.roma.distr.entities.HotelClient;
import com.roma.distr.entities.dto.HotelClientDTO;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.annotation.PreDestroy;
import java.util.Optional;

public class ClientGrpcHandler {
    private final String URL = "localhost";

    private final ManagedChannel channel;
    private final ClientServiceGrpc.ClientServiceBlockingStub clientStub;

    public ClientGrpcHandler() {
        channel = ManagedChannelBuilder.forAddress(URL, 6560).
                usePlaintext().build();

        clientStub = ClientServiceGrpc.newBlockingStub(channel);
    }

    public void serveClients() {
        HotelClientDTO client1 = new HotelClientDTO("Asher");
        HotelClientDTO client2 = new HotelClientDTO("Oliver");
        HotelClientDTO client3 = new HotelClientDTO("Silas");
        HotelClientDTO client4 = new HotelClientDTO("Atticus");

        sendClient(client1);
        sendClient(client2);
        sendClient(client3);
        sendClient(client4);
    }

    private void sendClient(HotelClientDTO clientDTO) {
        ClientTransfer clientTransfer1 = ClientTransfer.newBuilder()
                .setId(clientDTO.getClientId().toString())
                .setName(clientDTO.getClientName())
                .build();

        ClientRequestAdd requestAdd1 = ClientRequestAdd.newBuilder()
                .setClient(clientTransfer1)
                .build();

        ClientResponseAdd clientResponseAdd = clientStub.addClient(requestAdd1);

        System.out.println("clientResponseAdd = " + clientResponseAdd);
    }

    public void moveOutClients() {
        ClientsResponseGet allClients = clientStub.getClients(ClientsRequestGet.newBuilder()
                .setRequest("Get all clients")
                .build());
        Optional<ClientTransfer> clientTransfer = allClients.getClientsTransferList().stream().findAny();
        if (clientTransfer.isPresent()) {
            ClientTransfer transfer = clientTransfer.get();
            String id = transfer.getId();

            ClientResponseDelete responseDelete = clientStub.deleteClient(ClientRequestDelete.newBuilder()
                    .setUuid(id)
                    .build());
            System.out.println("responseDelete = " + responseDelete);
        } else {
            System.out.println("There are no clients");
        }
    }

    @PreDestroy
    public void close() {
        channel.shutdown();
    }
}
