package hu.elte.java.se;


import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionsTest
{
    private List<String> names = Arrays.asList("Peter Pan", "Noah", "Adam", "Johny English", "Pi", "Zoltan Zoran", "Noa", "Anna", "Zoltan Zubr");

    private static final Pair<String, Integer> pi = new ImmutablePair<>("Pi", 2);
    private static final Pair<String, Integer> johny = new ImmutablePair<>("Johny English", 13);
    private static final Pair<String, Integer> adam =  new ImmutablePair<>("Adam", 4);
    private static final Pair<String, Integer> zubr = new ImmutablePair<>("Zoltan Zubr", 11);
    private final List<Pair<String, Integer>> pairs = Arrays.asList(pi, johny, adam, zubr);

    private static final Person peter = new Person("Peter", 20, LEVEL.LEAD);
    private static final Person david = new Person("David", 33, LEVEL.DEVELOPER);
    private static final Person amanda = new Person("Amanda", 37, LEVEL.ARCHITECT);
    private static final Person jackie = new Person("Jackie", 40, LEVEL.JUNIOR);
    private static final Person sebastian = new Person("Sebastian", 44, LEVEL.SENIOR);
    private static final Person jet = new Person("Jet Li", 38, LEVEL.SENIOR);
    private static final Person abraham = new Person("Abraham", 43, LEVEL.SENIOR);
    private final List<Person> people = Arrays.asList(peter, david, amanda, jackie, sebastian, jet, abraham);


    @Test
    public void shouldFilter()
    {
        List<String> name = names.stream()
                .filter(n -> n.startsWith("A"))
                .filter(n -> n.endsWith("a"))
                .collect(Collectors.toList());
        assertThat(name).containsExactly("Anna");
    }

    @Test
    public void shouldComparator(){
        List<Pair<String, Integer>> nameAndLength = names.stream()
                .map(n -> new ImmutablePair<>(n, n.length()))
                .collect(Collectors.toList());

        nameAndLength.sort(Comparator.comparingInt(Pair::getRight));
        assertThat(nameAndLength.get(0)).isEqualTo(pi);
        assertThat(nameAndLength.get(nameAndLength.size()- 1)).isEqualTo(johny);
        nameAndLength.sort(Comparator.comparing(Pair<String, Integer>::getLeft).thenComparing(Pair::getRight));
        assertThat(nameAndLength.get(0)).isEqualTo(adam);
        assertThat(nameAndLength.get(nameAndLength.size() - 1)).isEqualTo(zubr);
        nameAndLength.sort(Comparator.reverseOrder());
        assertThat(nameAndLength.get(0)).isEqualTo(zubr);
        assertThat(nameAndLength.get(nameAndLength.size() - 1)).isEqualTo(adam);
    }

    @Test
    public void customComparator(){
        /*
        pairs.sort(new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> t1, Pair<String, Integer> t2) {
                return t1.getRight() - t2.getRight();
            }
        });
         */
        // pairs.sort((t1, t2) -> t1.getRight() - t2.getRight());

        pairs.sort(Comparator.comparingInt(Pair::getRight));

        assertThat(pairs.get(0)).isEqualTo(pi);
        assertThat(pairs.get(pairs.size() - 1)).isEqualTo(johny);
    }

    /**
     * Person{name='Amanda', salary=37, level=ARCHITECT}
     * Person{name='Peter', salary=20, level=LEAD}
     * Person{name='Abraham', salary=43, level=SENIOR}
     * Person{name='Jet Li', salary=38, level=SENIOR}
     * Person{name='Sebastian', salary=44, level=SENIOR}
     * Person{name='David', salary=33, level=DEVELOPER}
     * Person{name='Jackie', salary=40, level=JUNIOR}
     */
    @Test
    public void chainComparator(){
        people.sort(Comparator.comparing(Person::getLevel)
                .reversed()
                .thenComparing(Comparator.comparing(Person::getName))
                .thenComparing(Person::getSalary)
        );
        // getSalary -> Integer implements Comparable
        // getName -> String implements Comparable

        assertThat(people.get(0)).isEqualTo(amanda);
        assertThat(people.get(2)).isEqualTo(abraham);
        assertThat(people.get(4)).isEqualTo(sebastian);
        assertThat(people.get(people.size() - 1)).isEqualTo(jackie);
    }
}
