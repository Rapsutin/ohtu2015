

package ohtu;

import javax.swing.JTextField;


public abstract class Operaatio implements Komento{

    protected Sovelluslogiikka sovellus;
    protected JTextField tuloskentta;
    protected JTextField syotekentta;
    protected int edellinenTulos;

    public Operaatio(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }
    
    @Override
    public void suorita() {
        edellinenTulos = Integer.parseInt(tuloskentta.getText());
        tuloskentta.setText(""+sovellus.tulos());
        syotekentta.setText("");
    }

    @Override
    public void undo() {
        sovellus.setTulos(edellinenTulos);
        tuloskentta.setText(""+sovellus.tulos());
    }

}
