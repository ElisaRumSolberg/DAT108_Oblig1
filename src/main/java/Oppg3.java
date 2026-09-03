import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Oppg3 {

    public static void main(String[] args) {

        List<Ansatt> ansatte = lagAnsatte();


        // Oppgave 3a
        System.out.println("Oppgave 3a");

        List<String> etternavnListe = ansatte.stream()
                .map(a -> a.getEtternavn())
                .toList();

        System.out.println("Etternavn:");
        System.out.println(etternavnListe);


        // Oppgave 3b
        System.out.println("\nOppgave 3b");

        long antallKvinner = ansatte.stream()
                .filter(a -> a.getKjonn() == Kjonn.KVINNE)
                .count();

        System.out.println("Antall kvinner: " + antallKvinner);


        // Oppgave 3c
        System.out.println("\nOppgave 3c");

        double gjennomsnittslonnKvinner = ansatte.stream()
                .filter(a -> a.getKjonn() == Kjonn.KVINNE)
                .mapToInt(a -> a.getAarslonn())
                .average()
                .orElse(0);

        System.out.printf(
                "Gjennomsnittslønn for kvinner: %.2f%n",
                gjennomsnittslonnKvinner
        );


        // Oppgave 3d
        System.out.println("\nOppgave 3d");

        // Vi bruker en ny liste slik at lønnsøkningen
        // ikke påvirker de andre deloppgavene.
        List<Ansatt> ansatteMedLonnsokning = lagAnsatte();

        ansatteMedLonnsokning.stream()
                .filter(a -> a.getStilling()
                        .toLowerCase()
                        .contains("sjef"))
                .forEach(a -> a.setAarslonn(
                        (int) (a.getAarslonn() * 1.07)
                ));

        System.out.println("Etter 7% lønnsøkning for sjefer:");
        ansatteMedLonnsokning.forEach(System.out::println);


        // Oppgave 3e
        System.out.println("\nOppgave 3e");

        boolean finnesOver800k = ansatte.stream()
                .anyMatch(a -> a.getAarslonn() > 800000);

        System.out.println(
                "Noen tjener mer enn 800000: " + finnesOver800k
        );


        // Oppgave 3f
        System.out.println("\nOppgave 3f");

        ansatte.forEach(System.out::println);


        // Oppgave 3g
        System.out.println("\nOppgave 3g");

        int lavesteLonn = ansatte.stream()
                .mapToInt(a -> a.getAarslonn())
                .min()
                .orElse(0);

        List<Ansatt> ansatteMedLavestLonn = ansatte.stream()
                .filter(a -> a.getAarslonn() == lavesteLonn)
                .toList();

        System.out.println("Laveste lønn: " + lavesteLonn);
        System.out.println("Ansatt(e) med lavest lønn:");
        ansatteMedLavestLonn.forEach(System.out::println);


        // Oppgave 3h
        System.out.println("\nOppgave 3h");

        int sum = IntStream.range(1, 1000)
                .filter(tall -> tall % 3 == 0 || tall % 5 == 0)
                .sum();

        System.out.println(
                "Summen av tall delelig med 3 eller 5: " + sum
        );
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
}