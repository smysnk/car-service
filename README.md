# car-service

> Spring Boot + HATEOAS service


## Running

`$ ./gradlew run`

### Retrieving Service record

`$ curl -i -H "Content-Type: application/json" -X GET http://localhost:8080/service-record/1`

```
{
  "serviceRecordId" : 1,
  "dateServiced" : "2015-04-21T08:10:36.489+0000",
  "odometerReading" : 1000,
  "serviceOilChanged" : true,
  "serviceTireRotated" : true,
  "serviceSparkPlugsChanged" : true,
  "car" : {
    "make" : "Toyota",
    "model" : "Rav4",
    "type" : "Gas",
    "year" : 2012,
    "_links" : {
      "self" : {
        "href" : "http://localhost:8080/car/1"
      }
    }
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/service-record/1"
    }
  }
}
```

### Retrieving Customer
`$ curl -i -H "Content-Type: application/json" -X GET http://localhost:8080/customer/1`

```
{
  "customerId" : 1,
  "firstName" : "Joshua",
  "lastName" : "Bellamy-Henn",
  "car" : [ {
    "make" : "Toyota",
    "model" : "Rav4",
    "type" : "Gas",
    "year" : 2012,
    "_links" : {
      "self" : {
        "href" : "http://localhost:8080/car/1"
      }
    }
  } ],
  "serviceRecords" : [ {
    "serviceRecordId" : 1,
    "dateServiced" : "2015-04-21T08:10:36.489+0000",
    "odometerReading" : 1000,
    "serviceOilChanged" : true,
    "serviceTireRotated" : true,
    "serviceSparkPlugsChanged" : true,
    "car" : {
      "make" : "Toyota",
      "model" : "Rav4",
      "type" : "Gas",
      "year" : 2012,
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/car/1"
        }
      }
    },
    "_links" : {
      "self" : {
        "href" : "http://localhost:8080/service-record/1"
      }
    }
  } ],
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/customer/1"
    }
  }
}
```

### Retrieving Car
`$ curl -i -H "Content-Type: application/json" -X GET http://localhost:8080/car/1`

```
{
  "make" : "Toyota",
  "model" : "Rav4",
  "type" : "Gas",
  "year" : 2012,
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/car/1"
    }
  }
}
```

