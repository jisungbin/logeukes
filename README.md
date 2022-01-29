## Logeukes

✨ Powerful Android logcat ✨

All types are supported, and tags are automatically created with class names when tags are omitted.

## Preview

![](https://raw.githubusercontent.com/sungbin5304/PrettyLogger/master/images/PrettyLogger.png)

---

## Download [![](https://img.shields.io/maven-central/v/land.sungbin/logeukes)](https://search.maven.org/artifact/land.sungbin/logeukes) ![](https://img.shields.io/badge/API-1%2B-brightgreen.svg)

```groovy
implementation "land.sungbin:logeukes:${version}"
```

## Usage

```kotlin
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) { // Enable logging only in debug
            Logeukes.setup()
        }
    }
}
```

```kotlin
logeukes { "HI" }

- logeukes(tag: String = getClassName(), type: LoggerType = LoggerType.D, content: () -> Any?)
- enum class LoggerType { W, V, D, E, I }
```

---

## Happy Coding :)
