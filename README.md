# SQS-Producer
Produce messages for SQS 

# Service :
Send a message to the SQS queue

```
POST -> http://localhost:8080/api/v1/put

```

# Paylod :

  ``` 
  {
    "name":"surajit",
    "salary":3000000,
    "address":{
        "city":"Hyderabad",
        "state": "West Bengal",
        "country":"India"
    }
}
  ```
