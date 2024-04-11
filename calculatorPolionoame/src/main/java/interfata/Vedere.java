package interfata;

import javax.swing.*;
import java.awt.*;

public class Vedere extends JFrame
{
    private JPanel fereastraNumere;
    private JLabel primulPolinomLabel;
    private JLabel alDoileaPolinomLabel;
    private JLabel rezultatLabel;
    private JTextField primulPolinomTextField;
    private JTextField alDoileaPolinomTextField;
    private JTextField rezultatTextField;
    private JPanel fereastraButoane;
    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;
    private JButton derButton;
    private JButton inteButton;
    private JFrame frame;
    public Vedere(String name)
    {
        super(name);
        frame = new JFrame();

        fereastraNumere = new JPanel();
        fereastraNumere.setLayout(new GridLayout(3, 2, 5, 10));

        primulPolinomLabel = new JLabel("Primul polinom");
        Font fontLabel1=primulPolinomLabel.getFont().deriveFont(Font.BOLD, 30);
        primulPolinomLabel.setFont(fontLabel1);

        alDoileaPolinomLabel = new JLabel("Al doilea polinom");
        Font fontLabel2=alDoileaPolinomLabel.getFont().deriveFont(Font.BOLD, 30);
        alDoileaPolinomLabel.setFont(fontLabel2);

        rezultatLabel = new JLabel("Rezultat");
        Font fontLabel3=rezultatLabel.getFont().deriveFont(Font.BOLD, 30);
        rezultatLabel.setFont(fontLabel3);

        primulPolinomTextField = createTextField();
        Font fontMare1=primulPolinomTextField.getFont().deriveFont(Font.BOLD, 25);
        primulPolinomTextField.setFont(fontMare1);

        alDoileaPolinomTextField = createTextField();
        Font fontMare2=alDoileaPolinomTextField.getFont().deriveFont(Font.BOLD, 25);
        alDoileaPolinomTextField.setFont(fontMare2);

        rezultatTextField = createTextField();
        Font fontMare3=rezultatTextField.getFont().deriveFont(Font.BOLD, 25);
        rezultatTextField.setFont(fontMare3);
        rezultatTextField.setEditable(false);

        fereastraNumere.add(primulPolinomLabel);
        fereastraNumere.add(primulPolinomTextField);
        fereastraNumere.add(alDoileaPolinomLabel);
        fereastraNumere.add(alDoileaPolinomTextField);
        fereastraNumere.add(rezultatLabel);
        fereastraNumere.add(rezultatTextField);
        fereastraNumere.setBackground(new Color(255, 222, 255));

        add(fereastraNumere, BorderLayout.CENTER);

        fereastraButoane = new JPanel();
        fereastraButoane.setLayout(new GridLayout(6, 1, 0, 10));

        addButton=new JButton("adunare");
        addButton.setBackground(new Color(255, 105, 180));
        addButton.setForeground(Color.white);

        subButton=new JButton("scadere");
        subButton.setBackground(new Color(255, 105, 180));
        subButton.setForeground(Color.white);

        mulButton=new JButton("inmultire");
        mulButton.setBackground(new Color(255, 105, 180));
        mulButton.setForeground(Color.white);

        divButton=new JButton("impartire");
        divButton.setBackground(new Color(255, 105, 180));
        divButton.setForeground(Color.white);

        derButton=new JButton("derivare");
        derButton.setBackground(new Color(255, 105, 180));
        derButton.setForeground(Color.white);

        inteButton=new JButton("integrare");
        inteButton.setBackground(new Color(255, 105, 180));
        inteButton.setForeground(Color.white);

        fereastraButoane.add(addButton);
        fereastraButoane.add(subButton);
        fereastraButoane.add(mulButton);
        fereastraButoane.add(divButton);
        fereastraButoane.add(derButton);
        fereastraButoane.add(inteButton);
        fereastraButoane.setBackground(new Color(255, 222, 255));

        add(fereastraButoane, BorderLayout.EAST);
        frame.setLayout(new GridLayout(1, 2));
        frame.add(fereastraNumere);
        frame.add(fereastraButoane);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JTextField createTextField()
    {
        JTextField textField = new JTextField(13);
        textField.setBackground(new Color(243, 210, 223));
        return textField;
    }

    public JTextField getPrimulPolinomTextField()
    {
        return primulPolinomTextField;
    }

    public JTextField getAlDoileaPolinomTextField()
    {
        return alDoileaPolinomTextField;
    }

    public void setRezultatTextField(String s)
    {
        rezultatTextField.setText(s);
    }
    public JButton getAddButton()
    {
        return addButton;
    }

    public JButton getSubButton() {
        return subButton;
    }
    public JButton getDerButton(){return derButton;}
    public JButton getMulButton(){return mulButton;}
    public JButton getInteButton(){return inteButton;}
    public JButton getDivButton(){return divButton;}

}