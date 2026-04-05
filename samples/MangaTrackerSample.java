import components.mediatracker.MediaTracker;
import components.mediatracker.MediaTracker1L;
import components.mediatracker.MediaTrackerKernel.MediaType;
import components.mediatracker.MediaTrackerKernel.Status;

/**
 * Sample 2: Advanced Manga Tracker Demonstrates advanced usage including
 * different media types and status management.
 *
 * Might have to run this in order to run properly javac -cp "src"
 * samples\MangaTrackerSample.java java -cp "src;samples" MangaTrackerSample
 */
public class MangaTrackerSample {

    public static void main(String[] args) {
        MediaTracker tracker = new MediaTracker1L();

        // Add various media
        tracker.addSeries("Berserk", MediaType.MANGA);
        tracker.addSeries("One Punch Man", MediaType.MANGA);
        tracker.addSeries("Solo Leveling", MediaType.WEBTOON);
        tracker.addSeries("The Beginning After The End", MediaType.LIGHTNOVEL);

        // Set different statuses
        tracker.setStatus("Berserk", Status.IN_PROGRESS);
        tracker.updateProgress("Berserk", 350);

        tracker.setStatus("One Punch Man", Status.COMPLETED);
        tracker.updateProgress("One Punch Man", 200);

        tracker.setStatus("Solo Leveling", Status.IN_PROGRESS);
        tracker.updateProgress("Solo Leveling", 150);

        tracker.setStatus("The Beginning After The End", Status.PLANNING);

        // Display counts
        System.out.println("Media Tracker Summary:");
        System.out.println("Total series: " + tracker.size());
        System.out.println("Manga: " + tracker.countByType(MediaType.MANGA));
        System.out
                .println("Webtoons: " + tracker.countByType(MediaType.WEBTOON));
        System.out.println(
                "Light Novels: " + tracker.countByType(MediaType.LIGHTNOVEL));
        System.out.println(
                "In Progress: " + tracker.countByStatus(Status.IN_PROGRESS));
        System.out.println(
                "Completed: " + tracker.countByStatus(Status.COMPLETED));
        System.out
                .println("Planning: " + tracker.countByStatus(Status.PLANNING));

        // Full report
        System.out.println("\nDetailed Report:");
        System.out.println(tracker.generateSummaryReport());
    }
}