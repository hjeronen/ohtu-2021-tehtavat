package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

        Matcher m = new And(new HasAtLeast(5, "goals"),
                new HasAtLeast(5, "assists"),
                new PlaysIn("PHI")
        );

        Matcher m2 = new And(
                new Not(new HasAtLeast(1, "goals")),
                new PlaysIn("NYR")
        );

        Matcher m3 = new And(
                new HasFewerThan(1, "goals"),
                new PlaysIn("NYR")
        );

        System.out.println(stats.matches(new All()).size());

        Matcher m4 = new Or(new HasAtLeast(30, "goals"),
                new HasAtLeast(50, "assists")
        );

        Matcher m5 = new And(
                new HasAtLeast(40, "points"),
                new Or(
                        new PlaysIn("NYR"),
                        new PlaysIn("NYI"),
                        new PlaysIn("BOS")
                )
        );

        QueryBuilder query = new QueryBuilder();
        Matcher m6 = query.build();

        QueryBuilder query2 = new QueryBuilder();

        Matcher m7 = query2.playsIn("NYR").build();

        QueryBuilder query3 = new QueryBuilder();

        Matcher m8 = query3.playsIn("NYR")
                .hasAtLeast(5, "goals")
                .hasFewerThan(10, "goals").build();

        for (Player player : stats.matches(m8)) {
            System.out.println(player);
        }
    }
}
