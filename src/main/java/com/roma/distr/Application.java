package com.roma.distr;

import com.roma.distr.serviceHandlers.grpc.*;
import com.roma.distr.serviceHandlers.rabbitmq.RoomMqHandler;
import com.roma.distr.serviceHandlers.rest.*;

public class Application {
    private static final String delimiter = "....................------------------------......................";

    public static void main(String[] args) {
        Application app = new Application();
        app.rabbitmqHandler();
    }

    private void restHandler() {
        System.out.println("Hotel started its work\n" + delimiter);

        AdminRestHandler adminHandler = new AdminRestHandler();
        RoomRestHandler roomHandler = new RoomRestHandler();
        HouseKeepingRestHandler houseKeepingHandler = new HouseKeepingRestHandler();
        ContractRestHandler contractHandler = new ContractRestHandler();
        ClientRestHandler clientRestHandler = new ClientRestHandler();

        System.out.println("\nCreating hotel staff \n" +  delimiter);
        adminHandler.addEmployees();

        System.out.println("\nCreating hotel rooms \n" + delimiter);
        roomHandler.addRooms();

        System.out.println("\nRooms must be clean before settling");
        houseKeepingHandler.cleanRooms();

        System.out.println("\nClients are at the reception\n" + delimiter);
        clientRestHandler.serveClients();

        System.out.println("\nMoving out clients \n" + delimiter);
        clientRestHandler.moveOutClients();

        System.out.println("\nCustomer contracts \n" + delimiter);
        contractHandler.printContracts();

        System.out.println("\nAll cleaning reports for this period \n" + delimiter);
        houseKeepingHandler.printReports();
    }

    private void grpcHandler() {
        System.out.println("Hotel started its work\n" + delimiter);

        AdminGrpcHandler adminGrpcHandler = new AdminGrpcHandler();
        RoomGrpcHandler roomGrpcHandler = new RoomGrpcHandler();
        HouseKeepingGrpcHandler houseKeepingGrpcHandler = new HouseKeepingGrpcHandler();
        ContractGrpcHandler contractGrpcHandler = new ContractGrpcHandler();
        ClientGrpcHandler clientGrpcHandler = new ClientGrpcHandler();

        System.out.println("\nCreating hotel staff \n" +  delimiter);
        adminGrpcHandler.addEmployees();

        System.out.println("\nCreating hotel rooms \n" + delimiter);
        roomGrpcHandler.addRooms();

        System.out.println("\nRooms must be clean before settling");
        houseKeepingGrpcHandler.cleanRooms();

        System.out.println("\nClients are at the reception\n" + delimiter);
        clientGrpcHandler.serveClients();

        System.out.println("\nMoving out clients \n" + delimiter);
        clientGrpcHandler.moveOutClients();

        System.out.println("\nCustomer contracts \n" + delimiter);
        contractGrpcHandler.printContracts();

        System.out.println("\nAll cleaning reports for this period \n" + delimiter);
        houseKeepingGrpcHandler.printReports();
    }

    private void rabbitmqHandler() {
        System.out.println("Rabbitmq Provider\n" + delimiter);

        RoomMqHandler roomMqHandler = new RoomMqHandler();

        roomMqHandler.addRooms();
    }
}
