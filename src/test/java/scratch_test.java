import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ScratchTest {
    @Test
    void scratch() {

        System.out.println("Primitive - Return:" + primitiveTest());
        System.out.println("Object Value - Return:" + objectValueTest());
        System.out.println("Object Reference - Return:" + objectReferenceTest());
    }

    int primitiveTest() {
        int primitiveExample = 1;

        try {

            System.out.println("Primitive - Init: " + primitiveExample);
            throw new RuntimeException("re");

        } catch (RuntimeException re) {
            System.out.println("Primitive - Catch: " + primitiveExample);
            return primitiveExample;

        } finally {
            primitiveExample = 2;
            System.out.println("Primitive - Finally: " + primitiveExample);
        }

    }

    List<String> objectValueTest() {
        List<String> objectExample = new ArrayList<String>(List.of("one", "two", "three"));

        try {

            System.out.println("Object Value - Init: " + objectExample.toString());
            throw new RuntimeException("re");

        } catch (RuntimeException re) {
            System.out.println("Object Value - Catch: " + objectExample.toString());
            return objectExample;

        } finally {
            objectExample.add("four");
            System.out.println("Object Value - Finally: " + objectExample.toString());
        }
    }

    List<String> objectReferenceTest() {
        List<String> objectExample = new ArrayList<String>(List.of("one", "two", "three"));

        try {

            System.out.println("Object Reference - Init: " + objectExample.toString());
            throw new RuntimeException("re");

        } catch (RuntimeException re) {
            System.out.println("Object Reference - Catch: " + objectExample.toString());
            return objectExample;

        } finally {
            objectExample = List.of("A", "B", "C");
            System.out.println("Object Value - Finally: " + objectExample.toString());
        }
    }
}