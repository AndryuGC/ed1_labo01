package ed.lab;
import java.util.Random;

//Andry
public class Main {
    public static void main(String[] args) {
        ArrayGenerator<Integer> sortedArrayGenerator = (length) -> {
            Integer[] array = new Integer[length];
            for (int i = 0; i < length; i++) {
                array[i] = i;
            }
            return array;
        };

        ArrayGenerator<Integer> invertedArrayGenerator = (length) -> {
            Integer[] array = new Integer[length];
            for (int i = 0; i < length; i++) {
                array[i] = length - 1 - i;
            }
            return array;
        };

        ArrayGenerator<Integer> randomArrayGenerator = (length) -> {
            Integer[] array = new Integer[length];
            Random rand = new Random();
            for (int i = 0; i < length; i++) {
                array[i] = rand.nextInt(1000);
            }
            return array;
        };

        // Uso de referencias a métodos en SortingAlgorithms
        QuickSort<Integer> highPivotQuickSort = SortingAlgorithms::highPivotQuickSort;
        QuickSort<Integer> lowPivotQuickSort = SortingAlgorithms::lowPivotQuickSort;
        QuickSort<Integer> randomPivotQuickSort = SortingAlgorithms::randomPivotQuickSort;

        // Ejecutar pruebas de ordenamiento
        testSortingAlgorithm("High Pivot QuickSort", sortedArrayGenerator, highPivotQuickSort);
        testSortingAlgorithm("Low Pivot QuickSort", sortedArrayGenerator, lowPivotQuickSort);
        testSortingAlgorithm("Random Pivot QuickSort", sortedArrayGenerator, randomPivotQuickSort);
    }

    public static void testSortingAlgorithm(String name, ArrayGenerator<Integer> generator, QuickSort<Integer> sorter) {
        Integer[] array = generator.generate(10000);
        long startTime = System.nanoTime();
        sorter.sort(array);
        long endTime = System.nanoTime();
        System.out.println(name + " tomó: " + (endTime - startTime) / 1e6 + " ms");
    }
}
