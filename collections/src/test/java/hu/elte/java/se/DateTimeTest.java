package hu.elte.java.se;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class DateTimeTest {

    @Test
    public void epochTimeZero(){
        DateTime dateTime = new DateTime(0L);
        int result = Instant.EPOCH.compareTo(dateTime.toInstant());
        assertThat(result).isZero();
    }
}
