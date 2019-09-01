package com.scalors.marryat.hotels.entities.users;

import com.scalors.marryat.hotels.entities.rooms.Reservation;
import com.scalors.marryat.hotels.entities.templates.BaseEntityId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true, of = {})
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Users", indexes = {
        @Index(name = "idx_users_userId", columnList = "id")
})

public class User extends BaseEntityId {

    @Column(name = "login")
    private String login;

    @Column(name = "accessType")
    @Enumerated(EnumType.STRING)
    private AccessType accessType;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "middleName")
    private String middleName;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;


}
