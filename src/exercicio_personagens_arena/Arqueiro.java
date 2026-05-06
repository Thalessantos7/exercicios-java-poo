package exercicio_personagens_arena;

public class Arqueiro extends Personagem implements HabilidadeEspecial {

    private int flechas;

    public Arqueiro(String nome, int nivel, int vida, int flechas) {

        super(nome, nivel, vida);

        if (flechas < 0) {

            throw new IllegalArgumentException("Flechas não podem ser menores que 0.");

        }

        this.flechas = flechas;

    }

    @Override
    public void atacar() throws RecursoInsuficienteException {

        if (this.flechas <= 0) {

            throw new RecursoInsuficienteException("O arqueiro está sem flechas!");

        }

        System.out.println("O arqueiro " + getNome() + " disparou uma flecha!");
        this.flechas--;

    }

    @Override
    public void usarHabilidadeEspecial() throws RecursoInsuficienteException {

        if (this.flechas < 3) {

            throw new RecursoInsuficienteException("O arqueiro não possui flechas suficientes para usar a habilidade especial!");

        }

        System.out.println("O arqueiro " + getNome() + " usou Chuva de Flechas!");
        this.flechas -= 3;

    }

}