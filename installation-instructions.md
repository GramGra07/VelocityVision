# Installation Instructions

#### Adding it to your project <a href="#adding-it-to-your-project" id="adding-it-to-your-project"></a>

In your `build.gradle` file in the TeamCode module, add the following line to the dependencies:

Copy

```
dependencies {
    implementation 'com.github.GramGra07:VelocityVision:version'
}
```

Replace version with the latest version here : [https://jitpack.io/#GramGra07/VelocityVision](https://jitpack.io/#GramGra07/VelocityVision)

In your `build.dependencies.gradle` file, add the following to the repositories:

Copy

```
repositories {
    maven {url = 'https://jitpack.io'}
}
```

Inside your `build.common.gradle` file, add the following to your packaging options:

Copy

```
packagingOptions {
    exclude 'META-INF/LICENSE-notice.md'
    exclude 'META-INF/LICENSE.md'
}
```
