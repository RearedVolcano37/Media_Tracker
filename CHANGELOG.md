# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2026.04.05

### Added (2026.04.05)

- Comprehensive unit tests in `test/components/mediatracker/MediaTrackerTest.java`
- Sample applications: `AnimeTrackerSample.java` and `MangaTrackerSample.java`
- Maven build configuration (`pom.xml`)
- Updated README with usage examples and API documentation

### Changed (2026.04.05)

- Migrated interfaces to use enum-based types (MediaType, Status) instead of strings
- Updated implementations to be consistent with enum usage
- Fixed package structure and imports

### Fixed (2026.04.05)

- Resolved compilation errors and type inconsistencies
- Aligned kernel and enhanced interfaces

## 2026.04.03

### Added (2026.04.03)

- Implemented kernel, secondary, and enhanced classes for `MediaTracker` component: `MediaTrackerKernel`, `MediaTracker`, `MediaTrackerSecondary`, `MediaTracker1L`, and `Standard`

## 2026.04.01

### Added (2026.04.01)

- Implemented `MediaTrackerSecondary` abstract class in `src/components/mediatracker`
- Added `MediaTrackerKernel`, `MediaTracker`, and `MediaTracker1L` to complete component stack
- Implemented secondary methods (`containsSeries`, `markCompleted`, `countByStatus`, `countByType`, `generateSummaryReport`) and common methods (`toString`, `equals`, `hashCode`)

### Updated (2026.04.01)

- Refined MediaTracker design after proof-of-concept implementation

## 2026.03.10

### Added (2026.03.10)

- Designed `MediaTrackerKernel` interface with minimal operations
- Designed `MediaTracker` enhanced interface with secondary methods

### Updated (2026.03.10)

- Refined MediaTracker design after proof-of-concept implementation

## 2026.02.06

### Added (2026.02.06)

- Designed a `MediaTracker` component for tracking manga, manhua, webtoons, and anime
- Designed a `Playlist` component for storing and managing songs in an ordered playlist
- Designed a `GameLibrary` component for tracking video games, platforms, and completion status
