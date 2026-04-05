package components.mediatracker;

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

    /**
     * Returns the index of a series by title.
     *
     * @param title
     *            the title
     * @return index or -1 if not found
     * @ensures indexOf = index of title or -1
     */
    int indexOf(String title);

    /**
     * Gets the title at an index.
     *
     * @param index
     *            the index
     * @return title
     * @requires 0 <= index < size()
     * @ensures getTitle = title at index
     */
    String getTitle(int index);

    /**
     * Gets the type at an index.
     *
     * @param index
     *            the index
     * @return type
     * @requires 0 <= index < size()
     * @ensures getType = type at index
     */
    String getType(int index);

    /**
     * Gets the progress at an index.
     *
     * @param index
     *            the index
     * @return progress
     * @requires 0 <= index < size()
     * @ensures getProgress = progress at index
     */
    int getProgress(int index);

    /**
     * Gets the status at an index.
     *
     * @param index
     *            the index
     * @return status
     * @requires 0 <= index < size()
     * @ensures getStatus = status at index
     */
    String getStatus(int index);

}