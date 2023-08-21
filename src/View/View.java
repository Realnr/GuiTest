package View;

import Control.BankController;
import Model.Bankkonto;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JLabel Guthaben;
    private JPanel BankPanel;
    private JButton geldEinzahlenButton;
    private JTextField textField1;
    private JButton geldAbhebenButton;


    public View(Bankkonto bankkonto, BankController bankController){

        setContentPane(BankPanel);
        setVisible(true);
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createAbhebenButton(bankkonto, bankController);
        createEinzahlenButton(bankkonto, bankController);
    }

    private void createEinzahlenButton(Bankkonto bankkonto, BankController bankController){
        geldEinzahlenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bankController.increaseBankkonto(Integer.parseInt(textField1.getText()));
                Guthaben.setText(String.valueOf(bankkonto.getKontostand()));
            }
        });
    }

    private void createAbhebenButton(Bankkonto bankkonto, BankController bankController){
        geldAbhebenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bankController.decreaseBankkonto(Integer.parseInt(textField1.getText()));
                Guthaben.setText(String.valueOf(bankkonto.getKontostand()));
            }
        });
    }


}
