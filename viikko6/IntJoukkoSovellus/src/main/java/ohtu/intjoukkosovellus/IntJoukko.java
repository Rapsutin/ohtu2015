
package ohtu.intjoukkosovellus;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class IntJoukko {

    private Set<Integer> alkiot;

    public IntJoukko() {
        alkiot = new HashSet<Integer>();
    }
    
    public boolean lisaa(int luku) {
        return alkiot.add(luku);
    }
    
    public void lisaaKaikki(Collection<Integer> luvut) {
        alkiot.addAll(luvut);
    }

    public boolean kuuluu(int luku) {
        return alkiot.contains(luku);
    }

    public boolean poista(int luku) {
        return alkiot.remove(Integer.valueOf(luku));
    }
    
    public void poistaKaikki(Set<Integer> alkiot) {
        alkiot.removeAll(alkiot);
    }
    

    public int mahtavuus() {
        return alkiot.size();
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");
        for(int alkio : alkiot) {
            string.append(alkio+", ");
        }
        string = string.delete(string.length()-2, string.length());
        string.append("}");
        return string.toString();
   }

    public int[] toIntArray() {
        Integer[] integers = alkiot.toArray(new Integer[1]);
        int[] intArray = new int[integers.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = integers[i].intValue();
        }
        return intArray;
    }
    
    public Set<Integer> getAlkiot() {
        return alkiot;
    }

    
        
}