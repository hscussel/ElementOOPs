package criatura;

public class CriaturaTipoFogo extends Criatura {
    private static final String TIPO = "Fogo";
    private static final String NOME = "BurnCoder";

    public CriaturaTipoFogo() {
        super(NOME, TIPO);
    }


    @Override
    public void atacarElemental(Criatura criaturaInimiga) {
        String tipo = criaturaInimiga.getTipo();

        double fator = 0;

        switch(tipo) {
            case "Fogo" -> {
                fator = 0.5;
            }
            case "Terra" -> {
                fator = 1.0;
            }
            case "Ar" -> {
                fator = 2.0;
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
        return new Criatura[]{new CriaturaTipoAgua(), new CriaturaTipoAr(), new CriaturaTipoTerra()};
    }
}