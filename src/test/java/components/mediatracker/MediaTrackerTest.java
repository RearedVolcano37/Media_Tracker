package components.mediatracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import components.mediatracker.MediaTrackerKernel.MediaType;
import components.mediatracker.MediaTrackerKernel.Status;

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

        assertThrows(IllegalStateException.class,
                () -> tracker.addSeries("Naruto", MediaType.ANIME));
    }

    @Test
    void testRemoveNonExistentThrows() {
        MediaTracker tracker = new MediaTracker1L();

        assertThrows(IllegalArgumentException.class,
                () -> tracker.removeSeries("Naruto"));
    }

    @Test
    void testGetProgressNonExistentThrows() {
        MediaTracker tracker = new MediaTracker1L();

        assertThrows(IllegalArgumentException.class,
                () -> tracker.getProgress("Naruto"));
    }

    @Test
    void testEmptyTracker() {
        MediaTracker tracker = new MediaTracker1L();

        assertEquals(0, tracker.size());
        assertEquals(-1, tracker.indexOf("NonExistent"));
        assertEquals("", tracker.generateSummaryReport());
        assertEquals(0, tracker.countByStatus(Status.IN_PROGRESS));
        assertEquals(0, tracker.countByType(MediaType.ANIME));
    }

    @Test
    void testAllMediaTypes() {
        MediaTracker tracker = new MediaTracker1L();

        tracker.addSeries("Manga1", MediaType.MANGA);
        tracker.addSeries("Manhua1", MediaType.MANHUA);
        tracker.addSeries("Webtoon1", MediaType.WEBTOON);
        tracker.addSeries("Anime1", MediaType.ANIME);
        tracker.addSeries("LightNovel1", MediaType.LIGHTNOVEL);

        assertEquals(5, tracker.size());
        assertEquals(1, tracker.countByType(MediaType.MANGA));
        assertEquals(1, tracker.countByType(MediaType.MANHUA));
        assertEquals(1, tracker.countByType(MediaType.WEBTOON));
        assertEquals(1, tracker.countByType(MediaType.ANIME));
        assertEquals(1, tracker.countByType(MediaType.LIGHTNOVEL));
    }

    @Test
    void testAllStatuses() {
        MediaTracker tracker = new MediaTracker1L();

        tracker.addSeries("Series1", MediaType.ANIME);
        tracker.addSeries("Series2", MediaType.MANGA);
        tracker.addSeries("Series3", MediaType.WEBTOON);
        tracker.addSeries("Series4", MediaType.LIGHTNOVEL);

        tracker.setStatus("Series1", Status.PLANNING);
        tracker.setStatus("Series2", Status.IN_PROGRESS);
        tracker.setStatus("Series3", Status.COMPLETED);
        tracker.setStatus("Series4", Status.DROPPED);

        assertEquals(1, tracker.countByStatus(Status.PLANNING));
        assertEquals(1, tracker.countByStatus(Status.IN_PROGRESS));
        assertEquals(1, tracker.countByStatus(Status.COMPLETED));
        assertEquals(1, tracker.countByStatus(Status.DROPPED));
    }

    @Test
    void testIndexOfAndGetTitle() {
        MediaTracker tracker = new MediaTracker1L();

        tracker.addSeries("First", MediaType.ANIME);
        tracker.addSeries("Second", MediaType.MANGA);

        assertEquals(0, tracker.indexOf("First"));
        assertEquals(1, tracker.indexOf("Second"));
        assertEquals(-1, tracker.indexOf("Third"));

        assertEquals("First", tracker.getTitle(0));
        assertEquals("Second", tracker.getTitle(1));
    }

    @Test
    void testGetTypeAndGetStatus() {
        MediaTracker tracker = new MediaTracker1L();

        tracker.addSeries("Test", MediaType.ANIME);
        tracker.setStatus("Test", Status.IN_PROGRESS);

        assertEquals(MediaType.ANIME, tracker.getType("Test"));
        assertEquals(Status.IN_PROGRESS, tracker.getStatus("Test"));
    }

    @Test
    void testGetProgressValue() {
        MediaTracker tracker = new MediaTracker1L();

        tracker.addSeries("Test", MediaType.ANIME);
        tracker.updateProgress("Test", 100);

        assertEquals(100, tracker.getProgressValue("Test"));
    }

    @Test
    void testMultipleOperations() {
        MediaTracker tracker = new MediaTracker1L();

        tracker.addSeries("A", MediaType.ANIME);
        tracker.addSeries("B", MediaType.MANGA);
        tracker.updateProgress("A", 50);
        tracker.setStatus("A", Status.IN_PROGRESS);
        tracker.setStatus("B", Status.COMPLETED);

        assertEquals(2, tracker.size());
        assertTrue(tracker.containsSeries("A"));
        assertTrue(tracker.containsSeries("B"));
        assertEquals(50, tracker.getProgress("A"));
        assertEquals(1, tracker.countByStatus(Status.IN_PROGRESS));
        assertEquals(1, tracker.countByStatus(Status.COMPLETED));

        tracker.removeSeries("A");
        assertEquals(1, tracker.size());
        assertFalse(tracker.containsSeries("A"));
    }

    @Test
    void testSummaryReportComprehensive() {
        MediaTracker tracker = new MediaTracker1L();

        tracker.addSeries("Naruto", MediaType.ANIME);
        tracker.addSeries("Berserk", MediaType.MANGA);
        tracker.updateProgress("Naruto", 220);
        tracker.setStatus("Naruto", Status.IN_PROGRESS);
        tracker.setStatus("Berserk", Status.COMPLETED);

        String report = tracker.generateSummaryReport();

        assertTrue(report.contains("Naruto"));
        assertTrue(report.contains("ANIME"));
        assertTrue(report.contains("220"));
        assertTrue(report.contains("IN_PROGRESS"));
        assertTrue(report.contains("Berserk"));
        assertTrue(report.contains("MANGA"));
        assertTrue(report.contains("COMPLETED"));
    }
}
