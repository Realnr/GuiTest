package Control;

import Model.Bankkonto;

public class BankController {
    Bankkonto bankkonto;
    public BankController(Bankkonto bankkonto){
        this.bankkonto = bankkonto;
    }
    public void increaseBankkonto(int Anzahl) {
        bankkonto.setKontostand(bankkonto.getKontostand() + Anzahl);
    }
    public void decreaseBankkonto(int Anzahl) {
        bankkonto.setKontostand(bankkonto.getKontostand() - Anzahl);
    }
}
