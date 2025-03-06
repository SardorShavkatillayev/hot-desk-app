package com.example.hotdesk.employment;

import com.example.hotdesk.employment.entity.Employment;
import com.example.hotdesk.room.entity.RoomType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("employment")
@RequiredArgsConstructor
public class EmploymentController {

    private final EmploymentService employmentService;

    @GetMapping("/checkAvailability")
    public boolean checkRoomAvailability(@RequestParam Integer roomId,
                                         @RequestParam String startDate,
                                         @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return employmentService.isRoomAvailable(roomId, start, end);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Employment createEmployment(@RequestParam Integer userId,
                                       @RequestParam Integer roomId,
                                       @RequestParam RoomType roomType,
                                       @RequestParam String startDate,
                                       @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return employmentService.createEmployment(userId, roomId, roomType, start, end);
    }


}
