

public class Main {

    public static void main(String[] args) {
        ParserJson parserJson = new ParserJson("src/main/resources/events.json");
        parserJson.jsonToObjects();
        parserJson.printLogs();

    }
}
