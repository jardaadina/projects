package interfata;

import interfata.Vedere;
import operatie.Operatii;
import polinom.Polinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controler implements ActionListener
{
    private Polinom p1;
    private Polinom p2;
    private Vedere view;
    private Operatii model;
    public Controler(Vedere view, Operatii model)
    {
        this.view = view;
        this.model = model;

        view.getAddButton().addActionListener(this);
        view.getSubButton().addActionListener(this);
        view.getDerButton().addActionListener(this);
        view.getMulButton().addActionListener(this);
        view.getInteButton().addActionListener(this);
        view.getDivButton().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getAddButton()) {
            handleAddButton();
        }
        if(e.getSource() == view.getSubButton()) {
            handleSubButton();
        }
        if(e.getSource() == view.getDerButton()) {
            handleDerButton();
        }
        if(e.getSource() == view.getMulButton()) {
            handleMulButton();
        }
        if(e.getSource() == view.getInteButton()) {
            handleInteButton();
        }
        if(e.getSource() == view.getDivButton()) {
            handleDivButton();
        }
    }

    private void handleAddButton() {
        String polinom1 = view.getPrimulPolinomTextField().getText();
        String polinom2 = view.getAlDoileaPolinomTextField().getText();

        p1 = new Polinom(polinom1);
        p2 = new Polinom(polinom2);

        String rezultat= model.add(p1, p2);
        view.setRezultatTextField(rezultat);
    }

    private void handleSubButton() {
        String polinom1 = view.getPrimulPolinomTextField().getText();
        String polinom2 = view.getAlDoileaPolinomTextField().getText();

        p1 = new Polinom(polinom1);
        p2 = new Polinom(polinom2);

        String rezultat = model.sub(p1, p2).toString();
        view.setRezultatTextField(rezultat);
    }

    private void handleDerButton() {
        String polinom1 = view.getPrimulPolinomTextField().getText();

        p1 = new Polinom(polinom1);

        String rezultat = model.derivare(p1);
        view.setRezultatTextField(rezultat);
    }

    private void handleMulButton() {
        String polinom1 = view.getPrimulPolinomTextField().getText();
        String polinom2 = view.getAlDoileaPolinomTextField().getText();

        p1 = new Polinom(polinom1);
        p2 = new Polinom(polinom2);

        String rezultat = model.mul(p1, p2).toString();
        view.setRezultatTextField(rezultat);
    }

    private void handleInteButton() {
        String polinom1 = view.getPrimulPolinomTextField().getText();

        p1 = new Polinom(polinom1);

        String rezultat = model.integrare(p1);
        view.setRezultatTextField(rezultat);
    }

    private void handleDivButton() {
        String polinom1 = view.getPrimulPolinomTextField().getText();
        String polinom2 = view.getAlDoileaPolinomTextField().getText();

        p1 = new Polinom(polinom1);
        p2 = new Polinom(polinom2);

        String rezultat = model.div(p1, p2);
        view.setRezultatTextField(rezultat);
    }

}
