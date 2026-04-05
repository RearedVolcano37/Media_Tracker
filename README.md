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

## Notes

- This project is self-contained and does not require external JARs in `lib/`.
- Use `mvn clean test` to verify the component and its unit tests.
