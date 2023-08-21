import Control.BankController;
import Model.Bankkonto;
import View.View;

public class Main {
    public static void main(String[] args) {
        Bankkonto bankkonto1 = new Bankkonto();
        BankController bankController = new BankController(bankkonto1);
        new View(bankkonto1,bankController);
    }
}
