package UnitTestPackage;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.SpeakingClock.service.TimeService;

import Exception.InvalidTimeFormatException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeServiceTest {

    @Autowired
    private TimeService timeService;

    @Test
    public void testMidnight() {
        Assert.assertEquals("Midnight", timeService.convertTimeToWords("00:00"));
    }

    @Test
    public void testMidday() {
        Assert.assertEquals("Midday", timeService.convertTimeToWords("12:00"));
    }

    @Test
    public void testRegularTime() {
        Assert.assertEquals("eight thirty four", timeService.convertTimeToWords("08:34"));
    }

    @Test(expected = InvalidTimeFormatException.class)
    public void testInvalidTime() {
        timeService.convertTimeToWords("25:00");
    }
}
