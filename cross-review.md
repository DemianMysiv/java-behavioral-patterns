# Cross-Review / Крос-рев'ю (Лабораторна робота: Поведінкові шаблони)

**Команда / Team:**
- **Дем'ян Мисів (Demian Mysiv)** — Завдання 2 (Command) / Рецензент Завдання 1
- **Едуард Жалоба (Eduard Zhaloba)** — Завдання 1 (Chain of Responsibility) / Рецензент Завдання 2

---

## Частина 1: Аудит Завдання 1 — Передпольотний контроль пасажира (Chain of Responsibility)
## Part 1: Audit of Task 1 — Pre-flight Passenger Control (Chain of Responsibility)

**Автор / Author:** Едуард Жалоба (Eduard Zhaloba)  
**Рецензент / Reviewer:** Дем'ян Мисів (Demian Mysiv)

### 1. Відповідність діаграми класів коду / Class Diagram vs. Code Compliance
- **UA:** UML-діаграма (docs/diagrams/task1_chain.puml та .png) повністю відповідає реалізованому коду. На діаграмі відображено абстрактний клас CheckHandler, його рекурсивний зв'язок 
ext, 5 конкретних обробників (BoardingPassCheck, PassportControlCheck, CustomsControlCheck, SecurityCheck, WeightCheck), модель Passenger та клієнт Task1Demo.
- **EN:** The UML diagram (docs/diagrams/task1_chain.puml and .png) fully matches the implemented code. It correctly shows the abstract CheckHandler class with its recursive 
ext association, 5 concrete handlers (BoardingPassCheck, PassportControlCheck, CustomsControlCheck, SecurityCheck, WeightCheck), the Passenger model, and the Task1Demo client.

### 2. Усунення проблеми з опису ситуації / Problem Resolution
- **UA:** Проблему монолітного методу з вкладеними умовами повністю вирішено. Кожна перевірка ізольована в окремому класі-спадкоємці CheckHandler. Склад і порядок ланок гнучко налаштовується під час виконання (uildInternationalChain() та uildDomesticChain()). Дотримано принцип Open/Closed: додавання нової перевірки не потребує змін в існуючих класах.
- **EN:** The issue of a monolithic method with nested conditionals is fully resolved. Each check is isolated in a separate subclass of CheckHandler. The composition and order of handlers are dynamically configured at runtime (uildInternationalChain() and uildDomesticChain()). The Open/Closed Principle is upheld: adding a new check requires no modifications to existing handlers.

### 3. Перевірка раннера та демонстраційного сценарію / Runner & Demo Scenario Verification
- **UA:** Task1Demo.run() коректно викликається з Main.java і відтворює всі 3 сценарії:
  1. Міжнародний рейс (Олександр, 8.5 кг) — успішно проходить усі 5 ланок із детальним логуванням.
  2. Перевищення ваги (Марія, 12.0 кг) — зупиняється на WeightCheck із зазначенням причини (перевищення ліміту 10.0 кг).
  3. Внутрішній рейс (Іван, 6.0 кг, без дійсного паспорта) — успішно проходить скорочений ланцюг без паспортного та митного контролю.
- **EN:** Task1Demo.run() is properly invoked from Main.java and reproduces all 3 scenarios:
  1. International flight (Oleksandr, 8.5 kg) — successfully passes all 5 links with detailed logging.
  2. Overweight baggage (Maria, 12.0 kg) — stopped at WeightCheck with a clear reason (exceeds 10.0 kg limit).
  3. Domestic flight (Ivan, 6.0 kg, without a valid passport) — successfully completes the shortened chain without passport or customs control.

### 4. Зауваження та рекомендації / Remarks & Recommendations
- **UA:**
  1. **Порядок перевірок у Сценарії 2:** У uildInternationalChain() ланка WeightCheck стоїть останньою. Щоб наочніше продемонструвати вимогу «наступні перевірки не виконуються», рекомендується перемістити WeightCheck перед SecurityCheck або CustomsControlCheck.
  2. **Іммутабельність Passenger:** Усі поля класу Passenger ініціалізуються в конструкторі і не змінюються — варто додати модифікатор inal.
- **EN:**
  1. **Handler order in Scenario 2:** In uildInternationalChain(), WeightCheck is placed last. To more clearly demonstrate that "subsequent checks are not executed" upon failure, it is recommended to move WeightCheck before SecurityCheck or CustomsControlCheck.
  2. **Passenger immutability:** All fields in Passenger are set in the constructor and never mutated — adding the inal modifier is recommended.

---

## Частина 2: Аудит Завдання 2 — Операції диспетчера з розкладом (Command)
## Part 2: Audit of Task 2 — Dispatcher Schedule Operations (Command)

**Автор / Author:** Дем'ян Мисів (Demian Mysiv)  
**Рецензент / Reviewer:** Едуард Жалоба (Eduard Zhaloba)

### 1. Відповідність діаграми класів коду / Class Diagram vs. Code Compliance
- **UA:** UML-діаграма (docs/diagrams/task2_command.puml та .png) повністю відповідає реалізованому коду. Коректно відображено інтерфейс ScheduleCommand, отримувача AirportSchedule, ініціатора Dispatcher, три конкретні команди (RescheduleCommand, ChangeGateCommand, CancelFlightCommand) та клієнта Task2Demo. Модифікатори доступу, стереотипи ролей, реалізація, асоціації та агрегація вказані точно.
- **EN:** The UML diagram (docs/diagrams/task2_command.puml and .png) fully matches the implemented code. The ScheduleCommand interface, AirportSchedule receiver, Dispatcher invoker, three concrete commands (RescheduleCommand, ChangeGateCommand, CancelFlightCommand), and Task2Demo client are accurately represented with proper access modifiers, role stereotypes, realizations, associations, and aggregations.

