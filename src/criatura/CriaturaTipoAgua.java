package criatura;

public class CriaturaTipoAgua extends criatura.Criatura {
    private static final String TIPO = "Agua";
    private static final String NOME = "WaveNerd";

    public CriaturaTipoAgua() {
        super(NOME, TIPO);
    }



    @Override
    public void atacarElemental(criatura.Criatura criaturaInimiga) {
        String tipo = criaturaInimiga.getTipo();

        double fator = 0;

        switch(tipo) {
            case "Fogo" -> {
                fator = 2.0;
            }
            case "Terra" -> {
                fator = 1.0;
            }
            case "Ar" -> {
                fator = 1.0;
            }
            case "Agua" -> {
                fator = 0.5;
            }
        }

        int dano = (int) ((int) (getPdr() * getAtq()) / criaturaInimiga.getDef() * fator);
        System.out.println("Dano do ataque elemental: " + dano);

        criaturaInimiga.setPvd(criaturaInimiga.getPvd() - dano);
    }

    @Override
    public criatura.Criatura[] obterInimigos() {
        return new criatura.Criatura[]{new CriaturaTipoFogo(), new CriaturaTipoAr(), new CriaturaTipoTerra()};
    }
}