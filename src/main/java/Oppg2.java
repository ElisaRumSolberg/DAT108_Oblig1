import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Oppg2 {
    private static void lonnsoppgjor( List<Ansatt> ansatte,  Function<Ansatt, Integer> beregnNyLonn ) {

        for (Ansatt a : ansatte) {
            int nyLonn = beregnNyLonn.apply(a);
            a.setAarslonn(nyLonn);
        }


    }

    public static void main(String[] args) {


        //fastTillegg
        List<Ansatt> ansatte = lagAnsatte();


        Function<Ansatt, Integer> fastTillegg =
                a -> a.getAarslonn() + 10000;

        lonnsoppgjor(ansatte, fastTillegg);

        System.out.println("Etter fast tillegg:");
        skrivUtAlle(ansatte);

        //et fast prosenttillegg

        List<Ansatt> ansatte2 = lagAnsatte();

        Function<Ansatt, Integer> prosentTillegg =
                a -> (int) (a.getAarslonn() * 1.05);

        lonnsoppgjor(ansatte2, prosentTillegg);

        System.out.println("\nEtter 5% tillegg:");
        skrivUtAlle(ansatte2);


        // Tillegg for lav lønn
        List<Ansatt> ansatte3 = lagAnsatte();

        Function<Ansatt, Integer> lavLonnTillegg =
                a -> a.getAarslonn() < 500000
                        ? a.getAarslonn() + 20000
                        : a.getAarslonn();

        lonnsoppgjor(ansatte3, lavLonnTillegg);

        System.out.println("\nEtter tillegg for lav lønn:");
        skrivUtAlle(ansatte3);


        // Fast prosenttillegg for menn

        List<Ansatt> ansatte4 = lagAnsatte();

        Function<Ansatt, Integer> mannProsentTillegg =
                a -> a.getKjonn() == Kjonn.MANN
                        ? (int) (a.getAarslonn() * 1.05)
                        : a.getAarslonn();

        lonnsoppgjor(ansatte4, mannProsentTillegg);

        System.out.println("\nEtter 5% tillegg for menn:");
        skrivUtAlle(ansatte4);

    }


    private static List<Ansatt> lagAnsatte() {
        return Arrays.asList(
                new Ansatt("Samsam", "Abdi", Kjonn.KVINNE, "Utvikler", 600000),
                new Ansatt("Elisa", "Solberg", Kjonn.KVINNE, "Sjef", 800000),
                new Ansatt("Casper", "Børretzen", Kjonn.MANN, "Tester", 550000),
                new Ansatt("Martin", "Larsen", Kjonn.MANN, "Utvikler", 450000),
                new Ansatt("Ida", "Berg", Kjonn.KVINNE, "Prosjektsjef", 900000)
        );
    }


    private static void skrivUtAlle(List<Ansatt> ansatte) {
        for (Ansatt a : ansatte) {
            System.out.println(a);
        }
    }


}
