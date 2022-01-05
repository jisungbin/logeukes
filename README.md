# Logeukes

✨ Powerful Android logcat ✨

**All types are supported**, and tags are automatically created with class names when tags are omitted.

---

# Preview

![](https://raw.githubusercontent.com/sungbin5304/PrettyLogger/master/images/PrettyLogger.png)

# Usage

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

# Download [![](https://img.shields.io/maven-central/v/io.github.jisungbin/logeukes)](https://search.maven.org/artifact/io.github.jisungbin/logeukes)

```groovy
implementation "io.github.jisungbin:logeukes:${version}"
```

---

# Happy Coding :)
