package onlineTraning;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A generic comparator that is comparing a random field of the given class. The field is either primitive or
 * {@link Comparable}. It is chosen during comparator instance creation and is used for all comparisons.
 * <p>
 * If no field is available to compare, the constructor throws {@link IllegalArgumentException}
 *
 * @param <T> the type of the objects that may be compared by this comparator
 */
public class RandomFieldComparator<T> implements Comparator<T> {

    private Class<T> clazz;
    private Field randomField;

    public RandomFieldComparator(Class<T> targetType) {
        clazz = targetType;
        var declaredFields = targetType.getDeclaredFields();
        var fieldIndex = ThreadLocalRandom.current().nextInt(declaredFields.length);
        randomField = declaredFields[fieldIndex];
    }

    /**
     * Compares two objects of the class T by the value of the field that was randomly chosen. It allows null values
     * for the fields, and it treats null value grater than a non-null value.
     *
     * @param o1
     * @param o2
     * @return
     */
    @SneakyThrows
    @Override
    public int compare(T o1, T o2) {
        randomField.setAccessible(true);
        var field1 = (Comparable) randomField.get(o1);
        var field2 = (Comparable) randomField.get(o2);
        randomField.setAccessible(false);
        return field1.compareTo(field2);
    }

    /**
     * Returns a statement "Random field comparator of class '%s' is comparing '%s'" where the first param is the name
     * of the type T, and the second parameter is the comparing field name.
     *
     * @return a predefined statement
     */
    @Override
    public String toString() {
        return String.format("Random field comparator of class '%s' is comparing '%s'", clazz, randomField.getName());
    }
}
