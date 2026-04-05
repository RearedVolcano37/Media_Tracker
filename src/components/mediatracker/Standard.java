package components.mediatracker;

/**
 * A minimal OSU-style standard interface for component types.
 *
 * @param <T>
 *            the component type
 */
public interface Standard<T> {

    /**
     * Reset this value to its initial (empty) state.
     */
    void clear();

    /**
     * Transfer resources from {@code source} into this object. The source is
     * left in a valid empty state.
     *
     * @param source
     *            the source object
     */
    void transferFrom(T source);

    /**
     * Create and return a new instance of this type.
     *
     * @return a new instance
     */
    T newInstance();

}
