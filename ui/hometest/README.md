# Simple Web Automation Test

### Tech Stacks
- Maven for Depedency Management
- TestNG: 7.1.0
- selenium-java: 4.10.0
- selenium-chrome-driver: 4.10.0
- maven-surefire-plugin: 3.1.2


### How to Run
Run directly without surefire report:
- click play button directly on the method

Run with surefire report:
- on VSCode, right click on Maven section, then click "Test"
- or execute this command on terminal 
```
 mvn test -f "{project-path}/ui/hometest/pom.xml"
```
- surefire report files can be found on `target/surefire-reports/index.html`
- test run config for surefire and TestNG located at root folder of the project, `testng.xml`

Tested working with Google Chrome version `114.0.5735.198`

note:
TestNG depedency is ony available for use inside `src/test` folder, since its scope has been limited to `test` in pom.xml file