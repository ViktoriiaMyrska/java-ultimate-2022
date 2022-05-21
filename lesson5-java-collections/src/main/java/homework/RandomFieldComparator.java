package homework;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.ObjectUtils.allNull;

/**
 * A generic comparator that is comparing a random field of the given class. The field is either primitive or
 * {@link Comparable}. It is chosen during comparator instance creation and is used for all comparisons.
 * <p>
 * By default it compares only accessible fields, but this can be configured via a constructor property. If no field is
 * available to compare, the constructor throws {@link IllegalArgumentException}
 *
 * @param <T> the type of the objects that may be compared by this comparator
 */
public class RandomFieldComparator<T> implements Comparator<T> {

    Class<T> targetType;
    Field comparingField;
    boolean compareOnlyAccessibleFields;

    public RandomFieldComparator(Class<T> targetType) {
        this(targetType, false);
    }

    /**
     * A constructor that accepts a class and a property indicating which fields can be used for comparison. If property
     * value is true, then only public fields or fields with public getters can be used.
     *
     * @param targetType                  a type of objects that may be compared
     * @param compareOnlyAccessibleFields config property indicating if only publicly accessible fields can be used
     */
    public RandomFieldComparator(Class<T> targetType, boolean compareOnlyAccessibleFields) {
        this.targetType = targetType;
        this.compareOnlyAccessibleFields = compareOnlyAccessibleFields;
        Field[] fields;
        if(compareOnlyAccessibleFields){
            fields = targetType.getFields();
        } else {
            fields = targetType.getDeclaredFields();
        }
        List<Field> comparableFields = Arrays.stream(fields)
                .filter(field -> field.getType().isPrimitive() || Comparable.class.isAssignableFrom(field.getType()))
                .toList();
        int randomFieldIndex;
        if (comparableFields.size() > 0) {
            randomFieldIndex = ThreadLocalRandom.current().nextInt(comparableFields.size());
            comparingField = comparableFields.get(randomFieldIndex);
        } else {
            throw new IllegalArgumentException("No comparable fields!");
        }
    }

    /**
     * Compares two objects of the class T by the value of the field that was randomly chosen. It allows null values
     * for the fields, and it treats null value grater than a non-null value (nulls last).
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @SneakyThrows
    @Override
    public int compare(T o1, T o2) {
        Objects.requireNonNull(o1);
        Objects.requireNonNull(o2);

        comparingField.setAccessible(true);
        Comparable field1 = (Comparable) comparingField.get(o1);
        Comparable field2 = (Comparable) comparingField.get(o2);
        comparingField.setAccessible(false);

        if (allNull(field1, field2)) {
            return 0;
        } else if (isNull(field1)) {
            return 1;
        } else if (isNull(field2)) {
            return -1;
        } else {
            return field1.compareTo(field2);
        }
    }

    /**
     * Returns a statement "Random field comparator of class '%s' is comparing '%s'" where the first param is the name
     * of the type T, and the second parameter is the comparing field name.
     *
     * @return a predefined statement
     */
    @Override
    public String toString() {
        return String.format("Random field comparator of class '%s' is comparing '%s'", targetType.getSimpleName(), comparingField.getName());
    }

}