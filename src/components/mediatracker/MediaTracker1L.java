package components.mediatracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Kernel implementation using list-backed representation.
 *
 * Convention: - entries is non-null - each SeriesEntry.title and
 * SeriesEntry.type are non-null, non-empty - each SeriesEntry.progress >= 0 -
 * each SeriesEntry.status is non-null, non-empty - titles are unique
 *
 * Correspondence: - this <-> sequence of entries with order preserved - index i
 * corresponds to entries.get(i)
 */
public class MediaTracker1L extends MediaTrackerSecondary {

    private final List<SeriesEntry> entries;

    public MediaTracker1L() {
        this.entries = new ArrayList<>();
    }

    private int checkIndex(int index) {
        if (index < 0 || index >= this.entries.size()) {
            throw new IndexOutOfBoundsException("index out of range: " + index);
        }
        return index;
    }

    @Override
    public void addSeries(String title, String type) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be null or empty");
        }
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("type cannot be null or empty");
        }
        if (this.indexOf(title) >= 0) {
            throw new IllegalStateException("Series already exists: " + title);
        }
        this.entries.add(new SeriesEntry(title, type));
    }

    @Override
    public void removeSeries(String title) {
        int index = this.indexOf(title);
        if (index < 0) {
            throw new IllegalArgumentException("No such series: " + title);
        }
        this.entries.remove(index);
    }

    @Override
    public void updateProgress(String title, int progress) {
        if (progress < 0) {
            throw new IllegalArgumentException("progress must be non-negative");
        }
        int index = this.indexOf(title);
        if (index < 0) {
            throw new IllegalArgumentException("No such series: " + title);
        }
        this.entries.get(index).progress = progress;
    }

    @Override
    public void setStatus(String title, String status) {
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException(
                    "status cannot be null or empty");
        }
        int index = this.indexOf(title);
        if (index < 0) {
            throw new IllegalArgumentException("No such series: " + title);
        }
        this.entries.get(index).status = status;
    }

    @Override
    public int size() {
        return this.entries.size();
    }

    @Override
    public int indexOf(String title) {
        if (title == null) {
            throw new IllegalArgumentException("title cannot be null");
        }
        for (int i = 0; i < this.entries.size(); i++) {
            if (title.equals(this.entries.get(i).title)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String getTitle(int index) {
        this.checkIndex(index);
        return this.entries.get(index).title;
    }

    @Override
    public String getType(int index) {
        this.checkIndex(index);
        return this.entries.get(index).type;
    }

    @Override
    public int getProgress(int index) {
        this.checkIndex(index);
        return this.entries.get(index).progress;
    }

    @Override
    public String getStatus(int index) {
        this.checkIndex(index);
        return this.entries.get(index).status;
    }

    @Override
    public void clear() {
        this.entries.clear();
    }

    @Override
    public void transferFrom(MediaTracker source) {
        if (source == null) {
            throw new IllegalArgumentException("source cannot be null");
        }
        if (source == this) {
            return;
        }
        if (!(source instanceof MediaTracker1L)) {
            throw new IllegalArgumentException(
                    "unexpected implementation type");
        }
        MediaTracker1L other = (MediaTracker1L) source;
        this.entries.clear();
        this.entries.addAll(other.entries);
        other.clear();
    }

    @Override
    public MediaTracker newInstance() {
        return new MediaTracker1L();
    }

    private static final class SeriesEntry {
        final String title;
        final String type;
        int progress;
        String status;

        SeriesEntry(String title, String type) {
            this.title = title;
            this.type = type;
            this.progress = 0;
            this.status = "Planning";
        }
    }
}
