import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class PriorityQueueTest {
    static Stream<Arguments> streamProvider() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 2, 3}, new int[]{1, 3, 4, 5}),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{-3, -2, 1, 5}, new int[]{-3, -2, 1, 5}),
                Arguments.of(new int[]{0, 2, -5, -4}, new int[]{-5, -4, 0, 2}),
                Arguments.of(new int[]{-1, -2, -3, -4}, new int[]{-4, -3, -2, -1})
        );
    }

    @ParameterizedTest(name = "#{index} - Test with Argument={0},{1}")
    @MethodSource("streamProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array) {
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int[] result = new int[random_array.length];

        for (int i : random_array) {
            test.add(i);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = test.poll();
        }
        assertArrayEquals(correct_array, result);
    }

    @org.junit.jupiter.api.Test
    public void TestA() {
        assertThrows(IllegalArgumentException.class, () -> {
            PriorityQueue<Integer> test = new PriorityQueue<Integer>(-1);
        });
    }

    @org.junit.jupiter.api.Test
    public void TestB() {
        assertThrows(NoSuchElementException.class, () -> {
            PriorityQueue<Integer> test = new PriorityQueue<Integer>();
            test.remove();
        });
    }

    @org.junit.jupiter.api.Test
    public void TestC() {
        assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> test = new PriorityQueue<Integer>();
            test.add(null);
        });
    }
}
