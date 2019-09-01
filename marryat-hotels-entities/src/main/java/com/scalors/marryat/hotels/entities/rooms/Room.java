package com.scalors.marryat.hotels.entities.rooms;

import com.scalors.marryat.hotels.entities.hotels.Hotel;
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
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, of = {})
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Room", indexes = {
        @Index(name = "idx_room_roomId", columnList = "id")
})
public class Room extends BaseEntityId {


//    @Column(name = "startReserveDay")
//    private LocalDate startReserveDay;
//
//    @Column(name = "endReserveDay")
//    private LocalDate endReserveDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelId")
    private Hotel hotel;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> rooms;

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<User> users;


//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "UsersRooms"
////            indexes = {@Index(name = "idx_room_roomId", columnList = "roomId")}
//            , joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id")
//            , inverseJoinColumns = @JoinColumn(name = "roomId", referencedColumnName = "id")
//            , uniqueConstraints = {@UniqueConstraint(columnNames = {"roomId", "userId"})})
//    private List<User> users;


}
