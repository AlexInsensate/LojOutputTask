import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;


public class ParserJson {

    private final String filename;
    private List<Event> data;
    int currentSeconds = 0;
    private Timer timer;

    public ParserJson(String _filename) {
        filename = _filename;
        timer = new Timer();
    }

    public void jsonToObjects() {
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Event>>() {}.getType();
            JsonReader reader = new JsonReader(new FileReader(filename));
            data = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printLogs() {
        for (Event e : data) {
            e.stringToDate();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                currentSeconds += 500;
                for (Event e : data) {
                    if ((e.getDatеtime().getMinutes() * 60000 + e.getDatеtime().getSeconds()*1000) == currentSeconds) {
                        System.out.println(e.getEventName());
                    }
                }
            }
        }, 0, 500);

    }

}
