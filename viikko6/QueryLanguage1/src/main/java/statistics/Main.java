package statistics;

import statistics.matcher.Matcher;
import statistics.matcher.QueryBuilder;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();

        Matcher m1 = query.playsIn("PHI").build();

        Matcher m2 = query.playsIn("EDM")
                .hasAtLeast(50, "points").build();

        Matcher m = query.oneOf(m1, m2).build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
