import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author djb
 * @create 2019-05-27 13:49
 */
public class DateTest {

    @Test
    public void test1() throws InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date();
        Thread.sleep(3000);
        Date date2 = new Date();

        if (date2.after(date1)){

            System.out.println(sdf.format(date1));
            System.out.println(sdf.format(date2));
        }

    }
}
