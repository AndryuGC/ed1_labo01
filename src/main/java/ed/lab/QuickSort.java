package ed.lab;
//Commits
@FunctionalInterface
public interface QuickSort<T extends Comparable<T>> {
    void sort(T[] array);
}