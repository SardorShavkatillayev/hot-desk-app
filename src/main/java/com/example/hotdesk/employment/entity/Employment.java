package com.example.hotdesk.employment.entity;

import com.example.hotdesk.room.entity.Room;
import com.example.hotdesk.room.entity.RoomType;
import com.example.hotdesk.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Employment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private LocalDate started;

    private LocalDate ended;

}
