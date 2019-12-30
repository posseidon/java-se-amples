# Creation and destroy objects

## Consider using static factory over constructors

**ADVANTAGES**

> Static factories have names, unlike constructors.

```java
  new Number(String a);
  Number.prime(String fromStr);
```

> They are not required to create new object each time they are invoked.

```java
Boolean.valueOf(boolean b);
```

> They can return an object of any subtype of their return type, giving the flexibility in choosing the class of the returned object.

---

**DISADVANTAGES**

> Classes without ``public`` or ``protected`` constructors can't be sub-classed.
> Very hard to find.

## Consider using ``Builder``s when facing with many constructors.