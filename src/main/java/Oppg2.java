import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Oppg2 {

    private static void lonnsoppgjor(
            List<Ansatt> ansatte,
            Function<Ansatt, Integer> beregnNyLonn
    ) {

        for (Ansatt a : ansatte) {
            int nyLonn = beregnNyLonn.apply(a);
            a.setAarslonn(nyLonn);
        }
    }


    public static void main(String[] args) {

        System.out.println("Oppgave 2 - Lambda-uttrykk og lønnsoppgjør");


        // -------------------------------------------------
        // 1. Fast kronetillegg
        // -------------------------------------------------

        System.out.println("1. Fast kronetillegg: +10 000 kr");

        List<Ansatt> ansatte1 = lagAnsatte();

        Function<Ansatt, Integer> fastTillegg =
                a -> a.getAarslonn() + 10000;

        lonnsoppgjor(ansatte1, fastTillegg);

        skrivUtAlle(ansatte1);


        // -------------------------------------------------
        // 2. Fast prosenttillegg
        // -------------------------------------------------

        System.out.println("\n2. Fast prosenttillegg: +5%");

        List<Ansatt> ansatte2 = lagAnsatte();

        Function<Ansatt, Integer> prosentTillegg =
                a -> (int) (a.getAarslonn() * 1.05);

        lonnsoppgjor(ansatte2, prosentTillegg);

        skrivUtAlle(ansatte2);


        // -------------------------------------------------
        // 3. Fast kronetillegg for ansatte med lav lønn
        // -------------------------------------------------

        System.out.println(
                "\n3. Fast kronetillegg for ansatte med lønn under 500 000 kr: +20 000 kr"
        );

        List<Ansatt> ansatte3 = lagAnsatte();

        Function<Ansatt, Integer> lavLonnTillegg =
                a -> a.getAarslonn() < 500000
                        ? a.getAarslonn() + 20000
                        : a.getAarslonn();

        lonnsoppgjor(ansatte3, lavLonnTillegg);

        skrivUtAlle(ansatte3);


        // -------------------------------------------------
        // 4. Fast prosenttillegg for menn
        // -------------------------------------------------

        System.out.println("\n4. Fast prosenttillegg for menn: +5%");

        List<Ansatt> ansatte4 = lagAnsatte();

        Function<Ansatt, Integer> mannProsentTillegg =
                a -> a.getKjonn() == Kjonn.MANN
                        ? (int) (a.getAarslonn() * 1.05)
                        : a.getAarslonn();

        lonnsoppgjor(ansatte4, mannProsentTillegg);

        skrivUtAlle(ansatte4);
    }


    private static List<Ansatt> lagAnsatte() {

        return Arrays.asList(
                new Ansatt(
                        "Samsam",
                        "Abdi",
                        Kjonn.KVINNE,
                        "Utvikler",
                        600000
                ),

                new Ansatt(
                        "Elisa",
                        "Solberg",
                        Kjonn.KVINNE,
                        "Sjef",
                        800000
                ),

                new Ansatt(
                        "Casper",
                        "Børretzen",
                        Kjonn.MANN,
                        "Tester",
                        550000
                ),

                new Ansatt(
                        "Martin",
                        "Larsen",
                        Kjonn.MANN,
                        "Utvikler",
                        450000
                ),

                new Ansatt(
                        "Ida",
                        "Berg",
                        Kjonn.KVINNE,
                        "Prosjektsjef",
                        900000
                )
        );
    }


    private static void skrivUtAlle(List<Ansatt> ansatte) {

        for (Ansatt a : ansatte) {
            System.out.println(a);
        }
    }
}