# Safe Path

---
## Overview
The concern for student safety on college campuses has always been present. In particular, the concern that students have in regards to their own safety when walking to a destination on campus. My proposed thesis is to create an app that students can use to find the safest walking route when traveling on campus and around the college town. 

The main focus and the motivation of this thesis is exploring the user’s experience and the many ways to improve it. The goal of the app is to be easy to use, free of any ambiguity, and above all, helpful to the student body in a way that makes them feel safe when navigating around campus regardless of the time of day.


---
## Installation
##### Android Studio
1. Download and install Android Studio and import the files in this repo. 

2. In Android Studio be sure to select and install an emulator to run the program on. The program currently runs using Pixel_3a_API_30_x86 .

3. For more help setting up the emulator (or AVD, Android Virtual Device) visit [here].

4. You must also set up an API key from Google. Once created, open the program in Android studio and paste the following code in the following destination: 

    Destination: App > src > res> values> map_api

    `<?xml version="1.0" encoding="utf-8"?>
    <resources>
     <string name="map_key" translatable="false">
    API KEY GOES HERE
    </string>
    </resources>`


##### Database
1. To connect the database to your localhost, download XAMPP, go into the folder "xampp" (wherever you installed it), and then go into htdocs file. Finally copy and paste the files from this [php repo].


2. When running the program, make sure that Apache and MySQL are running. This can be accomplished by opening the XAMPP control panel and selecting Start for both the Apache and MySQL module.

 
 ---
 ## Further Development
 Despite what was achieved, there is still much work to be done on the app itself. Firstly, I was unable to create an algorithm that will generate a rating based on users’ answers to questions in regards to how safe they felt when walking to a destination. Secondly, I was unable to create a criteria to determine what makes a particular area more dangerous than another without being disparaging. Lastly, there are still several pieces of the app which need to be connected to the database in order for it to run as it should. 
 
 
 
 
 
 
 
 [php repo]: <https://github.com/luofoapp/php>
 [here]: < https://developer.android.com/studio/run/managing-avds>
 
