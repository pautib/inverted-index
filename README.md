# Inverted Index

An **Inverted Index** is a data structure that maps terms (such as words) to the documents where they appear. This structure enables efficient full-text search capabilities, similar to how search engines operate.

---

## 📘 Description

This Java implementation of an `InvertedIndex` supports:

- Inserting documents
- Searching for documents containing:
  - A single term
  - Both of two terms (`AND` search)
  - Either of two terms (`OR` search)
- Deleting a document from the index

The implementation is **case-insensitive** and **thread-safe** using `ConcurrentHashMap`.

---

## 🚀 Features

- 🔤 Word-based indexing with normalization (lowercasing, punctuation splitting)
- ⚡ Fast lookup with `ConcurrentHashMap`
- ✅ Thread-safe operations
- 📚 Simple API: `insertDoc`, `search`, `andSearch`, `orSearch`, `delete`

---

## 🛠 Usage

### 🧪 Insert a document
```java
InvertedIndex index = new InvertedIndex();
index.insertDoc("Java is awesome");
index.insertDoc("Python is also great");
```

### 🔍 Search by term
```java
List<String> results = index.search("java");
```

### 🔍 Search documents containing both terms
```java
List<String> results = index.andSearch("java", "awesome");
```

### 🔍 Search documents containing either term
```java
List<String> results = index.orSearch("java", "python");
```

### 🗑 Delete a document
```java
index.delete("Java is awesome");
```

---

## 🧰 Technologies

- Java 11+
- Core Java libraries (`Map`, `Set`, `ConcurrentHashMap`, `HashSet`)

---

## 📂 Project Structure

```
InvertedIndex.java    # Main class with insert/search/delete methods
README.md             # Project documentation
```

---

## ✅ To Do

- [ ] Add support for multi-term `AND` searches (e.g., list of terms)
- [ ] Add unit tests
- [ ] Add support for phrase queries or positional index
- [ ] CLI or Web UI for interactive testing

---

## 📄 License

This project is open-source and available under the MIT License.
