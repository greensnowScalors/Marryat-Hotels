package com.scalors.marryat.hotels.entities.rooms;

import com.scalors.marryat.hotels.entities.hotels.Hotel;
import com.scalors.marryat.hotels.entities.templates.BaseEntityId;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, of = {})
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "RoomTemplate", indexes = {
        @Index(name = "idx_room_templates_room_templateId", columnList = "id")
})
public class RoomTemplate extends BaseEntityId {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelId")
    private Hotel hotel;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();

}
