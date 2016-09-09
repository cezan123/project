import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GUI3 extends JFrame{

    public GUI3(){
        try {
            drawGUI();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String[] categoryStrings = {"literatuur", "filosifie","fotografie","engels","kunst","maritiem","gedichten", "architectur", "natuur", "frans","duits","overige"};
    ArrayList<Opslag> eerstOpslag = new ArrayList<>();
    private int boekenInBerekening = 0;

    public static void main(String[] args)
    {

        new GUI3();
    }



    public void drawGUI() throws FileNotFoundException, ClassNotFoundException, IOException{
        JFrame frame = new JFrame("Artiest");

        JLabel boeknummerLbl = new JLabel("     BoekNummer:");
        JLabel categrorieLbl = new JLabel("     Catergorie:");
        JLabel prijsLbl = new JLabel("     prijs:");
        JLabel boekInfoLbl = new JLabel("  Informatie Boek");
        boekInfoLbl.setFont(new Font(boekInfoLbl.getName(), Font.BOLD, 18));
        JLabel totaalBerekeningLbl = new JLabel("  Boeken in berekening: " + 0);
        JLabel totaalHeaderLbl = new JLabel("  BERKEN TOTAAL");
        totaalHeaderLbl.setFont(new Font(boekInfoLbl.getName(), Font.BOLD, 18));
        JLabel totaalLbl = new JLabel("     Totaal prijs:");
        JLabel dummie = new JLabel("");
        JLabel dummie1 = new JLabel("");
        JLabel dummie2 = new JLabel("");
        JLabel dummie3 = new JLabel("");
        JLabel dummie4 = new JLabel("");
        JLabel dummie5 = new JLabel("");
        JLabel dummie6 = new JLabel("");
        JLabel dummie7 = new JLabel("");


        JTextField boekNummerField = new JTextField();
        JComboBox categorieBox = new JComboBox(categoryStrings);
        JTextField prijsField = new JTextField();

        JTextField totaalField = new JTextField();

        JButton nextBookBtn = new JButton("volgendeBoek");
        JButton totaalBtn = new JButton("totaal");

        JPanel add = new JPanel(new GridLayout(8,2));
        JPanel delete = new JPanel(new GridLayout(3,2));

        add.add(boekInfoLbl);
        add.add(dummie1);
        add.add(boeknummerLbl);
        add.add(boekNummerField);
        add.add(categrorieLbl);
        add.add(categorieBox);
        add.add(prijsLbl);
        add.add(prijsField);
        add.add(dummie);
        add.add(nextBookBtn);
        add.add(dummie4);
        add.add(dummie5);
        add.add(totaalBerekeningLbl);
        add.add(dummie6);
        add.add(dummie7);

        delete.add(totaalHeaderLbl);
        delete.add(dummie2);
        delete.add(totaalLbl);
        delete.add(totaalField);
        delete.add(dummie3);
        delete.add(totaalBtn);

        frame.add(add, BorderLayout.NORTH);
        frame.add(delete, BorderLayout.CENTER);

        nextBookBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               int bookNumber = Integer.parseInt(boekNummerField.getText());
               String bookCategory = categorieBox.getSelectedItem().toString();

                if(prijsField.getText().contains(","))
                    JOptionPane.showMessageDialog(frame, "Alleen punten gebruiken geen komma's ");
                else {
                    double bookPrice = Double.parseDouble(prijsField.getText());
                    eerstOpslag.add(new Opslag(bookNumber, bookCategory, bookPrice));
                    boekNummerField.setText("");
                    categorieBox.setSelectedIndex(0);
                    prijsField.setText("");
                }







              System.out.println(eerstOpslag.get(0).getBookNmr());
              System.out.println(eerstOpslag.get(0).getDate());
              System.out.println(eerstOpslag.get(0).getCategory());
              System.out.println(eerstOpslag.get(0).getPrice());

            totaalBerekeningLbl.setText("  Boeken in berekening: " + eerstOpslag.size());

            }
        });

        totaalBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                double totalPrice = 0;
                for(int i = 0; eerstOpslag.size()> i; i++)
                {
                    totalPrice = totalPrice + eerstOpslag.get(i).getPrice();
                }

                totaalField.setText(""+totalPrice);
            }
        });

        frame.setSize(500,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}