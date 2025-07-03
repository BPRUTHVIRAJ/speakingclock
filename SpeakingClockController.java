package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpeakingClock.service.TimeService;


@RestController
@RequestMapping("/api/time")
public class SpeakingClockController {

    @Autowired
    private TimeService timeService;

    @GetMapping("/{time}")
    public ResponseEntity<String> getSpokenTime(@PathVariable String time) {
        return ResponseEntity.ok("It's " + timeService.convertTimeToWords(time));
    }

}
