package hu.elte.java.se;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LamdasTest {

    interface Greeting {
        public String sayHi(String name);
    }

    @Test
    public void greeting(){
        String result = greet("Alan Schalker", s -> "Hi ".concat(s).concat(" !"));
        assertThat(result).isEqualTo("Hi Alan Schalker !");
    }

    String greet(String name, Greeting g){
        return g.sayHi(name);
    }
}
