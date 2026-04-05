import components.mediatracker.*;
import static components.mediatracker.MediaTrackerKernel.MediaType;
import static components.mediatracker.MediaTrackerKernel.Status;

/**
 * Sample 1: Simple Anime Tracker
 * Demonstrates basic usage of MediaTracker for tracking anime series.
 */
public class AnimeTrackerSample {

    public static void main(String[] args) {
        MediaTracker tracker = new MediaTracker1L();

        // Add some anime series
        tracker.addSeries("Naruto", MediaType.ANIME);
        tracker.addSeries("One Piece", MediaType.ANIME);
        tracker.addSeries("Attack on Titan", MediaType.ANIME);

        // Update progress
        tracker.updateProgress("Naruto", 220);
        tracker.setStatus("Naruto", Status.IN_PROGRESS);

        tracker.updateProgress("One Piece", 1050);
        tracker.setStatus("One Piece", Status.IN_PROGRESS);

        tracker.setStatus("Attack on Titan", Status.COMPLETED);

        // Generate report
        System.out.println("Anime Tracking Report:");
        System.out.println(tracker.generateSummaryReport());

        // Count by status
        System.out.println("In Progress: " + tracker.countByStatus(Status.IN_PROGRESS));
        System.out.println("Completed: " + tracker.countByStatus(Status.COMPLETED));
    }
}