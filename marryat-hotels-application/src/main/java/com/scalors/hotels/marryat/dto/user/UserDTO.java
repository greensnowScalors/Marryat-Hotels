package com.scalors.hotels.marryat.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scalors.marryat.hotels.entities.users.AccessType;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;

@Data
public class UserDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("login")
    private String login;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("first_name")
    private String middleName;
    @JsonProperty("access_type")
    private AccessType accessType;
}
