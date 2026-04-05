package components.mediatracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MediaTrackerTest {

    @Test
    void testAddSeries() {
        MediaTracker tracker = new MediaTracker1L();
        tracker.addSeries("Naruto", MediaType.ANIME);

        assertEquals(1, tracker.size());
        assertTrue(tracker.containsSeries("Naruto"));
    }

    @Test
    void testRemoveSeries() {
        MediaTracker tracker = new MediaTracker1L();
        tracker.addSeries("Naruto", MediaType.ANIME);
        tracker.removeSeries("Naruto");

        assertEquals(0, tracker.size());
        assertFalse(tracker.containsSeries("Naruto"));
    }

    @Test
    void testUpdateProgress() {
        MediaTracker tracker = new MediaTracker1L();
        tracker.addSeries("Naruto", MediaType.ANIME);
        tracker.updateProgress("Naruto", 50);

        assertEquals(50, tracker.getProgress("Naruto"));
    }

    @Test
    void testSetStatus() {
        MediaTracker tracker = new MediaTracker1L();
        tracker.addSeries("Naruto", MediaType.ANIME);
        tracker.setStatus("Naruto", Status.IN_PROGRESS);

        assertEquals(1, tracker.countByStatus(Status.IN_PROGRESS));
    }

    @Test
    void testCountByType() {
        MediaTracker tracker = new MediaTracker1L();
        tracker.addSeries("Naruto", MediaType.ANIME);
        tracker.addSeries("One Piece", MediaType.ANIME);
        tracker.addSeries("Berserk", MediaType.MANGA);

        assertEquals(2, tracker.countByType(MediaType.ANIME));
        assertEquals(1, tracker.countByType(MediaType.MANGA));
    }

    @Test
    void testGenerateSummaryReport() {
        MediaTracker tracker = new MediaTracker1L();
        tracker.addSeries("Naruto", MediaType.ANIME);

        String report = tracker.generateSummaryReport();

        assertTrue(report.contains("Naruto"));
        assertTrue(report.contains("ANIME"));
    }

    @Test
    void testAddDuplicateSeriesThrows() {
        MediaTracker tracker = new MediaTracker1L();
        tracker.addSeries("Naruto", MediaType.ANIME);

        assertThrows(IllegalStateException.class, () -> tracker.addSeries("Naruto", MediaType.ANIME));
    }

    @Test
    void testRemoveNonExistentThrows() {
        MediaTracker tracker = new MediaTracker1L();

        assertThrows(IllegalArgumentException.class, () -> tracker.removeSeries("Naruto"));
    }

    @Test
    void testGetProgressNonExistentThrows() {
        MediaTracker tracker = new MediaTracker1L();

        assertThrows(IllegalArgumentException.class, () -> tracker.getProgress("Naruto"));
    }
}
