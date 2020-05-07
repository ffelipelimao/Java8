package hello;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class HelloMain {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("Alura");
        list.add("K2");
        list.add("Casa do Codigo");
        list.add("Caelum");

//ordenação da lista, Comparator por referencia, valor negativo antes, positivo depois, e 0 empate
//Interface funcional = é possivel usar lamba

        list.sort((s1,s2) ->{
                if (s1.length() <s2.length())
                    return -1;
                if (s1.length() > s2.length())
                    return 1;
                return 0;
            }
        );
        // mesmo exemplo usando o integer compare usado para o tamanho da string
        list.sort(( s1,  s2) -> Integer.compare(s1.length(),s2.length()));

        //agora usando o comparator
        list.sort(Comparator.comparing(s -> s.length()));

        //list orderna pra mim comparando lenght de string com metodos references
        list.sort(Comparator.comparing(String::length));


// SEM O LAMBDA como iria ficar
//        Function<String,Integer> funcao = new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return s.length();
//            }
//        };
//        Comparator<String> comparador = Comparator.comparing(funcao);
//        list.sort(comparador);


//Usando a interface consumer para listar e imprimir
  //      for (String p : list){
    //        System.out.println(p);
      //  }
// for each com lamba sendo o Consumer "s" a string.
        list.forEach(s -> System.out.println(s));

       //sem usar o lambda e agora usando os metodos references, usar em casos especificos, sendo o mais curtos de todos
        Consumer<String> impressor = System.out::println;
        list.forEach(impressor);

        list.forEach(System.out::println);


        //o uso lambda e metodo reference usando com objetos, o que vai ser mais pratico para o dia a dia
        // Function<Usuario, String> funcao = u -> u.getNome();
        //Usuario::getNome
    }
}

//exemplo de classe anonima para ver como funciona por tras dos panos
class ComparadorTamanho implements Comparator<String>{

    @Override
    public int compare(String s1, String s2) {
        if (s1.length() <s2.length())
            return -1;
        if (s1.length() > s2.length())
            return 1;
        return 0;
    }
}
