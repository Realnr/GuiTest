package View;

import Control.BankController;
import Model.Bankkonto;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class View extends JFrame {
    private JLabel Guthaben;
    private JPanel BankPanel;
    private JButton geldEinzahlenButton;
    private JTextField textField1;
    private JButton geldAbhebenButton;
    //private char[] textFieldchar;


    public View(Bankkonto bankkonto, BankController bankController){
        setTitle("die Bank");
        setContentPane(BankPanel);
        setVisible(true);
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createAbhebenButton(bankkonto, bankController);
        createEinzahlenButton(bankkonto, bankController);

        System.out.println(filterCharacters(textField1));
        //textFieldchar = textField1.toString().toCharArray();

    }
    private String filterCharacters(JTextField jTextField){
        char[] textFieldchar = jTextField.getText().toCharArray(); // machen aus dem Text ein array von chars damit wir die einzelnen characters benutzen können (funktioniert nicht)
        char[] passableChars = {0,1,2,3,4,5,6,7,8,9};
//        int countOfUnpassableChars = 0;
        List<Character> charlist = new ArrayList<>();
        //gucken ob in textFieldchar die richtigen values sind und setzen die dann auf null
        for(int i = 0; i < textFieldchar.length; i++){
            for (int j = 0; j < passableChars.length; j++) {
                if(textFieldchar[i] == passableChars[j]){
//                    textFieldchar[i] = '\u0000';
//                    countOfUnpassableChars += 1;
                    charlist.add(textFieldchar[i]);
                }
            }
        }
        System.out.println();
        return charlist.toArray().toString();
//        //neues array wird erstell wo wir die passable values rein tuen
//        char[] newArray = new char[countOfUnpassableChars];
//        for(int i = 0; i < textFieldchar.length; i++){
//            if(textFieldchar[i] != '\u0000'){ //gucken nochmal welche stelle passable ist
//                for (int j = 0; j < newArray.length; j++) {
//                    if(newArray[j] == '\u0000'){ // suchen stelle die frei ist
//                        newArray[j] = textFieldchar[i]; //geben wert der passable ist
//                    }
//                }
//            }
//        }
//        return newArray.toString();
    }

    private void createEinzahlenButton(Bankkonto bankkonto, BankController bankController){
        geldEinzahlenButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(filterCharacters(textField1));
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
