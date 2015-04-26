

package com.mycompany.webkauppa;

import com.mycompany.webkauppa.ohjaus.OstoksenLisaysKoriin;
import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;


public class KomentoTehdas {
    public Komento ostoksenLisaysKoriin(Ostoskori sessionOstoskori, long tuoteId) {
        return new OstoksenLisaysKoriin(sessionOstoskori, tuoteId);
    }
}
