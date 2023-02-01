import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class scratch_test {

    @BeforeEach
    void before() {

    }

    @Test
    void testPrimitive() {

        int oldValue = 1;
        int newValue = 2;

         Supplier doFn = () -> {

            int primitiveExample = oldValue;

            try {

                //assertEquals(oldValue, primitiveExample);
                throw new RuntimeException("re");

            } catch (RuntimeException re) {
                //assertEquals(oldValue, primitiveExample);
                return primitiveExample;

            } finally {
                primitiveExample = newValue;
                //assertEquals(newValue, primitiveExample);
            }
        };

         // The finally block did not modify the variable
        assertEquals(oldValue, doFn.get());
    }

    @Test
    void testObjectValue() {

        List<String> oldValue = List.of("one", "two", "three");
        List<String> newValue = List.of("one", "two", "three", "four");


        // Create a function to isolate the try/catch/finally and emulate a method call.
        Supplier doFn = () -> {

            List<String> primitiveExample = new ArrayList<>(oldValue);

            try {

                assertEquals(oldValue, primitiveExample);
                throw new RuntimeException("re");

            } catch (RuntimeException re) {
                assertEquals(oldValue, primitiveExample);
                return primitiveExample;

            } finally {
                primitiveExample.add("four");
                assertEquals(newValue, primitiveExample);
            }
        };

        // The finally block did  modify the variable's value
        assertEquals(newValue, doFn.get());
    }

    @Test
    void objectReferenceTest() {
        List<String> oldValue = List.of("one", "two", "three");
        List<String> newValue = List.of("A", "B", "C");


        Supplier doFn = () -> {

            List<String> primitiveExample = new ArrayList<>(oldValue);

            try {

                assertEquals(oldValue, primitiveExample);
                throw new RuntimeException("re");

            } catch (RuntimeException re) {
                assertEquals(oldValue, primitiveExample);
                return primitiveExample;

            } finally {
                primitiveExample = newValue;
                assertEquals(newValue, primitiveExample);
            }
        };

        // The finally block did not modify the variable
        assertEquals(oldValue, doFn.get());
    }
}