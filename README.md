# Logeukes

android logcat

---

# Preview

![](https://raw.githubusercontent.com/sungbin5304/PrettyLogger/master/images/PrettyLogger.png)

# Usage

```kotlin
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
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
