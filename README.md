# preferential-voting
A service for running preferential voting elections.

## Developers

If you are getting weird Eclipse errors, try `mvn install` then Eclipse project clean.

### Getting Started

#### Load Project into Eclipse

1. Install the [Java 7 SDK][java7] (the version that appengine uses)
1. Install Eclipse EE. **Make sure it is EE!**
1. Install the Google Plugin for Eclipse and Google App Engine SDK. [Click here for instructions][GooglePlugin].
1. Git checkout the project.
1. Import the project into Eclipse as an existing maven project.
1. Resolve errors
  1. Create directory preferential-voting/target/generated-sources/annotations. Try compiling to get this to go away.
  1. For "Plugin execution not covered by lifecycle configuration: ...endpoints_get_discovery_doc...", mark it as ignored in Eclipse preferences.
  1. "Target Runtime Google App Engine (...) is not defined." - Quick Fix create new runtime Google App Engine 
1. Project > Maven > Update Project
1. Add `maven clean install` run configuration in Eclipse and run. (This does Dagger stuff).
1. Add `maven install` run configuration in Eclipse and run.

Some of these steps were taken from [Using Apache Maven](https://cloud.google.com/appengine/docs/java/tools/maven). Take a look there if you get lost.

#### Set up Local MySQL Database

To test locally, you'll need to have a local MySQL server running.

1. Install a mysql server.
  1. Download mysql-server by following the instructions [here][mysql-installer]. **Make sure you get mysql version 5.7.** For linux, follow **all** of the instructions on [A Quick Guide to Using the MySQL APT Repository](A Quick Guide to Using the MySQL APT Repository).
1. Run `set_up_local_db.sql` by running the following command (changing `<password>` to the root's password):

        mysql -hlocalhost -uroot -p<password> < set_up_local_db.sql
`set_up_local_db.sql` does not work well if things are already set up. If you are trying to update, it might be best to delete the user and database beforehand or run all of the commands manually.

### Common Tasks

#### Make Requests via the Web UI

1. Run the `appengine:devserver` maven target to start devserver.
1. Navigate to `http://localhost:8080/_ah/api/explorer` in a browser.
1. Allow unsafe scripts (sometimes not necessary). In Chrome, click on the shield at the right side of the navigation bar.
1. Find the endpoint you wish to use.

For more information, see Google Cloud Platform's [Testing and Deploying an API Backend](https://cloud.google.com/appengine/docs/java/endpoints/test_deploy).

#### Generate Dagger Classes

You will need to do this every time you change a Dagger class.

1. Run the maven `clean` and `compile` goals.

[GooglePlugin]: https://developers.google.com/eclipse/docs/download
[java7]: http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
[mysql-installer]: http://dev.mysql.com/doc/refman/5.7/en/installing.html