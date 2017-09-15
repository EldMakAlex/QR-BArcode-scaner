Introduction
============

# QR-BArcode-scaner
QR code, Barcode scaner

Hi, it's first my project on android

Реализован простой сканер штрих-кодов для андроид на kotlin.
Не судите строго, это не полноценное приложение, а пример  реализации 
сканера штрих-кодов на языке kotlin с использованием библиотеки ZXing

ZXing
=====

Installation
------------

Add the following dependency to your build.gradle file.

`compile 'me.dm7.barcodescanner:zxing:1.9.8'`

Simple Usage
------------

1.) Add camera permission to your AndroidManifest.xml file:

```xml
<uses-permission android:name="android.permission.CAMERA" />
```

Credits
=======

Almost all of the code for these library projects is based on:

1. CameraPreview app from Android SDK APIDemos
2. The ZXing project: https://github.com/zxing/zxing
3. Java project ZXing https://github.com/dm77/barcodescanner

License
=======
Apache License, Version 2.0
