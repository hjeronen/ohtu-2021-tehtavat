
package statistics.matcher;

public class QueryBuilder {
    private Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new All();
    }
    
    public Matcher build() {
        return this.matcher;
    }
}
