package exercicio_personagens_arena;

public class Arqueiro extends Personagem implements HabilidadeEspecial {
    private int flechas;

    public Arqueiro(String nome, int nivel, int vida, int flechas) {
        super(nome, nivel, vida);
        this.flechas = flechas;
    }

    @Override
    public void atacar() {
        try {
            if (this.flechas == 0) {
                throw new RecursoInsuficienteException("O arqueiro está sem flechas!");
            }

            System.out.println("O arqueiro " + getNome() + " disparou uma flecha!");
            this.flechas--;
        } catch (RecursoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void usarHabilidadeEspecial() {
        try {
            if (this.flechas < 3) {
                throw new RecursoInsuficienteException("O arqueiro não tem flechas suficientes!");
            }

            System.out.println("O arqueiro " + getNome() + " usou Chuva de Flechas!");
            this.flechas -= 3;
        } catch (RecursoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }
}