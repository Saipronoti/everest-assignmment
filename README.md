# Feature Flag Management System

This project is a Spring Boot application for managing feature flags. It allows you to enable or disable features for specific users or groups dynamically.

## Features

- Create, update, and retrieve feature flags.
- Override feature flags for specific users or groups.
- Check if a feature is enabled for a user or group.

## Technologies Used

- **Java**
- **Spring Boot**
- **Hibernate/JPA**
- **SQLite**
- **Maven**

## Database Schema

### `features` Table

| Column Name       | Type    | Description                          |
|-------------------|---------|--------------------------------------|
| `feature_key`     | TEXT    | Unique key for the feature.          |
| `default_enabled` | BOOLEAN | Default state of the feature.        |
| `description`     | TEXT    | Description of the feature.          |

### `overrides` Table

| Column Name   | Type    | Description                          |
|---------------|---------|--------------------------------------|
| `id`          | INTEGER | Surrogate primary key.              |
| `feature_key` | TEXT    | Foreign key referencing `features`. |
| `scope_type`  | TEXT    | `USER` or `GROUP`.                  |
| `scope_id`    | TEXT    | Identifier for the user or group.   |
| `enabled`     | BOOLEAN | Override value (`true` or `false`). |

## Endpoints

### 1. Create a Feature
**POST** `/features`

**Request Body**:
```json
{
  "key": "dark_mode",
  "defaultEnabled": true,
  "description": "Enable dark mode for the application."
}
