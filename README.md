# Mini Library Web App 📚

Pełnoprawna aplikacja Full-Stack (Server-Side Rendering) oparta na architekturze MVC. Projekt pozwala na zarządzanie biblioteką z poziomu przeglądarki internetowej i demonstruje wykorzystanie relacyjnych baz danych oraz silników szablonów w ekosystemie Spring Boot.

## 🚀 Technologie
* **Backend:** Java 17+, Spring Boot 3 (Spring Web, Spring Data JPA)
* **Frontend:** Thymeleaf (silnik szablonów HTML), Bootstrap 5 (UI/UX)
* **Baza Danych:** H2 (In-Memory) z wykorzystaniem Hibernate
* **Narzędzia:** Maven, Lombok, Git

## 🧠 Kluczowe funkcjonalności i architektura
Projekt wykracza poza proste REST API, integrując pełen cykl życia aplikacji webowej:
* **Wzorzec MVC (Model-View-Controller):** Płynne przekazywanie danych między kontrolerami Springa a widokami HTML za pomocą obiektu `Model`.
* **Relacje Bazodanowe:** Zaimplementowana relacja One-to-Many / Many-to-One pomiędzy encjami `Author` oraz `Book`.
* **Obsługa formularzy (POST):** Bezpieczne odbieranie danych wprowadzanych przez użytkownika na stronie WWW i mapowanie ich na obiekty Javy.
* **Wzorzec PRG (Post/Redirect/Get):** Zastosowanie przekierowań (`redirect:/`) po wysłaniu formularza, co zapobiega podwójnemu wysyłaniu danych przy odświeżaniu strony.
* **Data Initialization:** Automatyczne ładowanie danych testowych do bazy przy starcie aplikacji (wykorzystanie `CommandLineRunner`).

## ⚙️ Struktura Bazy Danych
Aplikacja wykorzystuje dwie powiązane ze sobą tabele:
1. **AUTHOR:** `id`, `first_name`, `last_name`
2. **BOOK:** `id`, `title`, `author_id` (Klucz obcy / Foreign Key łączący książkę z konkretnym autorem)

## 🛠️ Jak uruchomić?
1. Sklonuj repozytorium: `git clone [TUTAJ_LINK_DO_TWOJEGO_GITHUB]`
2. Uruchom aplikację z użyciem Mavena: `mvn spring-boot:run` lub otwórz bezpośrednio w środowisku IDE (np. IntelliJ).
3. Otwórz przeglądarkę i wejdź pod adres: `http://localhost:8080/`
4. Gotowe! Możesz dodawać nowych autorów i przypisywać do nich książki za pomocą interfejsu graficznego.

## 📊 Dostęp do bazy danych (H2 Console)
Aby podejrzeć, jak dane układają się w tabelach "pod maską", wejdź na:
* **Adres:** `http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:mem:librarydb`
* **User:** `sa`
* **Hasło:** *(puste)*