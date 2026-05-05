package exercicio_personagens_arena;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Personagem> personagens = new ArrayList<>();

        int opcao = 0;

        do {

            try {

                System.out.println("""
                        ===== ARENA DE TREINAMENTO =====
                        1 - Cadastrar Guerreiro
                        2 - Cadastrar Mago
                        3 - Cadastrar Arqueiro
                        4 - Listar personagens
                        5 - Atacar com todos os personagens
                        6 - Usar habilidades especiais
                        7 - Escolha um personagem pelo nome
                        8 - Sair
                        """);

                System.out.print("Escolha: ");
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {

                    case 1:

                        System.out.print("Nome: ");
                        String nomeG = sc.nextLine();

                        System.out.print("Nível: ");
                        int nivelG = sc.nextInt();

                        System.out.print("Vida: ");
                        int vidaG = sc.nextInt();

                        System.out.print("Força: ");
                        int forca = sc.nextInt();

                        personagens.add(new Guerreiro(nomeG, nivelG, vidaG, forca));

                        break;

                    case 2:

                        System.out.print("Nome: ");
                        String nomeM = sc.nextLine();

                        System.out.print("Nível: ");
                        int nivelM = sc.nextInt();

                        System.out.print("Vida: ");
                        int vidaM = sc.nextInt();

                        System.out.print("Mana: ");
                        int mana = sc.nextInt();

                        personagens.add(new Mago(nomeM, nivelM, vidaM, mana));

                        break;

                    case 3:

                        System.out.print("Nome: ");
                        String nomeA = sc.nextLine();

                        System.out.print("Nível: ");
                        int nivelA = sc.nextInt();

                        System.out.print("Vida: ");
                        int vidaA = sc.nextInt();

                        System.out.print("Flechas: ");
                        int flechas = sc.nextInt();

                        personagens.add(new Arqueiro(nomeA, nivelA, vidaA, flechas));

                        break;

                    case 4:

                        for (Personagem p : personagens) {

                            if (p instanceof Guerreiro) {

                                System.out.println("Tipo: Guerreiro");
                                p.exibirStatus();

                            } else if (p instanceof Mago) {

                                System.out.println("Tipo: Mago");
                                p.exibirStatus();

                            } else {

                                System.out.println("Tipo: Arqueiro");
                                p.exibirStatus();

                            }

                        }

                        break;

                    case 5:

                        for (Personagem p : personagens) {

                            try {

                                p.atacar();

                            } catch (RecursoInsuficienteException e) {

                                System.out.println(e.getMessage());

                            }

                        }

                        break;

                    case 6:

                        for (Personagem p : personagens) {

                            try {

                                if (p instanceof HabilidadeEspecial) {

                                    HabilidadeEspecial especial = (HabilidadeEspecial) p;
                                    especial.usarHabilidadeEspecial();

                                }

                            } catch (RecursoInsuficienteException e) {

                                System.out.println(e.getMessage());

                            }

                        }

                        break;

                    case 7:

                        System.out.print("Digite o nome do personagem: ");
                        String nomeDoPersonagem = sc.nextLine();

                        Personagem encontrado = null;

                        for (Personagem p : personagens) {

                            if (p.getNome().equalsIgnoreCase(nomeDoPersonagem)) {

                                encontrado = p;
                                break;

                            }

                        }

                        if (encontrado == null) {

                            System.out.println("Personagem não encontrado.");

                        } else {

                            System.out.println("""
                                    Escolha a ação:
                                    1 - Atacar
                                    2 - Usar habilidade especial
                                    """);

                            System.out.print("Sua ação: ");
                            int acao = sc.nextInt();
                            sc.nextLine();

                            try {
                                if (acao == 1) {

                                    encontrado.atacar();

                                } else if (acao == 2) {

                                    if (encontrado instanceof HabilidadeEspecial) {

                                        HabilidadeEspecial h = (HabilidadeEspecial) encontrado;
                                        h.usarHabilidadeEspecial();

                                    } else {

                                        System.out.println("Opção inválida.");

                                    }

                                }

                            } catch (RecursoInsuficienteException e) {

                                System.out.println(e.getMessage());

                            }

                        }

                        break;

                    case 8:

                        System.out.println("Programa encerrado!");

                        break;

                    default:

                        System.out.println("Opção inválida!");

                        break;

                }

            } catch (InputMismatchException e) {

                System.out.println("Entrada inválida. Digite apenas números.");

            } catch (IllegalArgumentException e) {

                System.out.println("Erro: " + e.getMessage());

            }

        } while (opcao != 8);

        sc.close();

    }

}