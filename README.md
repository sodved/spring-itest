# Spring Integration Test Example

Having all sorts of issues trying to get spring integration tests running. Asked [a question on StakOverflow](https://stackoverflow.com/questions/71836098/) but all a bit convoluted help there. So decided to get the simplest example of our setup to see if I can reproduce the various issues I am hitting.

## Basic usage
So in these examples you can build the applications with.
```
mvn clean install
```

And then you can successfully run the applications with (eg case1):
```
java -jar case1/case1-app/target/case1-app-0.0.1-0-SNAPSHOT.jar
```
The applications will run successfully.

But integration testing (triggered by the `itest` maven profile) will fail:

# Case0: Class Not found
So the issue here is the application module test is giving a classNotFound error when trying to autowire
a service from the application module.
```
mvn clean verify -P itest -pl case0 -am -amd
...
[INFO] Running com.sodved.itestcase0.app.itest.IntegrationIT
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.003 s <<< FAILURE! - in com.sodved.itestcase0.app.itest.IntegrationIT
[ERROR] com.sodved.itestcase0.app.itest.IntegrationIT  Time elapsed: 0.002 s  <<< ERROR!
java.lang.NoClassDefFoundError: Lcom/sodved/itestcase0/app/service/AppService;
Caused by: java.lang.ClassNotFoundException: com.sodved.itestcase0.app.service.AppService
```
Which is really weird as everything compiles OK and runs fine.
```
java -jar case0/case0-app/target/case0-app-0.0.1-0-SNAPSHOT.jar
```

So why is the service component from the app module not being found?

# Case1: Class Not found (but works if in different module)
This is the same as above, but shows that it does work if the service class is defined in a different
maven module. Here I have commented out the `AppService` reference in the test, and it works with `LibService`
only.
```
mvn clean verify -P itest -pl case1 -am -amd
```

But if you uncomment the `AppService` line you get the same error as in case 0.
a service from the application module.
```
mvn clean verify -P itest
...
[INFO] Running com.sodved.itestcase1.app.itest.IntegrationIT
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.003 s <<< FAILURE! - in com.sodved.itestcase1.app.itest.IntegrationIT
[ERROR] com.sodved.itestcase1.app.itest.IntegrationIT  Time elapsed: 0.002 s  <<< ERROR!
java.lang.NoClassDefFoundError: Lcom/sodved/itestcase1/app/service/AppService;
Caused by: java.lang.ClassNotFoundException: com.sodved.itestcase1.app.service.AppService
```

Once again, actually running the app works fine.
```
java -jar case1/case1-app/target/case1-app-0.0.1-0-SNAPSHOT.jar
```


