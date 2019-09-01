package com.scalors.marryat.hotels.entities.rooms;

import com.scalors.marryat.hotels.entities.templates.BaseEntityId;
import com.scalors.marryat.hotels.entities.users.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, of = {})
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Reservation", indexes = {
        @Index(name = "idx_reservations_reservationsId", columnList = "id")
})
public class Reservation extends BaseEntityId {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId")
    private Room room;

    @Column(name = "startReserveDay")
    private LocalDate startReserveDay;

    @Column(name = "endReserveDay")
    private LocalDate endReserveDay;

    @Column(name = "comment")
    private String comment;
}
