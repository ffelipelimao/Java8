package hello;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Data {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate olimpidias = LocalDate.of(2020, Month.JUNE,5);

        int anos = olimpidias.getYear() - hoje.getYear();

        System.out.println(anos);

        Period periodo = Period.between(hoje,olimpidias);

        LocalDate next = olimpidias.plusYears(4);

        System.out.println(next);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formatado = next.format(formatador);

        System.out.println(formatado);


    }
}
