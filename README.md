# Logger
Very simple class for logging to a text file. I use it for Android applications but you can use it for whatever, idc.

## Android Setup

```java
String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/pick_a_path";
File dir = new File(path);
dir.mkdir();
File file = new File(path + "/log.txt");
Logger log = new Logger(file);
```

Add to AndroidManifest.xml
```xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
```

ezpz.

You can then create logs with

```java
log.write("Set factory defaults button pressed!");
```

The log will output in /pick_a_path/log.txt. Below is what it will look like.

> [2018-05-20 14:21:38] - Set factory defaults button pressed!

> [2018-05-20 14:22:03] - Device has been disconnected!

> [2018-05-20 14:22:58] - New device has been connected!
