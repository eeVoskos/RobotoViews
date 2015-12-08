RobotoViews
===========

### Deprecation
This library is deprecated. Thank you for using it! You can go ahead to use more feature-complete libraries like [Calligraphy](https://github.com/chrisjenx/Calligraphy), or modern techniques like [font binding](https://github.com/lisawray/fontbinding).

RobotoViews is an Android library hosting a collection of Views that use the
[Roboto][1] font, including the newest member of the family, Roboto Slab.
The current version includes the following views:
- `RobotoTextView`
- `RobotoButton`
- `RobotoEditText`
- `RobotoAutoCompleteTextView`
- `RobotoCheckBox`
- `RobotoRadioButton`
- `RobotoToggleButton`
- `RobotoCheckedTextView`
- `RobotoSwitch` (Android 4.0+)

Usage
=====

Maven
--
```
dependency>
  <groupId>com.eevoskos</groupId>
  <artifactId>robotoviews</artifactId>
  <version>1.0.0-SNAPSHOT</version>
  <type>aar</type>
</dependency>
```
Gradle
---
```
compile 'com.eevoskos:robotoviews:1.0.+@aar'
```
Eclipse Library Project
---
Download the project, import it in Eclipse as an Android library project and reference it in your project.

----
Then simply add Roboto views programmatically or in your xml layouts like this:
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:roboto="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >

    <com.eevoskos.robotoviews.widget.RobotoTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Roboto Regular"
        roboto:typeface="regular" />

</LinearLayout>
```
You can set the ```typeface``` attribute to any of the following available values:
```
regular
bold
italic
bold_italic
black
black_italic
condensed
condensed_bold
condensed_italic
condensed_bold_italic
light
light_italic
medium
medium_italic
thin
thin_italic
slab_regular
slab_bold
slab_light
slab_thin
```

The loading of the typefaces is handled by the library. The typefaces are lazily loaded
from the resources when necessary  and kept in memory for future use at runtime.

Sample
======
The library includes a sample application (in the ```/sample``` folder) that demonstrates how the views look like.
This is an example of the ```RobotoTextView``` using all available typefaces:

![Example image from the RobotoTextView Sample][2]

Developed By
============
Stratos Theodorou - <eeVoskos@gmail.com>

License
=======

    Copyright 2013 Stratos Theodorou

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]: http://developer.android.com/design/style/typography.html
[2]: /art/sample_textview.png
