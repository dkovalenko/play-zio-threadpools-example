# Play + ZIO Threadpools example

Zio ignores own thread pool if Runtime#unsafeRunToFuture was called on some other thread for example akka-default-dispatcher.

Run:
```
sbt
run
```
Then go to:
- localhost:9000/async
- localhost:9000/async_zio
- localhost:9000/async_zio_proper
