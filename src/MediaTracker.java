/**
 * MediaTracker enhanced interface.
 *
 * This interface provides secondary methods layered on top of the
 * MediaTrackerKernel methods.
 */
public interface MediaTracker extends MediaTrackerKernel {

    /**
     * Checks if a series exists in the tracker.
     *
     * @param title
     *            the title to check
     * @return true if present
     * @ensures containsSeries = (title is in this)
     */
    boolean containsSeries(String title);

    /**
     * Gets the progress of a series.
     *
     * @param title
     *            the title
     * @return progress value
     * @requires title is in this
     * @ensures getProgress = progress of title
     */
    int getProgress(String title);

    /**
     * Counts the number of series with a given status.
     *
     * @param status
     *            the status to count
     * @return number of series
     * @ensures countByStatus = number of entries with status
     */
    int countByStatus(Status status);

    /**
     * Counts the number of series of a given media type.
     *
     * @param type
     *            the media type
     * @return number of series
     * @ensures countByType = number of entries with type
     */
    int countByType(MediaType type);

    /**
     * Generates a summary report.
     *
     * @return formatted report string
     * @ensures generateSummaryReport is a summary of this
     */
    String generateSummaryReport();

}