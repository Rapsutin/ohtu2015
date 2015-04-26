

package ohtu;

import javax.swing.JTextField;


public class Plus extends Operaatio{

    public Plus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }

    @Override
    public void suorita() {
        sovellus.plus(Integer.parseInt(syotekentta.getText()));
        super.suorita();
    }
    
    
}
