package exercicio_personagens_arena;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Personagem> personagens = new ArrayList<>();
        int opcao = 0;
        boolean executando = true;

        while (executando) {
            System.out.print("""
                    ===== ARENA DE TREINAMENTO =====
                    1 - Cadastrar exercicio.personagens.arena.Guerreiro
                    2 - Cadastrar exercicio.personagens.arena.Mago
                    3 - Cadastrar exercicio.personagens.arena.Arqueiro
                    4 - Listar personagens
                    5 - Atacar com todos os personagens
                    6 - Usar habilidades especiais
                    7 - Sair
                    """);

            while (true) {
                try {
                    System.out.print("Escolha uma opção: ");
                    opcao = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite apenas números.");
                    sc.nextLine();
                }
            }

            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nomeGuerreiro = sc.nextLine();

                    System.out.print("Nível: ");
                    int nivelGuerreiro = sc.nextInt();

                    System.out.print("Vida: ");
                    int vidaGuerreiro = sc.nextInt();

                    System.out.print("Força: ");
                    int forca = sc.nextInt();

                    Guerreiro guerreiro = new Guerreiro(nomeGuerreiro, nivelGuerreiro, vidaGuerreiro, forca);
                    personagens.add(guerreiro);

                    break;
                case 2:
                    System.out.print("Nome: ");
                    String nomeMago = sc.next();

                    System.out.print("Nível: ");
                    int nivelMago = sc.nextInt();

                    System.out.print("Vida: ");
                    int vidaMago = sc.nextInt();

                    System.out.print("Mana: ");
                    int mana = sc.nextInt();

                    Mago mago = new Mago(nomeMago, nivelMago, vidaMago, mana);
                    personagens.add(mago);

                    break;
                case 3:
                    System.out.print("Nome: ");
                    String nomeArqueiro = sc.next();

                    System.out.print("Nível: ");
                    int nivelArqueiro = sc.nextInt();

                    System.out.print("Vida: ");
                    int vidaArqueiro = sc.nextInt();

                    System.out.print("Quantidade de flechas: ");
                    int flechas = sc.nextInt();

                    Arqueiro arqueiro = new Arqueiro(nomeArqueiro, nivelArqueiro, vidaArqueiro, flechas);
                    personagens.add(arqueiro);

                    break;
                case 4:
                    for (Personagem personagem : personagens) {
                        if (personagem instanceof Guerreiro) {
                            System.out.println("Tipo: exercicio.personagens.arena.Guerreiro");
                        } else if (personagem instanceof Mago) {
                            System.out.println("Tipo: exercicio.personagens.arena.Mago");
                        } else {
                            System.out.println("Tipo: exercicio.personagens.arena.Arqueiro");
                        }

                        personagem.exibirStatus();
                    }

                    break;
                case 5:
                    for (Personagem personagem : personagens) {
                        personagem.atacar();
                    }

                    break;
                case 6:
                    for (Personagem personagem : personagens) {
                        if (personagem instanceof HabilidadeEspecial) {
                            HabilidadeEspecial especial = (HabilidadeEspecial) personagem;
                            especial.usarHabilidadeEspecial();
                        }
                    }

                    break;
                case 7:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}