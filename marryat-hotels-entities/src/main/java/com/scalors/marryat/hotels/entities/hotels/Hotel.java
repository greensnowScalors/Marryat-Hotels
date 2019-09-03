package com.scalors.marryat.hotels.entities.hotels;

import com.scalors.marryat.hotels.entities.rooms.RoomTemplate;
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
public class Hotel extends BaseEntityId {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoomTemplate> rooms = new ArrayList<>();


}
