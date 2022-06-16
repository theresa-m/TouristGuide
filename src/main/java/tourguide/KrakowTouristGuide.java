package tourguide;

import java.util.LinkedList;
import java.util.List;

/* Attraction name, description, distance from Devoxx Poland 2022 */
record Attraction(String name, String description, double distanceKms) { }

public class KrakowTouristGuide {
    static List<Attraction> cityAttractions = new LinkedList<Attraction>();

    public static void main(String[] args) {
        cityAttractions.add(new Attraction("National Museum",
                "3 permanent galleries displaying artworks & historical artifacts from Poland & elsewhere in Europe.",
                1.9));
        cityAttractions.add(new Attraction("Kraków Eye",
                "Ferris wheel with a view",
                0.35));

        while(true) {

        }
    }
}
