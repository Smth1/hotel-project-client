package com.roma.distr.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@AllArgsConstructor
@Builder
public final class CleaningReportDTO {
    private UUID id;

    private  UUID administratorId;

    private  UUID maidId;

    private String rooms;

    private String creationDate;

    public CleaningReportDTO() {
    }

    public CleaningReportDTO(UUID administrator, UUID maid, String rooms) {
        this.id = UUID.randomUUID();
        this.administratorId = administrator;
        this.maidId = maid;
        this.rooms = rooms;
        this.creationDate = LocalDateTime.now().toString();
    }

    public UUID getId() {
        return id;
    }

    public UUID getAdministratorId() {
        return administratorId;
    }

    public UUID getMaidId() {
        return maidId;
    }

    public String getRooms() {
        return rooms;
    }

    public String getCreationDate() {
        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return creationDate;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setAdministratorId(UUID administrator) {
        this.administratorId = administrator;
    }

    public void setMaidId(UUID maid) {
        this.maidId = maid;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        StringBuilder reportBuilder = new StringBuilder();
        StringBuilder roomNumbers = new StringBuilder();

        roomNumbers.append("[");
        roomNumbers.append(this.rooms);
        roomNumbers.append("]");

        reportBuilder.append("               CleaningReport          " + "\n" +
                "   id: " + this.getId() + "\n" +
                "   administrator: " + this.getAdministratorId() + "\n" +
                "   maid: " + this.getMaidId() + "\n");
        reportBuilder.append("   room numbers: ");
        reportBuilder.append(roomNumbers);
        reportBuilder.append("\n");
        reportBuilder.append("   creationDate: " + this.getCreationDate());
        return reportBuilder.toString();
    }
}
