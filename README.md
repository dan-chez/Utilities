## Common Utilities Library
[![](https://jitpack.io/v/dan-chez/Utilities.svg)](https://jitpack.io/#dan-chez/Utilities)

This library contains basic functions and extensions for any Android project. It is developed in Kotlin.

##### Config:
* minSdk 26
* targetSdk 31
* Kotlin version 1.5.20

## Implementation
This library is published on [Jitpack.io](https://jitpack.io "Jitpack.io URL"). To implement it you must do the following:

1. Add Jitpack.io in your root build.gradle at the end of repositories
```gradle
allprojects {
  repositories {
    ...
    maven {
      url 'https://jitpack.io' 
    }
  }
}
```
2. Add the dependency
```gradle
dependencies {
    ...
    implementation 'com.github.dan-chez:Utilities:version'
    ...
}
```
