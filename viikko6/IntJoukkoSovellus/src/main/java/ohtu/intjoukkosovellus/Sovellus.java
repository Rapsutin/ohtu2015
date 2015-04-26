package ohtu.intjoukkosovellus;

import java.util.HashMap;
import java.util.Scanner;

public class Sovellus {

    private IntJoukko A, B, C;
    private HashMap<String, IntJoukko> joukot;
    private Scanner lukija;

    public Sovellus(Scanner lukija) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        
        joukot.put("A", A);
        joukot.put("B", B);
        joukot.put("C", C);
        
        this.lukija = lukija;
    }

    
    
    private IntJoukko mikaJoukko() {
        return joukot.get(lukija.next());
    }

    private void lisaa() {
        int lisLuku;
        
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = mikaJoukko();
        System.out.println("");
        System.out.print("Mikä luku lisätään? ");
        lisLuku = lukija.nextInt();
        joukko.lisaa(lisLuku);
    }

    private void yhdiste() {
        IntJoukko aJoukko, bJoukko, c;
        
        System.out.print("1. joukko? ");
        aJoukko = mikaJoukko();
        System.out.print("2. joukko? ");
        bJoukko = mikaJoukko();
        
        c = JoukkoOperaatiot.yhdiste(aJoukko, bJoukko);
        System.out.println("A yhdiste B = " + c.toString());
    }

    private void leikkaus() {
        IntJoukko aJoukko, bJoukko, c;
        
        System.out.print("1. joukko? ");
        aJoukko = mikaJoukko();
        
        System.out.print("2. joukko? ");
        bJoukko = mikaJoukko();
        
        c = JoukkoOperaatiot.leikkaus(aJoukko, bJoukko);
        System.out.println("A leikkaus B = " + c.toString());
    }

    private void erotus() {
        IntJoukko aJoukko, bJoukko, c;
        System.out.print("1. joukko? ");
        aJoukko = mikaJoukko();
        
        System.out.print("2. joukko? ");
        bJoukko = mikaJoukko();
        
        c = JoukkoOperaatiot.erotus(aJoukko, bJoukko);
        
        System.out.println("A erotus B = " + c.toString());
    }

    private void poista() {
        IntJoukko joukko;
        int lisLuku;
        
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mistä joukosta? ");
        joukko = mikaJoukko();
        System.out.print("Mikä luku poistetaan? ");
        lisLuku = lukija.nextInt();
        joukko.poista(lisLuku);
    }

    private void kuuluu() {
        IntJoukko joukko;
        int kysLuku;
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mihin joukkoon? ");
        joukko = mikaJoukko();
        System.out.print("Mikä luku? ");
        kysLuku = lukija.nextInt();
        boolean kuuluuko = joukko.kuuluu(kysLuku);
        if (kuuluuko) {
            System.out.println(kysLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(kysLuku + " ei kuulu joukkoon ");
        }
    }
    
    

    public static void main(String[] args) {

        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");

        Scanner lukija = new Scanner(System.in);
        Sovellus sovellus = new Sovellus(lukija);
//        while (true) {
//            luettu = lukija.nextLine();
//            if (luettu.equals("lisää") || luettu.equals("li")) {
//                sovellus.lisaa();
//            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
//                sovellus.poista();
//            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
//                sovellus.kuuluu();
//            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
//                sovellus.yhdiste();
//            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
//                sovellus.leikkaus();
//            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
//                sovellus.erotus();
//            } else if (luettu.equalsIgnoreCase("A")) {
//                //System.out.println(A);
//            } else if (luettu.equalsIgnoreCase("B")) {
//                //System.out.println(B);
//            } else if (luettu.equalsIgnoreCase("C")) {
//                //System.out.println(C);
//            } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
//                System.out.println("Lopetetaan, moikka!");
//                break;
//            } else {
//                System.out.println("Virheellinen komento! " + luettu);
//                System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
//            }
//            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
//        }
//    }
}
