import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Oppg1b {
    public static int beregn(
            int a,
            int b,
            BinaryOperator<Integer> funksjon
    ) {
        return funksjon.apply(a, b);
    }


    public static int beregn(
            int a,
            int b,
            BiFunction<Integer, Integer, Integer> funksjon
    ) {
        return funksjon.apply(a, b);
    }


    public static void main(String[] args) {
        System.out.println("Oppgave 1b");
        System.out.println("\nLøsning med BinaryOperator");

        BinaryOperator<Integer> summerFunksjon =
                (a, b) -> a + b;

        int sum = beregn(12, 13, summerFunksjon);

        BinaryOperator<Integer> maxFunksjon =
                (a, b) -> Math.max(a, b);

        int max = beregn(-5, 3, maxFunksjon);

        BinaryOperator<Integer> avstandFunksjon =
                (a, b) -> Math.abs(a - b);

        int avstand = beregn(54, 45, avstandFunksjon);

        System.out.println("Sum av 12 og 13: " + sum);
        System.out.println("Største av -5 og 3: " + max);
        System.out.println("Avstand mellom 54 og 45: " + avstand);


        System.out.println("\nAlternativ løsning med BiFunction");

        BiFunction<Integer, Integer, Integer> summerFunksjon1 =
                (a, b) -> a + b;

        BiFunction<Integer, Integer, Integer> maksFunksjon1 =
                (a, b) -> Math.max(a, b);

        BiFunction<Integer, Integer, Integer> avstandFunksjon1 =
                (a, b) -> Math.abs(a - b);

        int sum1 = beregn(12, 13, summerFunksjon1);
        int maks1 = beregn(-5, 3, maksFunksjon1);
        int avstand1 = beregn(54, 45, avstandFunksjon1);

        System.out.println("Sum av 12 og 13: " + sum1);
        System.out.println("Største av -5 og 3: " + maks1);
        System.out.println("Avstand mellom 54 og 45: " + avstand1);
    }
}


