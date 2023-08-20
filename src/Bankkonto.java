public class Bankkonto {


    private int kontostand;
    public Bankkonto(){

    }
    public void geldEinzahlen(int Anzahl){
        kontostand += Anzahl;
    }
    public void geldAbheben(int Anzahl){
        kontostand -= Anzahl;
    }
    public int getKontostand() {
        return kontostand;
    }
}
