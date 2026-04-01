package components.mediatracker;

/**
 * Kernel interface for {@code MediaTracker}.
 */
public interface MediaTrackerKernel extends Standard<MediaTracker> {

    void addSeries(String title, String type);

    void removeSeries(String title);

    void updateProgress(String title, int progress);

    void setStatus(String title, String status);

    int size();

    int indexOf(String title);

    String getTitle(int index);

    String getType(int index);

    int getProgress(int index);

    String getStatus(int index);

}
