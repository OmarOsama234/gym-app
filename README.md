# Gym Tracker Android Application

A comprehensive fitness tracking Android application built with Kotlin and Android Architecture Components.

## 🏋️‍♂️ Features Implemented

### 📊 Dashboard (Home)
- **Welcome Section**: Personalized greeting with motivational messaging
- **Statistics Cards**: Real-time display of workout statistics including:
  - Total workouts completed
  - Workouts completed this week
- **Quick Start**: One-tap button to begin a new workout session
- **Workout Templates**: Scrollable list of pre-defined workout plans with:
  - Template name and description
  - Estimated duration
  - Difficulty level (Beginner, Intermediate, Advanced)
  - Exercise count

### 🏃‍♂️ Exercise Library (Exercises)
- **Search Functionality**: Real-time search through exercise database
- **Filter System**: Muscle group filtering with interactive chips:
  - All exercises
  - Chest
  - Back
  - Quadriceps
  - Shoulders
  - Biceps
- **Exercise Cards**: Detailed exercise information including:
  - Exercise name and description
  - Target muscle groups
  - Required equipment
  - Visual appeal with Material Design cards

### 📈 Progress Tracking (Progress)
- **Statistics Grid**: Comprehensive workout analytics:
  - Total workouts completed
  - Weekly workout count
  - Monthly workout count
  - Average workout duration
- **Recent Workouts**: Timeline of latest workout sessions with:
  - Workout name and date
  - Duration and exercise count
  - Empty state handling for new users

## 🛠️ Technical Architecture

### Data Models
- **Exercise**: Represents individual exercises with instructions
- **Workout**: Complete workout sessions with exercises and metadata
- **WorkoutSet**: Individual sets within exercises (reps, weight, rest time)
- **WorkoutTemplate**: Pre-defined workout plans

### Repository Pattern
- **GymRepository**: Centralized data management with sample data
- Pre-populated with realistic exercises and workout templates
- Methods for filtering, searching, and data retrieval

### UI Components
- **Material Design**: Modern UI following Material Design principles
- **RecyclerView Adapters**: 
  - WorkoutTemplateAdapter
  - ExerciseAdapter
  - WorkoutAdapter
- **ViewBinding**: Type-safe view binding throughout the application
- **Navigation Drawer**: Intuitive navigation between main sections

### Architecture Components
- **MVVM Pattern**: Clean separation of concerns
- **LiveData**: Reactive UI updates
- **ViewModel**: Lifecycle-aware data handling
- **Fragment-based Navigation**: Modular UI components

## 📱 User Interface

### Design Principles
- **Material Design 3**: Modern, accessible design language
- **Card-based Layout**: Information organized in digestible cards
- **Responsive Design**: Adapts to different screen sizes
- **Color Scheme**: Purple-based theme for fitness motivation

### Navigation
- **Navigation Drawer**: Easy access to main features
  - Dashboard
  - Exercises
  - Progress
- **Intuitive Icons**: Clear visual indicators for each section

## 🚀 Getting Started

### Prerequisites
- Android Studio Arctic Fox or newer
- Android SDK 24 (Android 7.0) or higher
- Kotlin 1.8+

### Installation
1. Clone the repository
2. Open in Android Studio
3. Sync project with Gradle files
4. Configure Android SDK path
5. Run the application

### Build Configuration
- **Target SDK**: 36 (Android 14)
- **Minimum SDK**: 24 (Android 7.0)
- **Compile SDK**: 36
- **Build Tools**: Gradle 8.13

## 📋 Sample Data

The application comes pre-loaded with:

### Exercises (5 exercises)
- **Push-ups**: Bodyweight chest exercise
- **Squats**: Lower body strength builder
- **Bench Press**: Classic chest exercise with barbell
- **Deadlifts**: Full body compound movement
- **Pull-ups**: Upper body pulling exercise

### Workout Templates (3 templates)
- **Upper Body Strength**: 45-min intermediate workout
- **Lower Body Power**: 30-min beginner workout
- **Full Body Workout**: 60-min advanced workout

## 🔧 Dependencies

### Core Android Libraries
- AndroidX Core KTX
- AppCompat
- Material Design Components
- ConstraintLayout
- Navigation Component

### Architecture Components
- Lifecycle (LiveData & ViewModel)
- Navigation Fragment & UI

### Testing
- JUnit for unit testing
- Espresso for UI testing

## 🎯 Future Enhancements

### Planned Features
- [ ] Workout session tracking with timer
- [ ] Exercise instruction details page
- [ ] Custom workout creation
- [ ] Progress charts and analytics
- [ ] Personal records tracking
- [ ] Exercise video demonstrations
- [ ] Social sharing capabilities
- [ ] Offline data persistence with Room database
- [ ] User authentication
- [ ] Cloud data synchronization

### Technical Improvements
- [ ] Room database integration
- [ ] Retrofit for API connectivity
- [ ] Dagger/Hilt dependency injection
- [ ] Compose UI migration
- [ ] Unit test coverage expansion
- [ ] CI/CD pipeline setup

## 📖 Usage Guide

### Dashboard Usage
1. View your workout statistics at a glance
2. Tap "Start Workout" for quick session start
3. Browse and select from available workout templates
4. Track your progress with real-time statistics

### Exercise Library
1. Use the search bar to find specific exercises
2. Filter by muscle group using the chip filters
3. Tap on exercises to view detailed information
4. Browse the comprehensive exercise database

### Progress Tracking
1. Monitor your workout frequency and consistency
2. View recent workout history
3. Track average workout duration
4. Celebrate your fitness achievements

## 🤝 Contributing

This is a demonstration project showcasing Android development best practices and modern architecture patterns. The codebase demonstrates:
- Clean Architecture principles
- MVVM pattern implementation
- Material Design integration
- Reactive programming with LiveData
- Modern Android development practices

## 📄 License

This project is created for educational and demonstration purposes.

---

**Built with 💪 for fitness enthusiasts and Android developers**