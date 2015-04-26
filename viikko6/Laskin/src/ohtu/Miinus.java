

package ohtu;

import javax.swing.JTextField;


public class Miinus extends Operaatio{

    public Miinus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }

    @Override
    public void suorita() {
        sovellus.plus(Integer.parseInt(syotekentta.getText()));
        super.suorita();
    }
    
    
}
