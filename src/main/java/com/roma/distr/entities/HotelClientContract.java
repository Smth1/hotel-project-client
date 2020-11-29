package com.roma.distr.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class HotelClientContract {
    private UUID id;
    private Administrator hotelAdmin;
    private HotelClient client;
    private Cashier cashier;
    private Porter porter;
    private Room room;
    private String creationDate;
    private String closingDate;
    private boolean isOpen;

    public HotelClientContract(Administrator hotelAdmin,
                               HotelClient client,
                               Room room,
                               Cashier cashier,
                               Porter porter) {
        DateTimeFormatter dataTimeFormatter =
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        this.id = UUID.randomUUID();
        this.hotelAdmin = hotelAdmin;
        this.client = client;
        this.room = room;
        this.cashier = cashier;
        this.porter = porter;
        this.creationDate = LocalDateTime.now().toString();
        isOpen = true;
    }

    public UUID getId() {
        return id;
    }

    public Administrator getHotelAdmin() {
        return hotelAdmin;
    }

    public Room getRoom() {
        return room;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public Porter getPorter() {
        return porter;
    }

    public String getCreationDate() {
        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return creationDate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("               ClientHotelContract                 \n");
        builder.append(" contract id: ").append(id).append("\n");
        builder.append(" hotelAdmin: ").append(this.getHotelAdmin().getName()).append(" ");
        builder.append(" telephoneNumber: " + this.getHotelAdmin().getTelephoneNumber() + "\n");
        builder.append(" room number: ").append(this.getRoom().getNumber()).append("\n");
        builder.append(" client: " + client + "\n");
        builder.append(" cashier at reception: " + this.getCashier().getName() + "\n");
        builder.append(" attendant porter: ").append(this.getPorter().getName()).append("\n");
        builder.append(" creationDate: ").append(this.getCreationDate());

        return builder.toString();
    }
}
