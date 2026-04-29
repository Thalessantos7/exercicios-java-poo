package exercicio_personagens_arena;

public abstract class Personagem {
    private String nome;
    private int nivel, vida;

    public String getNome() {
        return nome;
    }

    public Personagem(String nome, int nivel, int vida) {
        this.nome = nome;
        this.nivel = nivel;
        this.vida = vida;
    }

    public void exibirStatus() {
        System.out.println(
                "Nome: " + this.nome + "\n" +
                "Nível: " + this.nivel + "\n" +
                "Vida: " + this.vida + "\n"
        );
    }

    public abstract void atacar();
}