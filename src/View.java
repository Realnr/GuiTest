import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JLabel Guthaben;
    private JPanel BankPanel;
    private JButton button1;
    private JTextField textField1;
    private JButton button2;

    public View(Bankkonto bankkonto){
        setContentPane(BankPanel);
        setVisible(true);
        setSize(300,200);
        Guthaben.setText(String.valueOf(bankkonto.getKontostand()));



    }


}
