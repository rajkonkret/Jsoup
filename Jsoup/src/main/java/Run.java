import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;

public class Run {
    public static void main(String[] args) throws IOException {

        String link = "https://www.olx.pl/moda/";
        int pages = 0;
        List<Offer> offersList = new LinkedList<>();

        try {
            Document documentPage = Jsoup.connect(link).get();
            Elements elements1 = documentPage
                    .getElementsByAttributeValueContaining("data-cy", "page-link-last");

            pages = Integer.parseInt(elements1.text());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Elements elements2;

        for (int i = 1; i <= 5; i++) {
            Document document =
                    Jsoup.connect(link + "?page=" + i).get();

            elements2 = document.getElementsByClass("link linkWithHash detailsLink");

            System.out.println("Elementy = page: " + i + " " + elements2.size());
            for (Element elementsIn : elements2) {

                Offer offerToAdd = new Offer(elementsIn.attr("title"), elementsIn.attr("href"));
                offersList.add(offerToAdd);
            }
        }

        offersList.forEach(s -> {

            try {
                System.out.println(s + " cena: " + s.givePrice());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Ilość stron: " + pages);
    }
}