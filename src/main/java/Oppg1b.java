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
        BinaryOperator<Integer> summerFunksjon =
                (a, b) -> a + b;

        int sum = beregn(12, 13, summerFunksjon);
        System.out.println("Sum: " + sum);

        BinaryOperator<Integer> maxFunksjon =
                (a, b) -> Math.max(a, b);

        int max = beregn(-5, 3, maxFunksjon);
        System.out.println("Max: " + max);

        BinaryOperator<Integer> avstandFunksjon =
                (a,b)->Math.abs(a - b);

        int avstand = beregn(54, 45, avstandFunksjon);
        System.out.println("Avstand: " + avstand);







        BiFunction<Integer, Integer, Integer> summerFunksjon1=
                (a, b) -> a + b;

        int sum1 = beregn(12, 13, summerFunksjon);

        BiFunction<Integer, Integer, Integer> maksFunksjon1 =
                (a, b) -> Math.max(a, b);

        System.out.println("Sum: " + sum1);



        int maks1 = beregn(-5, 3, maksFunksjon1);

        System.out.println("Maks: " + maks1);
        System.out.println("Max: " + maks1);




        BiFunction<Integer, Integer, Integer> avstandFunksjon1 =
                (a, b) -> Math.abs(a - b);

        int avstand1 = beregn(54, 45, avstandFunksjon);

        System.out.println("Avstand: " + avstand1);
    }
    }


