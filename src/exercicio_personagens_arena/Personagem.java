package exercicio_personagens_arena;

public abstract class Personagem {

    private String nome;
    private int nivel, vida;


    public Personagem(String nome, int nivel, int vida) {

        this.nome = nome;
        setNivel(nivel);
        setVida(vida);

    }

    public String getNome() {

        return nome;

    }

    public int getNivel() {

        return nivel;

    }

    public int getVida() {

        return vida;

    }

    public void setNivel(int nivel) {

        if (nivel < 1) {

            throw new IllegalArgumentException("Nível não pode ser menor que 1.");

        }

        this.nivel = nivel;

    }

    public void setVida(int vida) {

        if (vida < 0) {

            throw new IllegalArgumentException("Vida não pode ser menor 0.");

        }

        this.vida = vida;

    }

    public void exibirStatus() {

        System.out.println(
                "Nome: " + this.nome + "\n" +
                "Nível: " + this.nivel + "\n" +
                "Vida: " + this.vida + "\n"
        );

    }

    public abstract void atacar() throws RecursoInsuficienteException;

}