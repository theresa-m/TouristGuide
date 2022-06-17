package tourguide;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class KrakowTouristGuide {
    static final Double DEVOXXPOLANDRADIUS = 0.0;
    static final Double WALKRADIUS = 2.5;
    static List<Attraction> cityAttractions = new LinkedList<>();
    static Logger log = LogManager.getLogger(KrakowTouristGuide.class.getName());

    /* Attraction name, description, distance from Devoxx Poland 2022 */
    record Attraction(String name, String description, Double distance) {
        public String print() {
            return name + "\n" + distanceMessage() + "\n" + description;
        }

        private String distanceMessage() {
            if (distance == DEVOXXPOLANDRADIUS) {
                return "This attraction is at Devoxx Poland!";
            } else if (distance < WALKRADIUS){
                return "A walkable " + distance.toString() + " kms from Devoxx Poland 2022";
            } else {
                return distance.toString() + " kms from Devoxx Poland 2022";
            }
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        initializeAttractionsList();
        printIntro();

        while (true) {
            try {
                /* wait for enter key press to continue */
                System.in.read();

                /* show user a randomly chosen attraction */
                Attraction attraction = cityAttractions.get(r.nextInt(cityAttractions.size()));
                log.info(attraction.name());
                System.out.println(attraction.print());
            } catch (Throwable t) {
                log.error(t.getMessage());
                t.printStackTrace(System.err);
            }
        }
    }

    private static void initializeAttractionsList() {
        cityAttractions.add(new Attraction("Sonatype Booth", "Come learn about Sonatype at Devoxx Poland!", 0.0));
        cityAttractions.add(new Attraction("National Museum",
                "3 permanent galleries displaying artworks & historical artifacts from Poland & elsewhere in Europe.",
                1.9));
        cityAttractions.add(new Attraction("Kraków Eye",
                "Ferris wheel with a view",
                0.35));
        cityAttractions.add(new Attraction("St Mary's Basilica",
                "A brick gothic church bult in the 14th century",
                2.1));
        cityAttractions.add(new Attraction("Wawel Royal Castle",
                "The castle, being one of the largest in Poland, represents nearly all European architectural styles of medieval, renaissance and baroque periods.",
                1.3));
    }

    private static void printIntro() {
        System.out.println("What should you see while in Kraków, Poland?");

        System.out.println(" ____  __.              __              ___________                     ________      .__    .___      ");
        System.out.println("|    |/ _|___________  |  | ____  _  __ \\__    ___/___  __ _________   /  _____/ __ __|__| __| _/____  ");
        System.out.println("|      < \\_  __ \\__  \\ |  |/ /\\ \\/ \\/ /   |    | /  _ \\|  |  \\_  __ \\ /   \\  ___|  |  \\  |/ __ |/ __ \\ ");
        System.out.println("|    |  \\ |  | \\// __ \\|    <  \\     /    |    |(  <_> )  |  /|  | \\/ \\    \\_\\  \\  |  /  / /_/ \\  ___/ ");
        System.out.println("|____|__ \\|__|  (____  /__|_ \\  \\/\\_/     |____| \\____/|____/ |__|     \\______  /____/|__\\____ |\\___  >");
        System.out.println("        \\/           \\/     \\/                                                \\/              \\/    \\/ ");

        System.out.println("\t\t                                    +              #####");
        System.out.println("\t\t                                   / \\");
        System.out.println("\t\t _____        _____     __________/ o \\/\\_________      _________");
        System.out.println("\t\t|o o o|_______|    |___|               | | # # #  |____|o o o o  | /\\");
        System.out.println("\t\t|o o o|  * * *|: ::|. .|               |o| # # #  |. . |o o o o  |//\\\\");
        System.out.println("\t\t|o o o|* * *  |::  |. .| []  []  []  []|o| # # #  |. . |o o o o  |((|))");
        System.out.println("\t\t|o o o|**  ** |:  :|. .| []  []  []    |o| # # #  |. . |o o o o  |((|))");
        System.out.println("\t\t|_[]__|__[]___|_||_|__<|____________;;_|_|___/\\___|_.|_|____[]___|  |");

        System.out.println("\n\nPress enter to find out what you should see while visiting the city!\n");
    }
}
