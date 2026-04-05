package components.mediatracker;

/**
 * OSU Standard interface used by kernel implementations.
 *
 * @param <T>
 *             component type
 */
public interface Standard<T> {

     /**
      * Clear this component to its initial state.
      *
      * @ensures <pre>this = #this</pre> (empty representation)
      */
     void clear();

     /**
      * Move data from source to this.
      *
      * @param source
      *             non-null source component
      * @requires source != null
      * @ensures this = #source
      * @clears source
      */
     void transferFrom(T source);

     /**
      * Create a new, empty instance of the same implementation.
      *
      * @return new component instance
      * @ensures <pre>result is fresh, empty</pre>
      */
     T newInstance();
}
