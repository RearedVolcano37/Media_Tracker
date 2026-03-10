import components.standard.Standard;

/**
 * MediaTrackerKernel interface.
 *
 * Kernel interface for a MediaTracker component that tracks progress and status
 * of different media series.
 */
public interface MediaTrackerKernel extends Standard<MediaTracker> {

    /**
     * Media types supported by the tracker.
     */
    enum MediaType {
        MANGA, MANHUA, WEBTOON, ANIME, LIGHTNOVEL
    }

    /**
     * Status of a media series.
     */
    enum Status {
        PLANNING, IN_PROGRESS, COMPLETED, DROPPED
    }

    /**
     * Adds a new series to the tracker.
     *
     * @param title
     *            the title of the series
     * @param type
     *            the type of media
     * @updates this
     * @requires title is not already in this
     * @ensures title is added to this
     */
    void addSeries(String title, MediaType type);

    /**
     * Removes a series from the tracker.
     *
     * @param title
     *            the title of the series
     * @updates this
     * @requires title is in this
     * @ensures title is removed from this
     */
    void removeSeries(String title);

    /**
     * Updates the progress of a series.
     *
     * @param title
     *            the title of the series
     * @param progress
     *            the progress value
     * @updates this
     * @requires title is in this
     * @ensures progress of title is updated
     */
    void updateProgress(String title, int progress);

    /**
     * Sets the status of a series.
     *
     * @param title
     *            the title of the series
     * @param status
     *            the new status
     * @updates this
     * @requires title is in this
     * @ensures status of title is updated
     */
    void setStatus(String title, Status status);

    /**
     * Returns the number of series tracked.
     *
     * @return number of series
     * @ensures size = number of series in this
     */
    int size();

}