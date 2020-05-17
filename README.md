# simple-selenium

simple-selenium is a gradle project meant to illustrate basic usage of Selenium Web Driver for programmatically controlling a browser.  Some of what's illustrated:

* Usage of the chrome web driver
* Running the web driver via unit tests
    * Three unit tests - each test performs a different Amazon search and clicks on one of the product images
* Telling gradle to set a given system property before running the tests
* Telling gradle to always run the tests regardless of whether or not the code has changed

## Usage

Clone the repository and execute the following.  It should choose the correct driver for your operating system but I have only tested Windows.  Also note that you have to have Chrome version 81 installed as the driver is specific to that version.  Selenium has other driver options worth checking out.

```
./gradlew test
```

## License
[MIT](https://choosealicense.com/licenses/mit/)