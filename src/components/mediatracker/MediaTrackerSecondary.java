package components.mediatracker;

/**
 * Abstract secondary implementation for {@code MediaTracker}.
 *
 * Secondary methods are implemented using only kernel operations.
 */
public abstract class MediaTrackerSecondary implements MediaTracker {

    private void checkTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be null or empty");
        }
    }

    private void checkExists(String title) {
        this.checkTitle(title);
        if (!this.containsSeries(title)) {
            throw new IllegalArgumentException("series not found: " + title);
        }
    }

    @Override
    public boolean containsSeries(String title) {
        this.checkTitle(title);
        return this.indexOf(title) >= 0;
    }

    @Override
    public String getSeriesType(String title) {
        this.checkExists(title);
        return this.getType(this.indexOf(title));
    }

    @Override
    public int getSeriesProgress(String title) {
        this.checkExists(title);
        return this.getProgress(this.indexOf(title));
    }

    @Override
    public String getSeriesStatus(String title) {
        this.checkExists(title);
        return this.getStatus(this.indexOf(title));
    }

    @Override
    public void markCompleted(String title) {
        this.checkExists(title);
        this.setStatus(title, "Completed");
    }

    @Override
    public int countByStatus(String status) {
        if (status == null) {
            throw new IllegalArgumentException("status cannot be null");
        }
        int count = 0;
        for (int i = 0; i < this.size(); i++) {
            if (status.equals(this.getStatus(i))) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int countByType(String type) {
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        int count = 0;
        for (int i = 0; i < this.size(); i++) {
            if (type.equals(this.getType(i))) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String generateSummaryReport() {
        StringBuilder report = new StringBuilder();
        report.append("MediaTracker Report\n");
        report.append("Total series: ").append(this.size()).append("\n");

        for (int i = 0; i < this.size(); i++) {
            report.append(
                    String.format("%d. %s (%s) - progress=%d, status=%s\n",
                            i + 1, this.getTitle(i), this.getType(i),
                            this.getProgress(i), this.getStatus(i)));
        }

        return report.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MediaTracker[");
        for (int i = 0; i < this.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(this.getTitle(i)).append(" (").append(this.getType(i))
                    .append(", ").append(this.getProgress(i)).append("@")
                    .append(this.getStatus(i)).append(")");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaTracker)) {
            return false;
        }
        MediaTracker o = (MediaTracker) obj;
        if (this.size() != o.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (!this.getTitle(i).equals(o.getTitle(i))) {
                return false;
            }
            if (!this.getType(i).equals(o.getType(i))) {
                return false;
            }
            if (this.getProgress(i) != o.getProgress(i)) {
                return false;
            }
            if (!this.getStatus(i).equals(o.getStatus(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int value = 1;
        for (int i = 0; i < this.size(); i++) {
            value = 31 * value + this.getTitle(i).hashCode();
            value = 31 * value + this.getType(i).hashCode();
            value = 31 * value + Integer.hashCode(this.getProgress(i));
            value = 31 * value + this.getStatus(i).hashCode();
        }
        return value;
    }

}
