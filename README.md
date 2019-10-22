# Feature Flag Service

### Context
The following application exposes a single REST endpoint with the intention to provide information about the `enabled` / `disabled` status of configured [Features Flags][ef4f6104]

  [ef4f6104]: https://martinfowler.com/articles/feature-toggles.html "Features Flags"

The information exposed can be queried as follow:

```
GET /component/feature
```

The behaviour of the system is prepared to answer the value accordingly to the profile where the application is running i.e.: `development`, `staging` or `production`).

By default, if a query is done against a non configured `component`, `profile` or `feature` the response will be `false` by default.

### Configuration
Either the `profile`, such as the `component` and of course the `feature` should be provided in `features.yml` file.

```
component1:
  profile1:
     feature1: true
     feature2: true
  profile2:
    feature1: true
    feature2: true
```

### Running
This consist on a basic Spring Boot application runing under `gradle` which means it can be run easily as:

```
./gradlew bootRun
```

And the REST endpoint will be exposed in `localhost:8080`
