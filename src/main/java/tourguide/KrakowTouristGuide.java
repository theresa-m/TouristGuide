package tourguide;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class KrakowTouristGuide {
    /* Attraction name, description, distance from Devoxx Poland 2022 */
    record Attraction(String name, String description, double distanceKms) {
        public String toString() {
            return name + "\n"
                    + distanceKms + " kms from Devoxx Poland 2022" + "\n"
                    + description;
        }
    }

    static List<Attraction> cityAttractions = new LinkedList<>();
    static Logger log = LogManager.getLogger(KrakowTouristGuide.class.getName());

    public static void main(String[] args) {
        cityAttractions.add(new Attraction("National Museum",
                "3 permanent galleries displaying artworks & historical artifacts from Poland & elsewhere in Europe.",
                1.9));
        cityAttractions.add(new Attraction("Kraków Eye",
                "Ferris wheel with a view",
                0.35));

        Random r = new Random();

        System.out.println("What should you see while in Kraków, Poland?\n");

        int i = r.nextInt(cityAttractions.size() + 1);
        System.out.println(cityAttractions.get(i).toString());
    }
}
