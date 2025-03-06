package com.example.hotdesk.employment;

import com.example.hotdesk.employment.entity.Employment;
import com.example.hotdesk.room.RoomRepository;
import com.example.hotdesk.room.entity.Room;
import com.example.hotdesk.room.entity.RoomType;
import com.example.hotdesk.user.UserRepository;
import com.example.hotdesk.user.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmploymentService {

    private final EmploymentRepository employmentRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;


    public boolean isRoomAvailable(Integer roomId, LocalDate startDate, LocalDate endDate) {
        if(endDate.isBefore(startDate)){
            throw new IllegalArgumentException("End date cannot be before the start date");
        }
        List<Employment> conflictingEmployments =
                employmentRepository.findConflictingEmployments(roomId, startDate, endDate);
        return conflictingEmployments.isEmpty();
    }



    @Transactional
    public Employment createEmployment(Integer userId, Integer roomId, RoomType roomType,
                                       LocalDate startDate, LocalDate endDate) {

        if (!isRoomAvailable(roomId, startDate, endDate)) {
            throw new IllegalArgumentException("Room is not available for the selected time.");
        }


        if(endDate.isBefore(startDate)){
            throw new IllegalArgumentException("End date cannot be before the start date");
        }


        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));

        Employment employment = new Employment();
        employment.setUser(user);
        employment.setRoom(room);
        employment.setRoomType(roomType);
        employment.setStarted(startDate);
        employment.setEnded(endDate);


        return employmentRepository.save(employment);
    }




}




