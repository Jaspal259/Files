$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Test1.feature");
formatter.feature({
  "line": 1,
  "name": "To test the fuctionality of Mercer Oneview application",
  "description": "",
  "id": "to-test-the-fuctionality-of-mercer-oneview-application",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "To test the fuctionality of Mercer Oneview application",
  "description": "",
  "id": "to-test-the-fuctionality-of-mercer-oneview-application;to-test-the-fuctionality-of-mercer-oneview-application",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Url is launched",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "User enters username and password",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Click on login button",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "User navigates to next and click on view details",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "again click on contact details to update information",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "click on Edit button",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "update information",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "click on Save button",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "click to select logout button",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "user will be logged out successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "mercerOneview.Test1()"
});
formatter.result({
  "duration": 8807971137,
  "status": "passed"
});
formatter.match({
  "location": "mercerOneview.Test2()"
});
formatter.result({
  "duration": 5102861542,
  "status": "passed"
});
formatter.match({
  "location": "mercerOneview.Test3()"
});
formatter.result({
  "duration": 6884494553,
  "status": "passed"
});
formatter.match({
  "location": "mercerOneview.Test4()"
});
formatter.result({
  "duration": 55252153116,
  "status": "passed"
});
formatter.match({
  "location": "mercerOneview.Test5()"
});
formatter.result({
  "duration": 1698004339,
  "status": "passed"
});
formatter.match({
  "location": "mercerOneview.Test6()"
});
formatter.result({
  "duration": 928733136,
  "status": "passed"
});
formatter.match({
  "location": "mercerOneview.Test7()"
});
formatter.result({
  "duration": 2198251756,
  "status": "passed"
});
formatter.match({
  "location": "mercerOneview.Test8()"
});
formatter.result({
  "duration": 2506231446,
  "status": "passed"
});
formatter.match({
  "location": "mercerOneview.Test9()"
});
formatter.result({
  "duration": 32902055066,
  "error_message": "java.lang.AssertionError: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//ul1[@class\u003d\u0027mos-c-dropdown__list\u0027]/li/a[@id\u003d\u0027LogoutLink\u0027]\"}\n  (Session info: chrome\u003d72.0.3626.109)\n  (Driver info: chromedriver\u003d72.0.3626.69 (3c16f8a135abc0d4da2dff33804db79b849a7c38),platform\u003dWindows NT 10.0.14393 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:25:53\u0027\nSystem info: host: \u0027INGGNED89DP882\u0027, ip: \u002710.197.131.45\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_60\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 72.0.3626.69 (3c16f8a135abc..., userDataDir: C:\\Users\\JASPAL~1\\AppData\\L...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:50488}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), rotatable: false, setWindowRect: true, takesHeapSnapshot: true, takesScreenshot: true, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unexpectedAlertBehaviour: ignore, unhandledPromptBehavior: ignore, version: 72.0.3626.109, webStorageEnabled: true}\nSession ID: ac3375a7bb5a0f9f954bed301f8bf9ab\n*** Element info: {Using\u003dxpath, value\u003d//ul1[@class\u003d\u0027mos-c-dropdown__list\u0027]/li/a[@id\u003d\u0027LogoutLink\u0027]}\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat com.qa.stepDefination.mercerOneview.Test9(mercerOneview.java:301)\r\n\tat ✽.And click to select logout button(Test1.feature:23)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "mercerOneview.Test10()"
});
formatter.result({
  "status": "skipped"
});
});