package criatura;
import criatura.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jogo {

    public Jogo(){
        Scanner ler = new Scanner(System.in);

        int menu;
        int torneio;

        do {
            System.out.println("Seja Bem-Vindo ao ElementOPPs! Digite abaixo o que deseja: \n 1- Iniciar um novo jogo \n 2- Sair do programa");
            menu = ler.nextInt();
            if (menu == 1) {


                Criatura criaturaJogador = Criatura.selecionarCriatura();




                System.out.println("\n Indique: \n 1- Começar Torneio \n 2- Sair do Programa");
                torneio = ler.nextInt();

                if (torneio == 1) {

                    Criatura[] criaturasInimigas = criaturaJogador.obterInimigos();

                    Random random = new Random();

                    System.out.println("Torneio iniciado!" + "\n");

                    for (Criatura criaturaInimiga : criaturasInimigas) {
                        System.out.println("Inimigo encontrado!" + "\n");
                        criaturaInimiga.getAtributosJogador();



                        while(criaturaInimiga.getPvd() > 0 && criaturaJogador.getPvd() > 0) {

                            Criatura ultimoAtacante = obterPrimeiroAtacante(criaturaJogador, criaturaInimiga);

                            if(ultimoAtacante != criaturaJogador) {
                                criaturaJogador.selecionarAtaque(criaturaInimiga);
                                ultimoAtacante = criaturaJogador;

                            } else {
                                if(criaturaInimiga.getPvd() < 0) {
                                    break;
                                }
                                ataqueInimigo(criaturaJogador, criaturaInimiga);
                                ultimoAtacante = criaturaInimiga;
                            }
                        }

                        if (criaturaJogador.getPvd() <= 0) {
                            System.out.println("K.O.! Você perdeu.");
                            System.exit(1);
                        }

                        criaturaJogador.regenerarVida();
                        System.out.println("K.O.! Inimigo derrotado!");

                    }
                    System.out.println("Parabéns, você venceu!");
                }

                if (torneio == 2) {
                    System.out.println("Até mais Jogador!");
                    return;
                }
            }
            if (menu == 2) {
                System.out.println("Até mais jogador!");
                return;
            }
        } while (menu != 1 && menu != 2);

    }


    public static void ataqueInimigo(Criatura criaturaJogador, Criatura criaturaInimiga) {

        Random random = new Random();

        if (random.nextInt(2) + 1 == 1) {
            System.out.println("A criatura inimiga realiza um ataque físico." + "\n");
            criaturaInimiga.atacarFisico(criaturaJogador);
        } else {
            System.out.println("A criatura inimiga realiza um ataque elemental." + "\n");
            criaturaInimiga.atacarElemental(criaturaJogador);
        }


        System.out.println("Sua vida jogador: " + criaturaJogador.getPvd());
    }

    public static Criatura obterPrimeiroAtacante(Criatura criaturaJogador, Criatura criaturaInimiga) {
        if (criaturaJogador.getVel() > criaturaInimiga.getVel()) {
            System.out.println("Sua criatura ataca primeiro" + "\n");
            criaturaJogador.selecionarAtaque(criaturaInimiga);
            return criaturaJogador;

        } else if (criaturaJogador.getVel() == criaturaInimiga.getVel()) {
            System.out.println("Velocidades iguais, vamos sortear quem irá atacar primeiro.");

            Random random = new Random();

            if (random.nextInt(2) + 1 == 1) {
                System.out.println("A criatura inimiga realiza um ataque físico." + "\n");
                ataqueInimigo(criaturaJogador, criaturaInimiga);
                return criaturaInimiga;

            } else {
                System.out.println("A criatura inimiga realiza um ataque elemental." + "\n");
                criaturaJogador.selecionarAtaque(criaturaInimiga);
                return criaturaJogador;

            }

        } else {
            System.out.println("A criatura inimiga ataca primeiro." + "\n");
            ataqueInimigo(criaturaJogador, criaturaInimiga);
            return criaturaInimiga;
        }
    }
}
