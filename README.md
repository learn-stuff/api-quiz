API quiz
=======
## How to run:

```
$ ./run-api-quiz
```
or

```
java -jar build/api-quiz-0.1.0-SNAPSHOT-standalone.jar
```

## Lets test it:

A Fibonacci endpoint that accepts a number and returns the Fibonacci calculation for that number, and returns result in JSON format.

```
$ curl -s 'http://127.0.0.1:8080/fib/12'
{"response":144}
```

An endpoint that fetches the Google homepage and returns the sha1 of the response message-body (HTTP body data).

```
$ curl -s 'http://127.0.0.1:8080/google-body'
{"response":"272cca559ffe719d20ac90adb9fc4e5716479e96"}
```
 
Using some external storage of your choice (can be redis, memcache, sqlite, mysql, etc), provide a means to store and then retrieve a value.

```
$ curl -d 'val=something' 'http://127.0.0.1:8080/store'
$ curl 'http://127.0.0.1:8080/store'
{"response":"something"}
```
