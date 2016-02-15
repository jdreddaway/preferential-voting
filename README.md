# preferential-voting
A service for running preferential voting elections.

## Developers

If you are getting weird Eclipse errors, try `mvn install` then Eclipse project clean.

### Getting Started

#### Set up Local MySQL Database

To test locally, you'll need to have a local MySQL server running.

1. Install a mysql server.
  1. Download mysql-server by following the instructions [here](http://dev.mysql.com/doc/refman/5.7/en/installing.html). **Make sure you get mysql version 5.6.** For linux, follow **all** of the instructions on [A Quick Guide to Using the MySQL APT Repository](A Quick Guide to Using the MySQL APT Repository).
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
