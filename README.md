# 🎞️ Pixabay Video Wrapper (Java)

A lightweight Java client for accessing the [Pixabay Video API](https://pixabay.com/api/docs/).  
This library simplifies interaction with Pixabay's REST API by mapping JSON responses to clean DTOs.

---

## 📦 Features

- Search royalty-free videos using the Pixabay API
- Supports mapping of nested JSON (video resolutions, URLs, tags, etc.)
- Simple, extensible DTO-based structure
- Minimal dependencies (Jackson, HttpClient5, Lombok)

---

## 🚀 Getting Started

### 1. Add dependency (if using locally)
If you built this locally:

```xml
<dependency>
  <groupId>org.example</groupId>
  <artifactId>pixabay-wrapper</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
