/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ohtu.verkkokauppa.Kauppa;
import ohtu.verkkokauppa.Ostoskori;
import ohtu.verkkokauppa.Pankki;
import ohtu.verkkokauppa.Tuote;
import ohtu.verkkokauppa.Varasto;
import ohtu.verkkokauppa.Viitegeneraattori;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author rapsutin
 */
public class Testit {

    private Pankki pankki;
    private Ostoskori ostoskori;
    private Viitegeneraattori viite;
    private Varasto varasto;
    private Kauppa kauppa;

    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        ostoskori = mock(Ostoskori.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
        kauppa = new Kauppa(varasto, pankki, viite);
    }

    @Test
    public void tilisiirtoaKutsutaanOikeinOstettaessaYksi() {

        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);

        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 1
        when(varasto.saldo(1)).thenReturn(10);
        
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        // tehdään ostokset
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        kauppa.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455") , eq(5));
        
    }
    @Test
    public void aloitaAsiointiNollaaHinnan() {

        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);

        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 1
        when(varasto.saldo(1)).thenReturn(10);
        
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        // tehdään ostokset
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        kauppa.tilimaksu("pekka", "12345");
        
        kauppa.aloitaAsiointi();
        
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455") , eq(10));
        
    }
    @Test
    public void tilisiirtoaKutsutaanOikeinOstettaessaKaksiEri() {

        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);

        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(10);
        
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(1, "Keisari 66", 3));
        // tehdään ostokset
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        kauppa.lisaaKoriin(2);     // ostetaan tuotetta numero 2 eli Keisari 66
        kauppa.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455") , eq(8));
        
    }
    @Test
    public void tilisiirtoaKutsutaanOikeinOstettaessaKaksiSamaa() {

        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);

        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(10);
        
        when(varasto.haeTuote(2)).thenReturn(new Tuote(1, "Keisari 66", 3));
        // tehdään ostokset
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);     // ostetaan tuotetta numero 2 eli Keisari 66
        kauppa.lisaaKoriin(2);     // ostetaan tuotetta numero 2 eli Keisari 66
        kauppa.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455") , eq(6));
        
    }
    @Test
    public void tilisiirtoaKutsutaanOikeinOstettaessaKaksiJoistaToinenLoppu() {

        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);

        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(0);
        
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(1, "Keisari 66", 3));
        // tehdään ostokset
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);     // ostetaan tuotetta numero 2 eli Keisari 66
        kauppa.lisaaKoriin(2);     // ostetaan tuotetta numero 2 eli Keisari 66
        kauppa.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455") , eq(5));
        
    }
    @Test
    public void ostettaessapyydetaanAinaUusiViite() {

        

        when(varasto.saldo(1)).thenReturn(10);
        
        
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        
        // tehdään ostokset
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);     // ostetaan tuotetta numero 2 eli Keisari 66
        kauppa.tilimaksu("pekka", "12345");
        kauppa.lisaaKoriin(1);     // ostetaan tuotetta numero 2 eli Keisari 66
        kauppa.tilimaksu("pekka", "12345");
        kauppa.lisaaKoriin(1);     // ostetaan tuotetta numero 2 eli Keisari 66
        kauppa.tilimaksu("pekka", "12345");

        verify(viite, times(3)).uusi();
        
    }
    
    
    

}
