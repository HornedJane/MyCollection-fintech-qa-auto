import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCollection<E> implements Collection<E> {

    private static final int DEFAULT_LENGTH = 10;
    private static final double DEFAULT_LENGTH_MODIFIER = 1.5f;
    private int size;
    private Object[] elementData = new Object[DEFAULT_LENGTH];

    @Override
    public final boolean add(final E e) {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, (int) (size * DEFAULT_LENGTH_MODIFIER));
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public final int size() {
        return this.size;
    }

    @Override
    public final boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public final Iterator<E> iterator() {
        return new MyIterator<>();
    }

    @Override
    public final boolean contains(final Object object) {
        for (E element : this) {
            if (element.equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final Object[] toArray() {
        return Arrays.copyOfRange(elementData, 0, size);
    }

    @Override
    @SuppressWarnings("unchecked")
    public final <T> T[] toArray(final T[] array) {
        if (array.length < size) {
            return (T[]) Arrays.copyOf(elementData, size, array.getClass());
        }
        for (int i = 0; i < size; i++) {
            array[i] = (T) elementData[i];
        }
        return array;
    }

    @Override
    public final boolean remove(final Object object) {
        Iterator<E> iterator = iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals(object)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean containsAll(final Collection<?> collection) {
        for (Object object : collection) {
            if (!this.contains(object)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final boolean addAll(final Collection<? extends E> collection) {
        for (E object : collection) {
            this.add(object);
        }
        return true;
    }

    @Override
    public final boolean removeAll(final Collection<?> collection) {
        boolean result = false;

        for (Object object : collection) {
            if (remove(object)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public final boolean retainAll(final Collection<?> collection) {
        boolean result = false;

        for (E element : this) {
            if (!collection.contains(element)) {
                this.remove(element);
                result = true;
            }
        }
        return result;
    }

    @Override
    public final void clear() {
        for (E element : this) {
            this.remove(element);
        }
    }

    private class MyIterator<T> implements Iterator<T> {

        private int cursor = 0;
        private boolean removable = false;

        @Override
        public final boolean hasNext() {
            return cursor < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public final T next() {
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            removable = true;
            return (T) elementData[cursor++];
        }

        @Override
        public final void remove() {
            if (!removable) {
                throw new java.lang.IllegalStateException();
            }
            Object[] newElementData = new Object[elementData.length];
            System.arraycopy(elementData, 0, newElementData, 0, cursor - 1);
            System.arraycopy(elementData, cursor, newElementData, cursor - 1, size - 1);
            elementData = Arrays.copyOf(newElementData, elementData.length);
            size--;
            cursor--;
            removable = false;
        }
    }
}