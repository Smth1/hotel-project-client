package com.roma.distr.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class AdministratorDTO {
    private String id;
    private String name;
    private int age;
    private String telephoneNumber;

    public AdministratorDTO(String name, int age, String telephoneNumber) {
        this.name = name;
        this.age = age;
        this.telephoneNumber = telephoneNumber;
    }
}
