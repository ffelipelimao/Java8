package hello;

import java.util.*;
import java.util.stream.Collectors;

public class Cursos {

    private String nome;
    private int alunos;

    public Cursos(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAlunos() {
        return alunos;
    }

    public void setAlunos(int alunos) {
        this.alunos = alunos;
    }

}

class ExemploCursos{
    public static void main(String[] args) {
        List<Cursos> cursos = new ArrayList<Cursos>();
        cursos.add(new Cursos("Python",45));
        cursos.add(new Cursos("JS",35));
        cursos.add(new Cursos("Java",65));
        cursos.add(new Cursos("C#",20));

        cursos.sort(Comparator.comparing(c -> c.getAlunos()));

        //calculando media de alunos usando api de strem
         OptionalDouble  media  = cursos.stream()
                .filter(c -> c.getAlunos() >= 30)
                .mapToInt(Cursos::getAlunos)
                 .average();

        System.out.println(media);

        //esse cara retorna um Optional que tem varios condições para substistuir por exemplo if null
            cursos.stream()
                .filter(c -> c.getAlunos() >= 40)
                .findAny()
                .ifPresent(c -> System.out.println(c.getNome()));

        // após aplicar o stream e o filer para retornar uma nova list usamos o  .collect(Collectors.toList()
        //mas tambem podemos utilizat o toMap()...
        cursos.stream()
                .filter(c -> c.getAlunos() >= 40)
                .collect(Collectors.toMap(
                        c -> c.getNome(),
                        c -> c.getAlunos()))
                .forEach((nome,alunos)-> System.out.println(nome + " tem " + alunos + " alunos "));


    }
}
