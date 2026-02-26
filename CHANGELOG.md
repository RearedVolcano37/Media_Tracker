# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2026.02.26

## Added

- Implamented MediaTrackerMVP proof-of-concept Java file
- Added internal SeriesEntry representation using a HashMap
- Implemented core methods: addSeries, removeSeries, updateProgress, getStatus, and size
- Implemented secondary/query methods: containsSeries, getProgress, countByStatus, countByType
- Added generateSummaryReport method for basic reporting
- Included main method demonstrating component functionality in action

## 2026.02.06

### Added

- Designed a `MediaTracker` component for tracking manga, manhua, webtoons, and anime
- Designed a `Playlist` component for storing and managing songs in an ordered playlist
- Designed a `GameLibrary` component for tracking video games, platforms, and completion status