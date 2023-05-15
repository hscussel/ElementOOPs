package criatura;

import java.util.Random;
import java.util.Scanner;

public abstract class Criatura{

    protected int pdr;
    protected int atq;
    protected int def;
    protected int vel;
    protected int pvdInicial;
    protected int pvd;
    protected String nome;
    protected String tipo;


    public Criatura(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    //Criação da Criatura
    public static Criatura selecionarCriatura() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione a criatura que deseja, ou então, saia do jogo: \n "
                + "1- StoneDev (terra) \n 2- WaveNerd (água) \n 3- BurnCoder (fogo) \n 4- BreezeHacker (ar) \n 5- Sair \n");
        System.out.print("Selecione: ");
        int tipoCriatura = scanner.nextInt();

        Criatura criaturaJogador;

        switch (tipoCriatura) {
            case 1 -> {
                criaturaJogador = new CriaturaTipoTerra();
                criaturaJogador.getAtributosJogador();
                return criaturaJogador;
            }
            case 2 -> {
                criaturaJogador = new CriaturaTipoAgua();
                criaturaJogador.getAtributosJogador();
                return criaturaJogador;
            }
            case 3 -> {
                criaturaJogador = new CriaturaTipoFogo();
                criaturaJogador.getAtributosJogador();
                return criaturaJogador;
            }
            case 4 -> {
                criaturaJogador = new CriaturaTipoAr();
                criaturaJogador.getAtributosJogador();
                return criaturaJogador;
            }
            case 5 -> {
                System.out.println("Fechando o jogo!");
                System.exit(0);
            }
            default -> {
                System.out.println("Escolha inválida.");
            }
        }
        return null;
    }

    // Batalha
    public void selecionarAtaque(Criatura criaturaInimiga) {
        Scanner ler = new Scanner(System.in);

        System.out.println("1- Dano \n 2-Dano Elemental");

        System.out.print("Escolha seu ataque: ");

        int ataque = ler.nextInt();

        if(ataque == 1) {
            atacarFisico(criaturaInimiga);
            System.out.println("Vida do inimigo agora: " + criaturaInimiga.getPvd());
        } else {
            atacarElemental(criaturaInimiga);
            System.out.println("Vida do inimigo agora: " + criaturaInimiga.getPvd());
        }
    }
    public void atacarFisico(Criatura criaturaInimiga) {
        int dano = getPdr() * getAtq() / criaturaInimiga.getDef();
        System.out.println("Dano do ataque fisico: " + dano);
        criaturaInimiga.setPvd(criaturaInimiga.getPvd() - dano);
    }

    public abstract void atacarElemental(Criatura criaturaInimiga);

    public abstract Criatura[] obterInimigos();

    public void regenerarVida() {
        pvd = pvdInicial;
        System.out.println("Você regenerou a vida! Ela voltou a ser: " + pvd);
    }

    //Criação de Atributos
    public void getAtributosJogador() {
        criarRandom();

        System.out.println("NOME: " + getNome());

        System.out.println("PDR: " + this.pdr);
        System.out.println("ATQ: " + this.atq);
        System.out.println("DEF: " + this.def);
        System.out.println("VEL: " + this.vel);
        System.out.println("PVD: " + this.pvd);
        System.out.println();
    }
    private void criarRandom() {
        Random random = new Random();
        this.pdr = random.nextInt(21) + 10;
        this.atq = random.nextInt(16) + 5;
        this.def = random.nextInt(16) + 5;
        this.vel = random.nextInt(11) + 1;
        this.pvdInicial = random.nextInt(201) + 200;
        this.pvd = pvdInicial;
    }

    public void CriaturaAtributosAdv() {
        criarRandom();
    }

    public String getTipo() {
        return tipo;
    }
    public int getPdr() {
        return pdr;
    }

    public void setPdr(int pdr) {
        this.pdr = pdr;
    }

    public int getAtq() {
        return atq;
    }

    public void setAtq(int atq) {
        this.atq = atq;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getVel() {
        return vel;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }

    public int getPvd() {
        return pvd;
    }

    public void setPvd(int pvd) {
        this.pvd = pvd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}













