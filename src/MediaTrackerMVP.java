import java.util.HashMap;
import java.util.Map;

/**
 * MediaTrackerMVP
 *
 * A proof-of-concept implementation of the Media Tracker component. This file
 * demonstrates feasibility and does NOT follow full OSU layering yet.
 */
public class MediaTrackerMVP {

    /* -------------------- Enums -------------------- */

    public enum MediaType {
        MANGA, MANHUA, WEBTOON, ANIME
    }

    public enum Status {
        PLANNING, IN_PROGRESS, COMPLETED, DROPPED
    }

    /* -------------------- Internal Representation -------------------- */

    private static class SeriesEntry {
        String title;
        MediaType type;
        int progress;
        Status status;

        SeriesEntry(String title, MediaType type) {
            this.title = title;
            this.type = type;
            this.progress = 0;
            this.status = Status.PLANNING;
        }
    }

    private Map<String, SeriesEntry> seriesMap;

    /* -------------------- Constructor -------------------- */

    public MediaTrackerMVP() {
        this.seriesMap = new HashMap<>();
    }

    /* -------------------- Core Methods -------------------- */

    public void addSeries(String title, MediaType type) {
        if (!this.seriesMap.containsKey(title)) {
            this.seriesMap.put(title, new SeriesEntry(title, type));
        }
    }

    public void removeSeries(String title) {
        this.seriesMap.remove(title);
    }

    public void updateProgress(String title, int progress) {
        if (this.seriesMap.containsKey(title)) {
            SeriesEntry entry = this.seriesMap.get(title);
            entry.progress = progress;
            entry.status = Status.IN_PROGRESS;
        }
    }

    public void setStatus(String title, Status status) {
        if (this.seriesMap.containsKey(title)) {
            this.seriesMap.get(title).status = status;
        }
    }

    public int size() {
        return this.seriesMap.size();
    }

    /* -------------------- Secondary-Like Methods -------------------- */

    public boolean containsSeries(String title) {
        return this.seriesMap.containsKey(title);
    }

    public int getProgress(String title) {
        if (this.seriesMap.containsKey(title)) {
            return this.seriesMap.get(title).progress;
        }
        return -1;
    }

    public int countByStatus(Status status) {
        int count = 0;
        for (SeriesEntry entry : this.seriesMap.values()) {
            if (entry.status == status) {
                count++;
            }
        }
        return count;
    }

    public int countByType(MediaType type) {
        int count = 0;
        for (SeriesEntry entry : this.seriesMap.values()) {
            if (entry.type == type) {
                count++;
            }
        }
        return count;
    }

    public String generateSummaryReport() {
        StringBuilder report = new StringBuilder();
        report.append("===== MEDIA TRACKER REPORT =====\n");
        report.append("Total Series: ").append(this.size()).append("\n");
        report.append("Completed: ").append(this.countByStatus(Status.COMPLETED))
                .append("\n");
        report.append("In Progress: ").append(this.countByStatus(Status.IN_PROGRESS))
                .append("\n");
        report.append("Planning: ").append(this.countByStatus(Status.PLANNING))
                .append("\n");
        report.append("Dropped: ").append(this.countByStatus(Status.DROPPED))
                .append("\n");
        return report.toString();
    }

    /* -------------------- Main Method -------------------- */

    public static void main(String[] args) {

        MediaTrackerMVP tracker = new MediaTrackerMVP();

        // Adding series
        tracker.addSeries("One Piece", MediaType.MANGA);
        tracker.addSeries("Solo Leveling", MediaType.MANHUA);
        tracker.addSeries("Tower of God", MediaType.WEBTOON);
        tracker.addSeries("Attack on Titan", MediaType.ANIME);

        // Updating progress
        tracker.updateProgress("One Piece", 1100);
        tracker.updateProgress("Solo Leveling", 200);

        // Manually setting status
        tracker.setStatus("Attack on Titan", Status.COMPLETED);

        // Demonstrating queries
        System.out.println(
                "Contains 'One Piece'? " + tracker.containsSeries("One Piece"));
        System.out.println(
                "One Piece progress: " + tracker.getProgress("One Piece"));
        System.out.println(
                "Anime count: " + tracker.countByType(MediaType.ANIME));

        // Remove a series
        tracker.removeSeries("Tower of God");

        // Generate summary report
        System.out.println();
        System.out.println(tracker.generateSummaryReport());
    }
}