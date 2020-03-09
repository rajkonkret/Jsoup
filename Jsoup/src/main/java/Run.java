import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Run {
    public static void main(String[] args) throws IOException {

//        String link = "https://www.otomoto.pl/osobowe/audi/a4/b8-2007-2015/od-2015/?search%5Bfilter_float_year%3Ato" +
//                "%5D=2015&search%5Bfilter_enum_fuel_type%5D%5B0%5D=diesel&search%5Border%5D=created_at%3Adesc&search%5Bbrand_program_id%5D%5B0%5D=&search%5Bcountry%5D=&page=";
        // String link = "https://www.olx.pl/motoryzacja/";
        String link = "https://www.olx.pl/moda/";
        Integer pages = 0;
        List<Offer> offersList = new LinkedList<Offer>();

        try {
            Document documentPage = Jsoup.connect(link).get();
            Elements elements1 = documentPage
                    .getElementsByAttributeValueContaining("data-cy", "page-link-last");
            //System.out.println("pages");
            //ostatnia strona
            //System.out.println(elements1.text());
            pages = Integer.valueOf(elements1.text());
            // System.out.println(documentPage);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Elements elements = new Elements();
        Elements elements2;
        List<Element> allPagesElements = new LinkedList<>();
        List<Element> allNameOfOffer = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            Document document =
                    Jsoup.connect(link + "?page=" + i).get();
            //elements = document.getElementsByClass("price");
            elements2 = document.getElementsByClass("link linkWithHash detailsLink");
            //   System.out.println(elements.size());
            //   System.out.println(elements2.size());
//            System.out.println("LINK DO OGŁOSZENIA" + elements2.get(1).attr("href"));
//            System.out.println("LINK DO OGŁOSZENIA" + elements2.get(1).attr("title"));
            System.out.println("Elementy = page: "+ i + " " + elements2.size());
            for (Element elementsIn : elements2) {


                //Offer offerToAdd = new Offer(elements2.get(1).attr("title"), elements2.get(1).attr("href"));
                Offer offerToAdd = new Offer(elementsIn.attr("title"), elementsIn.attr("href"));
                offersList.add(offerToAdd);
//                System.out.println(offerToAdd);
//                offerToAdd.givePrice();
                //allPagesElements.add(elements);
                // elements.forEach(s -> allPagesElements.add(s));
                //allNameOfOffer.add(elements2.attr("title"));
                //System.out.println(elements2);
                //elements2.forEach(s -> allNameOfOffer.add(s));
                //  System.out.println(elements2);
            }

        }
//        List<String> listOffers = Arrays.stream(elements.text()
//                .replace(",", ".")
//                .split("zł"))
//                //.map(s -> s.replaceAll("\\D", ""))
//                .collect(Collectors.toList());


        //System.out.println(listOffers.get(0));
//        List<Integer> listOffersValue = listOffers.stream()
//                .map(s -> Integer.valueOf(s))
//                .collect(Collectors.toList());
        //System.out.println(Integer.valueOf(listOffers.get(0)));
        //System.out.println(Integer.valueOf(listOffersValue.get(0) * 2));
//        listOffers.forEach(s -> System.out.println(s));
//        allNameOfOffer.forEach(s -> {
//
//            System.out.println(s);
//        });

//        int a = 0;
//        for (Element name : allNameOfOffer) {
//            a++;
//            System.out.println(name.attr("title"));
//            System.out.println(name.attr("href") + " cena: ");
//            Document documentPage = Jsoup.connect(name.attr("href")).get();
//            System.out.println(documentPage.getElementsByClass("price-label").text());
//        }

        offersList.stream().forEach(s -> {

            try {
                System.out.println(s + " cena: " + s.givePrice());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Ilość stron: " + pages);

        // System.out.println("rozmiar elementów");
        // System.out.println(allPagesElements.size());


//        List<String> elementsList = new LinkedList<>();
//        for (Elements elements1 : allPagesElements) {
//            for (int i = 0; i < elements1.size(); i++) {
//                elementsList.add(elements1.get(i).text());
    }
}

//        System.out.println("ilość znalezionych samochodów o podanych kryteriach " + elementsList.size());
//        // System.out.println(elementsList);
//        String word = null;
//        String word2 = null;
//
//        List<String> wihtoutSpaces = new ArrayList<>();
//        for (String s : elementsList) {
//            word = s.replace(" ", "");
//            wihtoutSpaces.add(word);
//        }
//
//        // System.out.println(wihtoutSpaces);
//
//        List<String> onyDigits = new ArrayList<>();
//        for (String s : wihtoutSpaces) {
//            word2 = s.substring(0, s.indexOf("P"));
//            onyDigits.add(word2);
//        }
//
//        double sum = 0;
//        double number = 0;
//        List<Double> doublePricse = new ArrayList<>();
//        for (String s : onyDigits) {
//            number = Double.parseDouble(s);
//            sum += number;
//            doublePricse.add(number);
//        }
//
//        // System.out.println(onyDigits);
//
//
//        System.out.println(String.format("średnia cena %,.2f", sum / doublePricse.size()));
//
////       // System.out.println(allPagesElements);
////        Elements elements1 = (allPagesElements.get(0));
////        for (Element element : elements1) {
////            System.out.println(element.text());
////        }
////
////
//////            System.out.println("audi a4 otomoto");
////            for (Element element : elements) {
////                System.out.println(element.text());
////            }
//
//        //odczytuje liczbę stron
//
///*
//            List<String> prices = elements.stream()
//                    .map(s -> s.text())
//                    .collect(Collectors.toList());
//
//            List<String> doubleList = new ArrayList<>();
//            for (int i = 2; i < prices.size(); i++) {
//                doubleList.add(prices.get(i).substring(0,prices.get(i).indexOf("z")-1));
//            }
//           List<Double> doubleList1 = doubleList.stream()
//                   .map(s -> s.replace(" ",""))
//                   .map(s -> Double.parseDouble(s))
//                   .collect(Collectors.toList());
//
//            System.out.println(doubleList1);
//            double sum = 0;
//            for (Double d : doubleList1) {
//                sum+=d;
//            }
//            double average = sum/doubleList.size();
//            System.out.println();
//            System.out.println("dane pobrane z 1 strony olx");
//            System.out.println(String.format("audi a4, rok 2015, diesel, skrzynia manualna, nieuszkodzony " +
//                    "średnia cena wynosi %,.2f zł ", average));
//*/
//


