package criatura;

public class CriaturaTipoAr extends Criatura {
    private static final String TIPO = "Ar";
    private static final String NOME = "BreezeHacker";

    public CriaturaTipoAr() {
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
                fator = 2.0;
            }
            case "Ar" -> {
                fator = 0.5;
            }
            case "Agua" -> {
                fator = 1.0;
            }
        }

        int dano = (int) ((int) (getPdr() * getAtq()) / criaturaInimiga.getDef() * fator);
        System.out.println("Dano do ataque elemental: " + dano);

        criaturaInimiga.setPvd(criaturaInimiga.getPvd() - dano);
    }


    @Override
    public Criatura[] obterInimigos() {
        return new Criatura[]{new CriaturaTipoFogo(), new CriaturaTipoAgua(), new CriaturaTipoTerra()};
    }
}