package com.scalors.marryat.hotels.entities.rooms;

import com.scalors.marryat.hotels.entities.templates.BaseEntityId;
import com.scalors.marryat.hotels.entities.users.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Room", indexes = {
        @Index(name = "idx_rooms_roomId", columnList = "id")
})
public class Room extends BaseEntityId {

    @Column(name = "roomNumber")
    private Long roomNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId")
    private RoomTemplate room;

    @Column(name = "startReserveDay")
    private LocalDate startReserveDay;

    @Column(name = "endReserveDay")
    private LocalDate endReserveDay;

    @Column(name = "comment")
    private String comment;
}
