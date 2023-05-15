package criatura;

public class CriaturaTipoTerra extends Criatura {
    private static final String TIPO = "Terra";
    private static final String NOME = "StoneDev";

    public CriaturaTipoTerra() {
        super(NOME, TIPO);
    }

    @Override
    public void atacarElemental(Criatura criaturaInimiga) {
        String tipo = criaturaInimiga.getTipo();

        double fator = 0;

        switch(tipo) {
            case "Fogo" -> {
                fator = 1.0;
            }
            case "Terra" -> {
                fator = 0.5;
            }
            case "Ar" -> {
                fator = 1.0;
            }
            case "Agua" -> {
                fator = 2.0;
            }
        }

        int dano = (int) ((int) (getPdr() * getAtq()) / criaturaInimiga.getDef() * fator);
        System.out.println("Dano do ataque elemental: " + dano);

        criaturaInimiga.setPvd(criaturaInimiga.getPvd() - dano);
    }

    @Override
    public Criatura[] obterInimigos() {
        return new Criatura[]{new CriaturaTipoFogo(), new CriaturaTipoAr(), new CriaturaTipoAgua()};
    }
}