package components.mediatracker;

import java.util.Objects;

/**
 * OSU secondary abstract class for MediaTracker.
 */
public abstract class MediaTrackerSecondary implements MediaTracker {

    /**
     * @throws IllegalArgumentException
     *             if title is null or blank
     */
    protected void checkTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be null or empty");
        }
    }

    /**
     * @throws IllegalArgumentException
     *             if title does not exist
     */
    protected void checkExists(String title) {
        this.checkTitle(title);
        if (!this.containsSeries(title)) {
            throw new IllegalArgumentException("No such series: " + title);
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
            report.append(String.format(
                    "%d. %s (%s) - progress=%d, status=%s\n", i + 1,
                    this.getTitle(i), this.getType(i), this.getProgress(i), this.getStatus(i)));
        }
        return report.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MediaTracker[");
        for (int i = 0; i < this.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(this.getTitle(i)).append(" (").append(this.getType(i)).append(",")
                    .append(this.getProgress(i)).append("@").append(this.getStatus(i))
                    .append(")");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MediaTracker)) {
            return false;
        }
        MediaTracker that = (MediaTracker) o;
        if (this.size() != that.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (!Objects.equals(this.getTitle(i), that.getTitle(i))) {
                return false;
            }
            if (!Objects.equals(this.getType(i), that.getType(i))) {
                return false;
            }
            if (this.getProgress(i) != that.getProgress(i)) {
                return false;
            }
            if (!Objects.equals(this.getStatus(i), that.getStatus(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < this.size(); i++) {
            result = 31 * result + this.getTitle(i).hashCode();
            result = 31 * result + this.getType(i).hashCode();
            result = 31 * result + Integer.hashCode(this.getProgress(i));
            result = 31 * result + this.getStatus(i).hashCode();
        }
        return result;
    }
}
