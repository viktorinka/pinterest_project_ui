<h1 align="center"> Demo project to automate UI testing for service <a href="https://www.pinterest.com">Pinterest</h1>
<div align="center">
  <a href="https://www.pinterest.com"><img alt="Pinterest" src="media/Pinterest_Logo.svg.png"></a>
</div>
  
> Pinterest is social Internet service, photo hosting, allowing users to add images online, place them in thematic collections and share them with other users.

# :open_file_folder: <a name="TableOfContents">Table of contents</a>

+ [Description](#Description)
+ [Tools and technologies](#Technology)
+ [How to run](#HowToRun)
+ [Test results report in Allure Report](#AllureReport)
+ [Allure TestOps integration](#AllureTestOps)
    + [Project in Allure TestOps](#AllureTestOpsProject)
    + [Start a run of custom set of tests](#AllureTestOpsStartTests)
    + [Dashboards](#Dashboards)
    + [Defects](#Defects)
+ [Jira integration](#Jira)
+ [Telegram Notifications](#TelegramNotifications)
+ [Video of running tests](#Video)

# :bulb: <a name="Description">Description</a>
The test project consists of Web, API and mobile(android) tests.\
A brief list of interesting facts about the project:
- [x] `Page Object` with steps using `Chain of Invocations`
- [x] Fake data generating with `Faker` library
- [x] Parametrized tests
- [x] Parametrized build
- [x] Different configuration files for test running depending on build parameters
- [x] Config with `Owner` library
- [x] Using `Lombok` for models for API tests
- [x] Objects serialization/deserialization for API requests/responses using `Jackson`
- [x] Using request/response specifications for API tests
- [x] Custom Allure listener for beautiful API requests/responses logging
- [x] `Allure TestOps` integration
- [x] Autotests as test documentation
- [x] `Github webhooks` on each push to trigger `Jenkins` build
- [x] `Jira` integration
- [x] Parallel execution

# :technologist: <a name="Technology">Tools and a technologies</a>
<p  align="center">
  <code><img width="5%" title="IntelliJ IDEA" src="media/IDEA-logo.svg"></code>
  <code><img width="5%" title="Java" src="media/java-original-wordmark.svg"></code>
  <code><img width="5%" title="Selenide" src="media/selenide-logo.svg"></code>
  <code><img width="5%" title="REST-Assured" src="media/rest-assured-logo.svg"></code>
  <code><img width="5%" title="Selenoid" src="media/selenoid-logo.svg"></code>
  <code><img width="5%" title="Gradle" src="media/gradle-logo.svg"></code>
  <code><img width="5%" title="JUnit5" src="media/junit5-logo.svg"></code>
  <code><img width="5%" title="Allure Report" src="media/allure-Report-logo.svg"></code>
  <code><img width="5%" title="Allure TestOps" src="media/allure-ee-logo.svg"></code>
  <code><img width="5%" title="Github" src="media/git-logo.svg"></code>
  <code><img width="5%" title="Jenkins" src="media/jenkins-logo.svg"></code>
  <code><img width="5%" title="Jira" src="media/jira-logo.svg"></code>
  <code><img width="5%" title="Telegram" src="media/Telegram.svg"></code>
  <code><img width="5%" title="Browserstack" src="media/browserstack.svg"></code>
  <code><img width="5%" title="Android Studio" src="media/android.svg"></code>
  <code><img width="5%" title="Appium" src="media/appium.svg"></code>
</p>

The autotests in this project are written in `Java` using `Selenide` framework.\
`Gradle` - is used as a build automation tool.  \
`JUnit5` - to execute tests.\
`REST Assured` - for easy API testing of REST services.\
`Jenkins` - CI/CD for running tests remotely.\
`Selenoid` - to remote launching browsers in `Docker` containers.\
`Browserstack` - to run mobile tests.\
`Android Studio tools`, `Appium` - to tun mobile tests locally in a mobile device emulator.\
`Allure Report` - for test results visualisation.\
`Telegram Bot` - for test results notifications.\
`Allure TestOps` - as Test Management System.

# :computer: <a name="HowToRun">How to run</a>

### Local running tests

```bash
gradle clean test
```

### Remote running tests

```bash
gradle clean test
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-Dremote=${SERVER_REMOTE}
```
### <img width="5%" src="media/jenkins-logo.svg"> Running tests in [Jenkins](https://jenkins.autotests.cloud/job/pinterest_project_ui/)

First you need to click on the <code><strong>*Collect with parameters*</strong></code> button and set options. By clicking on the <code><strong>*Collect*</strong></code> button a build will be started.

<p align="center">
  <img src="media/job-jenkins.png" alt="Jenkins" width="800">
</p>

After build is completed, in the <code><strong>*Builds history*</strong></code> opposite the build number will appear
the *Allure Report* icon, clicking on which will open the page with the generated html-report.

## <img width="5%" src="media/allure-Report-logo.svg"> <a name="Allure Report">Test results report in [Allure Report](https://jenkins.autotests.cloud/job/pinterest_project_ui/19/allure/)</a>

<p align="center">
  <img src="media/allure-report_1.png" alt="allure-report1" width="900">
</p>
<p align="center">
  <img src="media/allure-report_2.png" alt="allure-report1" width="900">
</p>

## <img width="5%" title="Allure TestOPS" src="media/allure-ee-logo.svg"> Integration with [Allure TestOps](https://allure.autotests.cloud/launch/35037)

### Main dashboard

<p align="center">
  <img src="media/allure-tops_2.png" alt="dashboard" width="900">
</p>

### Test results

<p align="center">
  <img src="media/allure-tops_1.png" alt="testresults" width="900">
</p>

## <img width="5%" title="Jira" src="media/jira-logo.svg"> Integration with [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1089)

<p align="center">
  <img src="media/jira.png" alt="jira" width="900">
</p>

## <img width="5%" title="Telegram" src="media/Telegram.svg"> Telegram notifications using a bot
After the build is completed, a special bot created in <code>Telegram</code>, automatically processes and sends a test run report message.

<p align="center">
<img title="Telegram Notifications" src="media/telegram.png">
</p>

## <img width="5%" title="Selenoid" src="media/selenoid-logo.svg"> Test running example in Selenoid

A video is attached to each test in the report.

<p align="center">
  <img title="Selenoid Video" src="media/video.gif">
</p>
