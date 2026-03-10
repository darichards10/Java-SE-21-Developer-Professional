# Java SE 21 Developer Professional — Exam Study Project

Hands-on code examples and self-test quizzes for every domain of the **Oracle Java SE 21 Developer Professional** certification (exam 1Z0-830).

---

## Prerequisites

| Requirement | Notes |
|---|---|
| **JDK 21** | [Oracle JDK 21](https://www.oracle.com/java/technologies/downloads/#java21) or [Eclipse Temurin 21](https://adoptium.net/) |
| **Eclipse IDE for Java Developers** | 2023-09 or newer recommended |

---

## Importing into Eclipse

The Eclipse project files (`.project`, `.classpath`, `.settings/`) are already committed, so no manual project configuration is needed.

1. **File → Import → General → Existing Projects into Workspace**
2. Click **Browse** and navigate to the **`Java-SE-21-Developer-Professional/`** subdirectory inside the cloned repo — *not* the repo root itself
3. The project `Java-SE-21-Developer-Professional` should appear checked in the list — click **Finish**
4. Eclipse will auto-build the project. A green check in Package Explorer means it compiled successfully

> **Repo layout reminder:**
> ```
> Java-SE-21-Developer-Professional/   ← git repo root
> └── Java-SE-21-Developer-Professional/  ← Eclipse project (import this folder)
>     ├── src/
>     ├── bin/
>     ├── .project
>     └── .classpath
> ```

---

## Fixing JRE Errors

If Eclipse shows errors about a missing `JavaSE-21` JRE:

1. **Window → Preferences → Java → Installed JREs**
2. Click **Add → Standard VM**
3. Set the JRE home to your JDK 21 installation directory (e.g., `C:\Program Files\Eclipse Adoptium\jdk-21...`)
4. Check the new entry and click **Apply and Close**
5. Right-click the project → **Build Project** to recompile

---

## Running Examples

Each exam domain is a runnable Java class. To run any example:

**Right-click the class in Package Explorer → Run As → Java Application**

The master entry point is `se21.Main` — it lists all domains and references the key classes to explore.

Individual domain classes can also be run directly (e.g., `se21.oop.Polymorphism`, `se21.functional.StreamsExamples`).

> **JDBC note:** The `se21.jdbc` examples require a live database connection and will throw an exception without one. Skip this domain initially and configure a connection when ready.

---

## Module System

This project uses the Java 9+ module system. The module is declared in `src/module-info.java`:

```java
module SE21 {
    requires java.sql;
}
```

Eclipse reads this automatically — no additional configuration needed.

---

## Project Structure & Exam Domain Weights

```
src/se21/
├── Main.java              ← Master index; start here
├── datatypes/             ← Primitives, wrappers, DateTime, StringBuilder, Math
├── flow/                  ← Control flow, loops, switch expressions/statements
├── oop/                   ← Inheritance, polymorphism, interfaces, nested classes
│   └── access/            ← Access modifier examples across packages
├── exceptions/            ← Exception hierarchy, try-catch-finally, try-with-resources
├── collections/           ← List, Set, Map, Queue, Comparator, SequencedCollection
├── functional/            ← Lambdas, streams, method references, generics, records
├── modules/               ← JPMS module declarations, exports, requires
├── concurrency/           ← Threads, ExecutorService, atomics, virtual threads (Java 21)
├── io/                    ← NIO.2, Path/Files, buffered streams, serialization
├── jdbc/                  ← JDBC 4.2, PreparedStatement, ResultSet  [needs DB]
└── localization/          ← Locale, ResourceBundle, number/date formatting
```

| Package | Topic | Exam Weight |
|---|---|---|
| `se21.oop` | OOP — inheritance, polymorphism, access modifiers, nested classes | ~23% |
| `se21.functional` | Streams & lambdas — method refs, generics, records | ~17% |
| `se21.io` | Java I/O API — NIO.2, Path, Files, serialization | ~12% |
| `se21.concurrency` | Concurrency — threads, executors, virtual threads | ~11% |
| `se21.datatypes` | Data types — primitives, wrappers, DateTime, operators | ~11% |
| `se21.jdbc` | JDBC — database access, prepared statements | ~9% |
| `se21.collections` | Collections — List, Set, Map, Queue | ~9% |
| `se21.flow` | Program flow — decisions, loops, switch | ~9% |
| `se21.modules` | JPMS — module declarations and dependencies | ~8% |
| `se21.localization` | Localization — Locale, ResourceBundle, i18n | ~8% |
| `se21.exceptions` | Exceptions — hierarchy, checked vs unchecked | ~7% |

---

## Study Tips

- **`// EXAM:` comments** — inline markers throughout the code flag concepts that appear on the exam; read these carefully
- **`Quiz.java`** — every domain package has a `Quiz.java`; run it to test yourself with multiple-choice questions
- **Start with the high-weight domains** — OOP (23%) and Streams/Lambdas (17%) together make up 40% of the exam
- **`se21.Main`** is the guided tour — use it to navigate between domains in order
- **Java 21 features** covered include: virtual threads, records, sealed classes, pattern matching with `instanceof`, and `SequencedCollection`
- The `se21.oop.access` subpackage has dedicated classes showing exactly which access modifiers are visible across package and inheritance boundaries — a common source of tricky exam questions

---

## Exam Reference

- **Exam:** Oracle Java SE 21 Developer Professional (1Z0-830)
- **Oracle Certification Page:** https://education.oracle.com/java-se-21-developer-professional/pexam_1Z0-830
