# Cross-Review / Крос-рев'ю (Лабораторна робота: Поведінкові шаблони)

**Команда / Team:**
- **Дем'ян Мисів (Demian Mysiv)** — Завдання 2 (`Command`) / Рецензент Завдання 1
- **Едуард Жалоба (Eduard Zhaloba)** — Завдання 1 (`Chain of Responsibility`) / Рецензент Завдання 2

---

## Частина 1: Аудит Завдання 1 — Передпольотний контроль пасажира (`Chain of Responsibility`)
## Part 1: Audit of Task 1 — Pre-flight Passenger Control (`Chain of Responsibility`)

**Автор / Author:** Едуард Жалоба (Eduard Zhaloba)  
**Рецензент / Reviewer:** Дем'ян Мисів (Demian Mysiv)

### 1. Відповідність діаграми класів коду / Class Diagram vs. Code Compliance
- **UA:** На момент проведення рев'ю UML-діаграма для Завдання 1 (`task1_chain.puml` / `.png`) ще не додана в папку `docs/diagrams/`. Необхідно додати діаграму, яка відображає абстрактний клас `CheckHandler`, його зв'язок рекурсивної агрегації (`next`), 5 конкретних обробників (`BoardingPassCheck`, `PassportControlCheck`, `CustomsControlCheck`, `SecurityCheck`, `WeightCheck`), модель `Passenger` та клієнта `Task1Demo`.
- **EN:** At the time of the review, the UML diagram for Task 1 (`task1_chain.puml` / `.png`) has not yet been added to `docs/diagrams/`. A diagram must be added showing the abstract `CheckHandler` class with its self-association (`next`), the 5 concrete handlers (`BoardingPassCheck`, `PassportControlCheck`, `CustomsControlCheck`, `SecurityCheck`, `WeightCheck`), the `Passenger` model, and the `Task1Demo` client.

### 2. Усунення проблеми з опису ситуації / Problem Resolution
- **UA:** Проблему монолітного методу з вкладеними умовами повністю вирішено. Кожна перевірка ізольована в окремому класі-спадкоємці `CheckHandler`. Склад і порядок ланок гнучко налаштовується під час виконання (`buildInternationalChain()` та `buildDomesticChain()`). Дотримано принцип Open/Closed: додавання нової перевірки не потребує змін в існуючих класах.
- **EN:** The issue of a monolithic method with nested conditionals is fully resolved. Each check is isolated in a separate subclass of `CheckHandler`. The composition and order of handlers are dynamically configured at runtime (`buildInternationalChain()` and `buildDomesticChain()`). The Open/Closed Principle is upheld: adding a new check requires no modifications to existing handlers.

### 3. Перевірка раннера та демонстраційного сценарію / Runner & Demo Scenario Verification
- **UA:** `Task1Demo.run()` коректно викликається з `Main.java` і відтворює всі 3 сценарії:
  1. Міжнародний рейс (Олександр, 8.5 кг) — успішно проходить усі 5 ланок із детальним логуванням.
  2. Перевищення ваги (Марія, 12.0 кг) — зупиняється на `WeightCheck` із зазначенням причини (перевищення ліміту 10.0 кг).
  3. Внутрішній рейс (Іван, 6.0 кг, без дійсного паспорта) — успішно проходить скорочений ланцюг без паспортного та митного контролю.
- **EN:** `Task1Demo.run()` is properly invoked from `Main.java` and reproduces all 3 scenarios:
  1. International flight (Oleksandr, 8.5 kg) — successfully passes all 5 links with detailed logging.
  2. Overweight baggage (Maria, 12.0 kg) — stopped at `WeightCheck` with a clear reason (exceeds 10.0 kg limit).
  3. Domestic flight (Ivan, 6.0 kg, without a valid passport) — successfully completes the shortened chain without passport or customs control.

### 4. Зауваження та рекомендації / Remarks & Recommendations
- **UA:**
  1. **Порядок перевірок у Сценарії 2:** У `buildInternationalChain()` ланка `WeightCheck` стоїть останньою. Щоб наочніше продемонструвати вимогу «наступні перевірки не виконуються», рекомендується перемістити `WeightCheck` перед `SecurityCheck` або `CustomsControlCheck`.
  2. **Іммутабельність `Passenger`:** Усі поля класу `Passenger` ініціалізуються в конструкторі і не змінюються — варто додати модифікатор `final`.
  3. **Діаграма:** Додати файли діаграми Завдання 1 у `docs/diagrams/`.
- **EN:**
  1. **Handler order in Scenario 2:** In `buildInternationalChain()`, `WeightCheck` is placed last. To more clearly demonstrate that "subsequent checks are not executed" upon failure, it is recommended to move `WeightCheck` before `SecurityCheck` or `CustomsControlCheck`.
  2. **`Passenger` immutability:** All fields in `Passenger` are set in the constructor and never mutated — adding the `final` modifier is recommended.
  3. **Diagram:** Add the Task 1 diagram files to `docs/diagrams/`.

---

## Частина 2: Аудит Завдання 2 — Операції диспетчера з розкладом (`Command`)
## Part 2: Audit of Task 2 — Dispatcher Schedule Operations (`Command`)

**Автор / Author:** Дем'ян Мисів (Demian Mysiv)  
**Рецензент / Reviewer:** Едуард Жалоба (Eduard Zhaloba)

### 1. Відповідність діаграми класів коду / Class Diagram vs. Code Compliance
- **UA:** *(Заповнює Едуард)*
- **EN:** *(To be filled by Eduard)*

### 2. Усунення проблеми з опису ситуації / Problem Resolution
- **UA:** *(Заповнює Едуард)*
- **EN:** *(To be filled by Eduard)*

### 3. Перевірка раннера та демонстраційного сценарію / Runner & Demo Scenario Verification
- **UA:** *(Заповнює Едуард)*
- **EN:** *(To be filled by Eduard)*

### 4. Зауваження та рекомендації / Remarks & Recommendations
- **UA:** *(Заповнює Едуард)*
- **EN:** *(To be filled by Eduard)*

---

## Частина 3: Аргументація вибору шаблонів для захисту / Pattern Selection Argumentation

### Завдання 1 — `Chain of Responsibility` (Едуард / Eduard)
- **UA:** *(Заповнює Едуард)*
- **EN:** *(To be filled by Eduard)*

### Завдання 2 — `Command` (Дем'ян / Demian)
- **UA:** Шаблон **Command** обрано, оскільки необхідно інкапсулювати кожну операцію диспетчера (`RescheduleCommand`, `ChangeGateCommand`, `CancelFlightCommand`) в окремий об'єкт із власним станом (старі та нові значення параметрів). Це повністю відокремлює ініціатора (`Dispatcher`) від отримувача (`AirportSchedule`) та природно забезпечує три ключові вимоги задачі: покрокове скасування операцій у зворотному порядку через стек історії (`undo`), відкладене пакетне виконання (`batchQueue`) та централізоване журналювання всіх дій (`actionJournal`).
- **EN:** The **Command** pattern was chosen to encapsulate each dispatcher operation (`RescheduleCommand`, `ChangeGateCommand`, `CancelFlightCommand`) as a standalone object holding its own state (previous and new parameters). This decouples the invoker (`Dispatcher`) from the receiver (`AirportSchedule`) and naturally supports all three core requirements: step-by-step reverse cancellation via a history stack (`undo`), deferred batch execution (`batchQueue`), and centralized logging of all operations (`actionJournal`).
