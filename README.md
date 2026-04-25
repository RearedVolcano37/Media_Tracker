# MediaTracker

MediaTracker is a lightweight OSU CSE component for tracking progress and status across media series.
It is designed as a course-style Java component with interface-driven behavior and a list-backed concrete implementation.

## Build Requirements

- Java 21 or higher
- Maven 3.9 or higher

## Project Layout

- `src/main/java/` - main component implementation
- `src/test/java/` - unit tests
- `samples/` - example applications
- `doc/` - development notes and design documents

## Build

```bash
mvn clean compile
```

## Test

```bash
mvn clean test
```

## Running Samples

Compile sample applications after building the project:

```bash
javac -cp target/classes samples/*.java
```

Run the anime sample on Windows:

```powershell
java -cp target/classes;samples AnimeTrackerSample
```

Run the manga sample on Windows:

```powershell
java -cp target/classes;samples MangaTrackerSample
```

## Component Overview

The component follows a simple OSU CSE style:

- `MediaTrackerKernel` defines the kernel contract
- `MediaTracker` extends the kernel with secondary operations
- `MediaTrackerSecondary` centralizes common code
- `MediaTracker1L` provides a concrete list-based implementation

## Use Cases

The MediaTracker component is designed to track progress and status of various media series. Two qualitatively different use cases are provided:

### 1. Anime Tracking (Simple Use Case)

The `AnimeTrackerSample` demonstrates basic usage for tracking anime series. It shows adding series, updating progress, setting statuses, and generating reports. This use case focuses on a single media type (anime) and basic operations, suitable for users who want straightforward tracking.

### 2. Multi-Media Library (Advanced Use Case)

The `MangaTrackerSample` showcases advanced features including multiple media types (manga, webtoons, light novels) and comprehensive status management. It demonstrates counting by type and status, making it ideal for users managing diverse media collections with different completion states.

Both samples illustrate the component's flexibility for different user needs, from simple personal tracking to complex library management.

## Testing

The component includes comprehensive unit tests in `MediaTrackerTest.java` that cover:

- All kernel methods: addSeries, removeSeries, updateProgress, setStatus, size, indexOf, getTitle, getType, getStatus, getProgressValue, generateSummaryReport
- All secondary methods: containsSeries, getProgress, countByStatus, countByType
- All media types: MANGA, MANHUA, WEBTOON, ANIME, LIGHTNOVEL
- All statuses: PLANNING, IN_PROGRESS, COMPLETED, DROPPED
- Edge cases: empty tracker, duplicate additions, non-existent operations
- Exception handling: IllegalStateException for duplicates, IllegalArgumentException for invalid operations
- Multiple operations and state consistency

Run tests with `mvn clean test` to ensure all functionality works correctly.

## Notes

- This project is self-contained and does not require external JARs in `lib/`.
- Use `mvn clean test` to verify the component and its unit tests.
