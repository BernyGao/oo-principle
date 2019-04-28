package cc.oobootcamp.principle.srp;

import org.junit.Assert;
import org.junit.Test;

public class StringHandlerClientTest {

    @Test
    public void should_get_short_date_when_given_date_with_dash() {

        String source = "2018-10-10";

        ConvertStringHandler convertStringHandler = new ConvertStringHandler(source);

        String target = convertStringHandler.convert();

        Assert.assertEquals("20181010", target);
    }

    @Test
    public void should_get_char_count_when_given_invaid_date() {

        String source = "201810aaa10";

        ConvertStringHandler convertStringHandler = new ConvertStringHandler(source);

        String target = convertStringHandler.convert();

        Assert.assertEquals("{0=3, 1=3, a=3, 2=1, 8=1}", target);
    }

    @Test
    public void should_get_short_date_when_given_date_with_slash() {

        String source = "19/01/2019";

        ConvertStringHandler convertStringHandler = new ConvertStringHandler(source);

        String target = convertStringHandler.convert();

        Assert.assertEquals("19012019", target);
    }
}
