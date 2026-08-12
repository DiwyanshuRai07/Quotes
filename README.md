# Quotes 📖

A modern Android Quotes application built with **Kotlin**, following **Clean Architecture + MVVM** principles.

The app uses the **DummyJSON Quotes API** to fetch and display quotes, with support for both **Quotes Listing** and **Quote Details** screens.

## 🚀 Features

* 📜 Browse a list of quotes
* 🔍 View quote details
* 🌐 Fetch quotes from the DummyJSON API
* 🏗️ Clean Architecture
* 🧩 MVVM architecture
* 💉 Dependency Injection using Dagger
* 🌐 REST API integration using Retrofit
* ⚡ Kotlin Coroutines for asynchronous operations
* 🔄 Proper separation of UI, domain, and data layers

## 🛠️ Tech Stack

* **Kotlin**
* **Android**
* **MVVM**
* **Clean Architecture**
* **Dagger**
* **Retrofit**
* **Kotlin Coroutines**
* **DummyJSON API**

## 🌐 API

This project uses the **DummyJSON Quotes API**:

[DummyJSON Quotes API](https://dummyjson.com/quotes?utm_source=chatgpt.com)

The API provides quote data including the **quote text** and **author**, which are used throughout the application.

## 📱 Screens

### Quotes Listing

Displays a collection of quotes retrieved from the API.

### Quote Details

Displays detailed information about the selected quote, including the quote text and author.

## 🏛️ Architecture

The project follows **Clean Architecture with MVVM**, keeping responsibilities separated across different layers:

```text
UI
 ↓
ViewModel
 ↓
Use Case
 ↓
Repository
 ↓
Remote Data Source
 ↓
Retrofit API
 ↓
DummyJSON
```

This structure makes the application easier to maintain, test, and extend.

## 🎯 Purpose

This project demonstrates how to build a scalable Android application using modern development practices, dependency injection, API integration, and clean separation of concerns.
