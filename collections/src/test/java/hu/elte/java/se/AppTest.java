package hu.elte.java.se;


import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest
{
    private static List<String> names = Arrays.asList("Peter Pan", "Noah", "Adam", "Johny English", "Pi", "Zoltan Zoran", "Noa", "Anna", "Zoltan Zubr");
    private static final Pair<String, Integer> pi = new ImmutablePair<>("Pi", 2);
    private static final Pair<String, Integer> johny = new ImmutablePair<>("Johny English", 13);
    private static final Pair<String, Integer> adam =  new ImmutablePair<>("Adam", 4);
    private static final Pair<String, Integer> zubr = new ImmutablePair<>("Zoltan Zubr", 11);


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
                .map(n -> new ImmutablePair<>(n, Integer.valueOf(n.length())))
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
}
