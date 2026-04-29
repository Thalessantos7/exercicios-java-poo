package exercicio_personagens_arena;

public class Guerreiro extends Personagem implements HabilidadeEspecial {
    private int forca;

    public Guerreiro(String nome, int nivel, int vida, int forca) {
        super(nome, nivel, vida);
        this.forca = forca;
    }

    @Override
    public void atacar() {
        System.out.println("O guerreiro " + getNome() + " atacou com sua espada!");
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println("O guerreiro " + getNome() + " usou Golpe Brutal!");
    }
}