### 2. Усунення проблеми з опису ситуації / Problem Resolution
- **UA:** Проблему неможливості скасування помилкових дій, відсутності журналу та пакетного застосування змін повністю вирішено. Кожна операція інкапсульована в окремий клас-команду з методами execute() та undo(). Ініціатор Dispatcher не залежить від AirportSchedule і керує історією (history), чергою пакетного виконання (atchQueue) та журналом (ctionJournal).
- **EN:** The lack of undo capability, action logging, and batch execution is completely resolved. Each operation is encapsulated in a dedicated command class implementing execute() and undo(). The Dispatcher invoker is fully decoupled from AirportSchedule and manages the undo history (history), batch queue (atchQueue), and action log (ctionJournal).

### 3. Перевірка раннера та демонстраційного сценарію / Runner & Demo Scenario Verification
- **UA:** Task2Demo.run() коректно запускається з Main.java і повністю відтворює всі 3 сценарії:
  1. Миттєві дії: перенесення рейсу PS-101 на 15:30 та зміна виходу PS-202 на C1 із виведенням оновленого розкладу.
  2. Скасування дій: два послідовні виклики undoLastAction() повертають розклад до початкового стану.
  3. Пакетне виконання: 3 команди (RescheduleCommand, ChangeGateCommand, CancelFlightCommand) додаються в чергу, виконуються пакетом через executeBatch(), після чого виводиться фінальний розклад і журнал дій диспетчера.
- **EN:** Task2Demo.run() is properly invoked from Main.java and reproduces all 3 scenarios:
  1. Immediate actions: reschedules flight PS-101 to 15:30 and changes gate for PS-202 to C1, then prints the updated schedule.
  2. Undo actions: two consecutive undoLastAction() calls revert the schedule to its initial state.
  3. Batch execution: 3 commands (RescheduleCommand, ChangeGateCommand, CancelFlightCommand) are queued, executed via executeBatch(), followed by printing the final schedule and dispatcher journal.

### 4. Зауваження та рекомендації / Remarks & Recommendations
- **UA:**
  1. **Використання Stack:** У Dispatcher для історії використано застарілий синхронізований клас java.util.Stack. У сучасній Java краще використовувати Deque<ScheduleCommand> history = new ArrayDeque<>().
  2. **Фіксація попереднього стану:** У RescheduleCommand та ChangeGateCommand старі значення (oldTime, oldGate) передаються через конструктор. Для надійнішої роботи з пакетом команд над одним рейсом краще зчитувати поточний стан із AirportSchedule безпосередньо в execute().
  3. **Дублювання логування:** Приватний метод logRequest() дублюється в усіх трьох класах команд — його можна винести в спільний абстрактний клас.
- **EN:**
  1. **Usage of Stack:** Dispatcher uses the legacy synchronized java.util.Stack. In modern Java, Deque<ScheduleCommand> history = new ArrayDeque<>() is preferred.
  2. **Previous state capture:** RescheduleCommand and ChangeGateCommand receive oldTime/oldGate via constructor. Fetching the current state from AirportSchedule inside execute() would be safer when batching multiple changes to the same flight.
  3. **Logging duplication:** The private logRequest() method is duplicated across all three concrete command classes and could be extracted into a shared abstract base class.

---

## Частина 3: Аргументація вибору шаблонів для захисту / Pattern Selection Argumentation

### Завдання 1 — Chain of Responsibility (Едуард / Eduard)
- **UA:** Шаблон **Chain of Responsibility** обрано, оскільки передпольотний контроль складається з послідовності незалежних перевірок, кожна з яких може або зупинити пасажира з поясненням причини, або передати запит далі. Винесення кожної перевірки в окремий підклас CheckHandler усуває громіздкі вкладені умови, дозволяє динамічно формувати різні маршрути перевірки під час виконання (міжнародні та внутрішні рейси) і забезпечує дотримання принципу Open/Closed при додаванні нових етапів контролю.
- **EN:** The **Chain of Responsibility** pattern was chosen because pre-flight control consists of sequential, independent checks where each step can either reject the passenger with a reason or pass the request along. Isolating each check into a separate CheckHandler subclass eliminates deeply nested conditionals, enables dynamic runtime chain assembly (international vs. domestic flights), and adheres to the Open/Closed Principle when adding new checks.

### Завдання 2 — Command (Дем'ян / Demian)
- **UA:** Шаблон **Command** обрано, оскільки необхідно інкапсулювати кожну операцію диспетчера (RescheduleCommand, ChangeGateCommand, CancelFlightCommand) в окремий об'єкт із власним станом (старі та нові значення параметрів). Це повністю відокремлює ініціатора (Dispatcher) від отримувача (AirportSchedule) та природно забезпечує три ключові вимоги задачі: покрокове скасування операцій у зворотному порядку через стек історії (undo), відкладене пакетне виконання (atchQueue) та централізоване журналювання всіх дій (ctionJournal).
- **EN:** The **Command** pattern was chosen to encapsulate each dispatcher operation (RescheduleCommand, ChangeGateCommand, CancelFlightCommand) as a standalone object holding its own state (previous and new parameters). This decouples the invoker (Dispatcher) from the receiver (AirportSchedule) and naturally supports all three core requirements: step-by-step reverse cancellation via a history stack (undo), deferred batch execution (atchQueue), and centralized logging of all operations (ctionJournal).