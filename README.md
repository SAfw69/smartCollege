# smartCollege
The project i made for my Java Client Server Coursework in college



# Smart College REST API

## Overview

This project is a RESTful API developed using JAX-RS (Jersey) and Grizzly HTTP server.
It simulates a smart college system that manages rooms, sensors, and sensor readings.

The API supports:

* Room management
* Sensor management and filtering
* Nested sensor readings (sub-resources)
* Proper error handling with HTTP status codes
* Logging of requests and responses

---

## Technologies Used

* Java
* JAX-RS (Jersey)
* Grizzly HTTP Server
* Maven

---

## How to Run the Project

1. Open the project in NetBeans or any IDE.
2. Ensure Maven dependencies are installed.
3. Run the `Main.java` class.
4. The server will start at:

```
http://localhost:8080/api/v1/
```

---

## API Endpoints

### Rooms

| Method | Endpoint    | Description    |
| ------ | ----------- | -------------- |
| POST   | /rooms      | Create a room  |
| GET    | /rooms      | Get all rooms  |
| GET    | /rooms/{id} | Get room by ID |
| DELETE | /rooms/{id} | Delete a room  |

---

### Sensors

| Method | Endpoint       | Description            |
| ------ | -------------- | ---------------------- |
| POST   | /sensors       | Create a sensor        |
| GET    | /sensors       | Get all sensors        |
| GET    | /sensors?type= | Filter sensors by type |
| GET    | /sensors/{id}  | Get sensor by ID       |

---

### Sensor Readings

| Method | Endpoint               | Description   |
| ------ | ---------------------- | ------------- |
| POST   | /sensors/{id}/readings | Add a reading |
| GET    | /sensors/{id}/readings | Get readings  |

---

## Example API Requests (cURL)

### Create Room

```bash
curl -X POST http://localhost:8080/api/v1/rooms \
-H "Content-Type: application/json" \
-d '{"id":"R1","name":"Lab","capacity":50}'
```

---

### Get All Rooms

```bash
curl http://localhost:8080/api/v1/rooms
```

---

### Create Sensor

```bash
curl -X POST http://localhost:8080/api/v1/sensors \
-H "Content-Type: application/json" \
-d '{"id":"S1","type":"temperature","status":"ACTIVE","roomId":"R1"}'
```

---

### Get Sensors

```bash
curl http://localhost:8080/api/v1/sensors
```

---

### Filter Sensors

```bash
curl "http://localhost:8080/api/v1/sensors?type=temperature"
```

---

### Add Reading

```bash
curl -X POST http://localhost:8080/api/v1/sensors/S1/readings \
-H "Content-Type: application/json" \
-d '{"id":"RD1","timestamp":1710000000,"value":25.5}'
```

---

### Get Readings

```bash
curl http://localhost:8080/api/v1/sensors/S1/readings
```

---

## Error Handling

The API uses custom exceptions mapped to HTTP status codes:

| Exception                  | Status Code | Description                     |
| -------------------------- | ----------- | ------------------------------- |
| ResourceNotFoundException  | 404         | Resource not found              |
| RoomNotEmptyException      | 409         | Cannot delete room with sensors |
| InvalidRoomException       | 422         | Invalid room reference          |
| SensorUnavailableException | 403         | Sensor in maintenance mode      |

All errors return a JSON response:

```json
{
  "error": "message"
}
```

---

## Design Decisions

* Separation of concerns: Resources, models, exceptions, and mappers are organized into separate packages.
* Sub-resource design: Sensor readings are accessed via `/sensors/{id}/readings`.
* Filtering: Sensors can be filtered using query parameters.
* Validation: Ensures correct relationships (e.g., sensor must belong to an existing room).
* Exception mapping: Centralized error handling using a global exception mapper.

---

## Logging

A logging filter is implemented to log:

* HTTP request methods
* Request paths
* Response status codes

---

## API Validation Screenshots
The following screenshots demonstrate the successful execution of each API endpoint and error handling scenarios.

Check Server Running
https://images/001CheckServerRunning.png

Make First Room
https://images/002MakeFirstRoom.png

Make Second Room
https://images/003MakeSecondRoom.png

Show All Rooms
https://images/004ShowAllRooms.png

Show Only Room 1
https://images/005ShowOnlyRoom1.png

Make First Sensor
https://images/006MakeFirstSensor.png

Make Second Sensor
https://images/007MakeSecondSensor.png

Show All Sensors
https://images/008ShowAllSensors.png

Show Type‑wise Sensor
https://images/009ShowTypeWiseSensor.png

Show Sensor with ID
https://images/010ShowSensorWithID.png

Make First Sensor Reading
https://images/011MakeFirstSensorReading.png

Make Second Sensor Reading
https://images/012MakeSecondSensorReading.png

Show All Sensor Readings
https://images/013ShowAllSensorReadings.png

Show Sensor After Reading
https://images/014ShowSensorAfterReading.png

Room Not Found Exception
https://images/015RoomNotFoundException.png

Room Not Found Empty Exception
https://images/016RoomNotFoundEmptyException.png

Sensor Not Found Exception
https://images/017SensorNotFoundException.png

Forbidden Sensor Exception – Part 1
https://images/018ForbiddenSensorExceptionPart1.png

Forbidden Sensor Exception – Part 2
https://images/019ForbiddenSensorExceptionPart2.png



## Conclusion

This project demonstrates RESTful API design, structured resource management, validation, filtering, sub-resources, and proper error handling using JAX-RS.
