import serviceHandlers.*;

public class Main {
    private static final String delimiter = "....................------------------------......................";

    public static void main(String[] args) {

        System.out.println("Hotel started its work\n" + delimiter);

        AdminHandler adminHandler = new AdminHandler();
        RoomHandler roomHandler = new RoomHandler();
        HouseKeepingHandler houseKeepingHandler = new HouseKeepingHandler();
        ContractHandler contractHandler = new ContractHandler();
        ClientHandler clientHandler = new ClientHandler();

        System.out.println("\nCreating hotel staff \n" +  delimiter);
        adminHandler.addEmployees();

        System.out.println("\nCreating hotel rooms \n" + delimiter);
        roomHandler.addRooms();

        System.out.println("\nRooms must be clean before settling");
        houseKeepingHandler.cleanRooms();

        System.out.println("\nClients are at the reception\n" + delimiter);
        clientHandler.serveClients();

        System.out.println("\nMoving out clients \n" + delimiter);
        clientHandler.moveOutClients();

        System.out.println("\nCustomer contracts \n" + delimiter);
        contractHandler.printContracts();

        System.out.println("\nAll cleaning reports for this period \n" + delimiter);
        houseKeepingHandler.printReports();
    }
}
