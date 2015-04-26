

package ohtu.intjoukkosovellus;

import java.util.Set;


public class JoukkoOperaatiot {
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        
        Set<Integer> aAlkiot = a.getAlkiot();
        Set<Integer> bAlkiot = b.getAlkiot();

        x.lisaaKaikki(aAlkiot);
        x.lisaaKaikki(bAlkiot);
        
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        Set<Integer> aAlkiot = a.getAlkiot();
        Set<Integer> bAlkiot = a.getAlkiot();
        
        for(int alkio : aAlkiot) {
            if(bAlkiot.contains(alkio)) y.lisaa(alkio);
        }
        
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        z.lisaaKaikki(a.getAlkiot());
        z.poistaKaikki(b.getAlkiot());
 
        return z;
    }
}
