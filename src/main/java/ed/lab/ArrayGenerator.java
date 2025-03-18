package ed.lab;
//Commits
@FunctionalInterface
public interface ArrayGenerator<T> {
    T[] generate(int length);
}