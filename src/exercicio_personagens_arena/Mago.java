package exercicio_personagens_arena;

public class Mago extends Personagem implements HabilidadeEspecial {

    private int mana;

    public Mago(String nome, int nivel, int vida, int mana) {

        super(nome, nivel, vida);

        if (mana < 0) {

            throw new IllegalArgumentException("Mana não pode ser menor que 0.");

        }

        this.mana = mana;

    }

    @Override
    public void atacar() {

        System.out.println("O mago " + getNome() + " lançou uma bola de fogo!");

    }

    @Override
    public void usarHabilidadeEspecial() throws RecursoInsuficienteException {

        if (this.mana < 10) {

            throw new RecursoInsuficienteException("Mana insuficiente para usar habilidade especial.");

        }

        System.out.println("O mago " + getNome() + " usou Tempestade Arcana!");
        this.mana -= 10;

    }

}