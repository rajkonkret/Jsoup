import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class Offer {
    private String name;
    private String http;
    private String price;

    Offer(String name, String http) {
        this.name = name;
        this.http = http;
    }


    @Override
    public String toString() {
        return "Offer{" +
                "name='" + name + '\'' +
                ", http='" + http + '\'' +
                '}';
    }

    String givePrice() throws IOException {

        try {
            Document document = Jsoup.connect(http).get();
            return "Cena z klasy: " + document.getElementsByClass("price-label").text();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Brak ceny";
    }

    public String getName() {
        return name;
    }

    public String getHttp() {
        return http;
    }
}
