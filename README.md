# Expense Tracker with Monthly Analytics
Project repott is added to the files
##  Project Overview
This is a Java-based desktop application that helps users manage and analyze their personal expenses. It provides features to add, view, delete, and export expenses, along with monthly analytics in the form of Pie and Bar Charts.

##  Features
- Add daily expenses (Date, Category, Amount, Note)
- View expenses in a JavaFX TableView
- Delete selected expenses
- Export expenses to CSV
- Visualize monthly data using:
  - Pie Chart (Category-wise)
  - Bar Chart (Category-wise with colored bars)
- Automatic chart pop-ups for selected month

##  Tools and Technologies
- **Java**
- **JavaFX** – GUI components
- **SQLite** – Lightweight embedded database
- **JDBC** – Java-DB connectivity
- **JFreeChart** – Chart visualization

## 🗂️ Project Structure
Expense Tracker/
├── src/
│ ├── Main.java
│ ├── Expense.java
│ ├── DatabaseHelper.java
│ ├── ExpenseForm.java
│ ├── ExpenseSummary.java
│ ├── ChartGenerator.java
│ ├── Utils.java
│
├── lib/
│ ├── jfreechart-x.x.x.jar
│ ├── other required jars
│
├── data/
│ ├── expenses.db
│
├── charts/

##  How to Run
1. Make sure you have **Java 17+** and **JavaFX SDK 20+** installed.
2. Include `jfreechart` and JavaFX libraries in your classpath.
3. Compile all `.java` files:
   
   javac --module-path "path/to/javafx/lib" --add-modules javafx.controls,javafx.fxml,javafx.swing -cp ".;../lib/*" *.java

4. Run all `.java` files:
   java --module-path "path/to/javafx/lib" --add-modules javafx.controls,javafx.fxml,javafx.swing -cp ".;../lib/*" Main
