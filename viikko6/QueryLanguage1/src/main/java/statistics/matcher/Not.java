

package statistics.matcher;

import statistics.Player;


public class Not implements Matcher{
    
    Matcher toBeNegated;

    public Not(Matcher toBeNegated) {
        this.toBeNegated = toBeNegated;
    }
    
    @Override
    public boolean matches(Player p) {
        return !toBeNegated.matches(p);
    }

}
