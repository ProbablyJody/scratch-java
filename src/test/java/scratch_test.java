import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ScratchTest {
    @Test
    void scratch() {

    System.out.println("Primitive - Return:" + primitiveTest());

    }

    int primitiveTest() {
        int primitive_example = 1;

        try {

            System.out.println("Primitive - Init: " + primitive_example);
            throw new RuntimeException("re");

        }  catch (RuntimeException re) {
            System.out.println("Primitive - Catch: " + primitive_example);
            return primitive_example;

        } finally {
            primitive_example = 2;
            System.out.println("Primitive - Finally: " + primitive_example);
            return primitive_example;
        }

    }
}
