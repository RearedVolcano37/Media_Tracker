package components.mediatracker;

/**
 * Kernel interface for the MediaTracker component.
 */
public interface MediaTrackerKernel extends Standard<MediaTracker> {

    /**
     * Add a new series with a given title and type.
     * 
     * @param title
     *            non-null non-empty title
     * @param type
     *            non-null non-empty type
     * @requires title != null && !title.isBlank() && type != null &&
     *           !type.isBlank()
     * @requires indexOf(title) < 0
     * @ensures size() = #size() + 1
     */
    void addSeries(String title, String type);

    /**
     * Remove a series by title.
     * 
     * @param title
     *            non-null non-empty existing title
     * @requires title != null && !title.isBlank() && indexOf(title) >= 0
     * @ensures size() = #size() - 1
     */
    void removeSeries(String title);

    /**
     * Set progress for a series.
     * 
     * @param title
     *            non-null non-empty existing title
     * @param progress
     *            non-negative progress value
     * @requires title != null && !title.isBlank() && indexOf(title) >= 0 &&
     *           progress >= 0
     * @ensures getSeriesProgress(title) = progress
     */
    void updateProgress(String title, int progress);

    /**
     * Set status for a series.
     * 
     * @param title
     *            non-null non-empty existing title
     * @param status
     *            non-null non-empty status
     * @requires title != null && !title.isBlank() && indexOf(title) >= 0 &&
     *           status != null && !status.isBlank()
     * @ensures getSeriesStatus(title).equals(status)
     */
    void setStatus(String title, String status);

    /**
     * Number of series in tracker.
     * 
     * @return non-negative count
     */
    int size();

    /**
     * Find index of series or -1.
     * 
     * @param title
     *            non-null non-empty title
     * @return index of title or -1 if missing
     */
    int indexOf(String title);

    /**
     * Get the title of the series at index.
     * 
     * @param index
     *            valid index
     * @return title
     */
    String getTitle(int index);

    /**
     * Get the type of the series at index.
     * 
     * @param index
     *            valid index
     * @return type
     */
    String getType(int index);

    /**
     * Get the progress of the series at index.
     * 
     * @param index
     *            valid index
     * @return progress
     */
    int getProgress(int index);

    /**
     * Get the status of the series at index.
     * 
     * @param index
     *            valid index
     * @return status
     */
    String getStatus(int index);
}
