package components.mediatracker;

import components.mediatracker.MediaTrackerKernel.MediaType;
import components.mediatracker.MediaTrackerKernel.Status;

/**
 * Test class for MediaTracker.
 */
public class MediaTrackerTest {

    public static void main(String[] args) {
        testAddSeries();
        testRemoveSeries();
        testUpdateProgress();
        testSetStatus();
        testCountByType();
        testGenerateSummaryReport();
        testAddDuplicateSeries();
        testRemoveNonExistent();
        testGetProgressNonExistent();
        System.out.println("All tests passed!");
    }

    public static void testAddSeries() {
        MediaTracker mt = new MediaTracker1L();
        mt.addSeries("Naruto", MediaType.ANIME);
        assertTrue(mt.size() == 1);
        assertTrue(mt.containsSeries("Naruto"));
    }

    public static void testRemoveSeries() {
        MediaTracker mt = new MediaTracker1L();
        mt.addSeries("Naruto", MediaType.ANIME);
        mt.removeSeries("Naruto");
        assertTrue(mt.size() == 0);
        assertTrue(!mt.containsSeries("Naruto"));
    }

    public static void testUpdateProgress() {
        MediaTracker mt = new MediaTracker1L();
        mt.addSeries("Naruto", MediaType.ANIME);
        mt.updateProgress("Naruto", 50);
        assertTrue(mt.getProgress("Naruto") == 50);
    }

    public static void testSetStatus() {
        MediaTracker mt = new MediaTracker1L();
        mt.addSeries("Naruto", MediaType.ANIME);
        mt.setStatus("Naruto", Status.IN_PROGRESS);
        assertTrue(mt.countByStatus(Status.IN_PROGRESS) == 1);
    }

    public static void testCountByType() {
        MediaTracker mt = new MediaTracker1L();
        mt.addSeries("Naruto", MediaType.ANIME);
        mt.addSeries("One Piece", MediaType.ANIME);
        mt.addSeries("Berserk", MediaType.MANGA);
        assertTrue(mt.countByType(MediaType.ANIME) == 2);
        assertTrue(mt.countByType(MediaType.MANGA) == 1);
    }

    public static void testGenerateSummaryReport() {
        MediaTracker mt = new MediaTracker1L();
        mt.addSeries("Naruto", MediaType.ANIME);
        String report = mt.generateSummaryReport();
        assertTrue(report.contains("Naruto"));
        assertTrue(report.contains("ANIME"));
    }

    public static void testAddDuplicateSeries() {
        MediaTracker mt = new MediaTracker1L();
        mt.addSeries("Naruto", MediaType.ANIME);
        try {
            mt.addSeries("Naruto", MediaType.ANIME);
            assertTrue(false);
        } catch (IllegalStateException e) {
            // expected
        }
    }

    public static void testRemoveNonExistent() {
        MediaTracker mt = new MediaTracker1L();
        try {
            mt.removeSeries("Naruto");
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    public static void testGetProgressNonExistent() {
        MediaTracker mt = new MediaTracker1L();
        try {
            mt.getProgress("Naruto");
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    private static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError();
        }
    }
}