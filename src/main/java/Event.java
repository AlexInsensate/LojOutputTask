import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class Event {
    private String eventName;
    private String time;

    private Date datеtime;

    public void stringToDate() {
        SimpleDateFormat ft = new SimpleDateFormat("mm:ss");
        try {
            datеtime = ft.parse(time);
        } catch (ParseException e) {
            System.out.println("Date parse error!");
        }
    }

    public Date getDatеtime() {
        return datеtime;
    }

    public String getEventName() {
        return eventName;
    }

    public String getTime() {
        return time;
    }
}
