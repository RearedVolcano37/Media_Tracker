# MediaTracker Component

A Java component for tracking progress and status of various media series including manga, anime, webtoons, and light novels.

## Overview

The MediaTracker component provides a comprehensive framework for managing collections of media series. It supports multiple media types and tracking statuses, allowing users to monitor their reading/watching progress.

## Features

- Track multiple media types: MANGA, MANHUA, WEBTOON, ANIME, LIGHTNOVEL
- Status management: PLANNING, IN_PROGRESS, COMPLETED, DROPPED
- Progress tracking with integer values
- Summary reports and statistics
- Type-safe enum-based API

## Architecture

The component follows the OSU software components pattern with:

- **MediaTrackerKernel**: Low-level kernel interface with basic operations
- **MediaTracker**: Enhanced interface with secondary methods
- **MediaTrackerSecondary**: Abstract implementation providing common functionality
- **MediaTracker1L**: Concrete implementation using list-based representation

## Usage

```java
import components.mediatracker.*;
import static components.mediatracker.MediaTrackerKernel.MediaType;
import static components.mediatracker.MediaTrackerKernel.Status;

MediaTracker tracker = new MediaTracker1L();

// Add a series
tracker.addSeries("Berserk", MediaType.MANGA);

// Update progress and status
tracker.updateProgress("Berserk", 350);
tracker.setStatus("Berserk", Status.IN_PROGRESS);

// Generate reports
System.out.println(tracker.generateSummaryReport());
System.out.println("Manga count: " + tracker.countByType(MediaType.MANGA));
```

## Building and Testing

### Prerequisites

- Java 11 or higher
- Maven (for dependency management)

### Build

```bash
mvn compile
```

### Test

```bash
mvn test
```

### Run Samples

```bash
# Compile samples
javac -cp "target/classes" samples/*.java

# Run anime sample
java -cp "target/classes:samples" AnimeTrackerSample

# Run manga sample
java -cp "target/classes:samples" MangaTrackerSample
```

## API Documentation

### MediaTrackerKernel

- `addSeries(String title, MediaType type)` - Add a new series
- `removeSeries(String title)` - Remove a series
- `updateProgress(String title, int progress)` - Update reading/watching progress
- `setStatus(String title, Status status)` - Set series status
- `size()` - Get number of tracked series

### MediaTracker (extends MediaTrackerKernel)

- `containsSeries(String title)` - Check if series exists
- `getProgress(String title)` - Get progress for a series
- `countByStatus(Status status)` - Count series by status
- `countByType(MediaType type)` - Count series by type
- `generateSummaryReport()` - Generate formatted report

## Samples

See the `samples/` directory for example applications:

- `AnimeTrackerSample.java` - Basic anime tracking
- `MangaTrackerSample.java` - Advanced multi-media tracking

## Testing

Comprehensive unit tests are provided in `test/components/mediatracker/MediaTrackerTest.java`.

Run tests with:
```bash
java -cp "src;test" components.mediatracker.MediaTrackerTest
```

## Contributing

This is a portfolio project for OSU CSE 2221. For questions or feedback, please contact the author.

## License

See LICENSE file for details.
Regardless, there is no mac support. As a result, I would just recommend
installing the latest JDK [directly from Oracle's site][jdk-downloads].

### Step 4: Add Key Libraries to Project

<!-- TODO: add key libraries to project and delete this comment -->

As you are probably all aware at this point, you need the components jar to get
anything running. My advice is to [download it from here][components-jar]. Then,
drop it into the `lib` folder in the project. Git automatically ignores anything
you put here by default, so don't worry about committing it to version control.

Similarly, you will need the testing APIs (e.g., JUnit). Perhaps the easiest way
to include them in your project is to click the beaker symbol in the left
sidebar; it's right below the extensions button which looks like four squares.
If you do not see this button, try creating a Java file in `src`. From there, 
you can click "Enable Java Tests" and then click "JUnit" from the
dropdown. That's it! You should now see the two JUnit libraries in the lib
folder.

**Note**: if you're using VSCode for class projects, you might be wondering
why you never had to do this. In general, it's bad practice to commit binaries
to version control. However, we have no way of managing dependencies with the
custom `components.jar`, so I included them directly in the template. I did not
include them here, so you could see how it might be done from scratch. If at any
point you're struggling with Step 3, just copy the lib folder from the monorepo
template.

## Next Steps

<!-- TODO: navigate to part 1 of the portfolio project and delete this comment -->

Now that you have everything setup, you can begin crafting your component. There
will be deadlines for each step in Carmen, but you're free to complete each step
as early as you'd like. To start, you'll want to visit the [doc](doc/) directory
for each assignment file.

[components-jar]: https://cse22x1.engineering.osu.edu/common/components.jar
[jdk-downloads]: https://www.oracle.com/java/technologies/downloads/
[use-this-template]: https://github.com/new?template_name=portfolio-project&template_owner=jrg94
