

package statistics.matcher;


public class QueryBuilder {
    Matcher matcher;

    public QueryBuilder() {
        matcher = new DefaultMatcher();
    }
    
    public QueryBuilder playsIn(String team) {
        matcher = new And(this.matcher, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        matcher = new And(this.matcher, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        matcher = new And(this.matcher, new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        QueryBuilder orBuilder = new QueryBuilder();
        orBuilder.matcher = new Or(matchers);
        
        return orBuilder;
    }
    
    public Matcher build() {
        return matcher;
    }
}
