
import java.io.*;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.List;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.json.*;

public class ParserJson {

    private final String filename;
    private List<Event> data;

    public ParserJson(String _filename) {
        filename = _filename;
    }

    public void jsonToObjects() {
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Event>>()  {}.getType();
            JsonReader reader = new JsonReader(new FileReader(filename));
            data = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        for (Event e : data) {
            System.out.println("Title: " + e.getTime() + "\nName: " + e.getEventName()
                    + "\n");
        }
    }

}
