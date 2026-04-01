package components.mediatracker;

/**
 * Enhanced interface for {@code MediaTracker} operations.
 */
public interface MediaTracker extends MediaTrackerKernel {

    boolean containsSeries(String title);

    String getSeriesType(String title);

    int getSeriesProgress(String title);

    String getSeriesStatus(String title);

    void markCompleted(String title);

    int countByStatus(String status);

    int countByType(String type);

    String generateSummaryReport();

}
