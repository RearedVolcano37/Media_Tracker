# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2026.04.03

### Added

- Implemented kernel, secondary, and enhanced classes for `MediaTracker` component: `MediaTrackerKernel`, `MediaTracker`, `MediaTrackerSecondary`, `MediaTracker1L`, and `Standard`

## 2026.04.01

### Added

- Implemented `MediaTrackerSecondary` abstract class in `src/components/mediatracker`
- Added `MediaTrackerKernel`, `MediaTracker`, and `MediaTracker1L` to complete component stack
- Implemented secondary methods (`containsSeries`, `markCompleted`, `countByStatus`, `countByType`, `generateSummaryReport`) and common methods (`toString`, `equals`, `hashCode`)

## 2026.03.10

### Added

- Designed `MediaTrackerKernel` interface with minimal operations
- Designed `MediaTracker` enhanced interface with secondary methods

### Updated

- Refined MediaTracker design after proof-of-concept implementation

## 2026.02.06

### Added

- Designed a `MediaTracker` component for tracking manga, manhua, webtoons, and anime
- Designed a `Playlist` component for storing and managing songs in an ordered playlist
- Designed a `GameLibrary` component for tracking video games, platforms, and completion status
