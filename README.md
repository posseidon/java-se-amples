# Standard Java sample codes
Using Java 8, 9, and 11

## Starting with Java collections

Stream sorting

```javascript
stream()
  .filter()

stream()
  .sort(Comparator.comparingInt())
  .sort(Comparator.comparing())
  .sort(Comparator.reverseOrder())

nameAndLength.sort(Comparator.comparingInt(Pair::getRight));
nameAndLength.sort(Comparator.comparing(Pair<String, Integer>::getLeft).thenComparing(Pair::getRight));

pairs.sort(Comparator.comparingInt(Pair::getRight));
        people.sort(Comparator.comparing(Person::getLevel)
                .reversed()
                .thenComparing(Comparator.comparing(Person::getName))
                .thenComparing(Person::getSalary)
        );

```

- collections/map
- collections/set

