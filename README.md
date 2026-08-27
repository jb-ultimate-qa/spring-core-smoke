# spring-core-smoke

Test data for the IntelliJ IDEA smoke test cases in Allure TestOps under the components
**Spring. Core** and **Spring. Core. IDE UX**. Future automation will live in
`tests/remote-driver-tests/test/com/intellij/driver/tests/idea/ultimate/spring/` in the
`intellij` monorepo (see AT-5110).

The project exists to be *read* by the IDE. Every class is a deterministic anchor for a
gutter icon, a navigation target, or a completion popup. It does start and run, but no
case requires that.

Java 17, Spring Boot 3.3.5, Maven. There is no `src/test` yet.

```
mvn -q compile
```

## Rules for editing this project

1. **Never rename or retype an anchor.** The cases anchor on source *text* — an
   automated test resolves lines with `editor().getLineNumber("...")` — so reordering
   members is harmless, but changing the text of an annotation, method or field name
   breaks whichever case references it.
2. **Keep the code warning-free.** Several cases assert "no red code". Deliberately
   broken code belongs in the separate `spring_inspections` project, not here.
3. **Generate actions may only be invoked in `ideux/GenerateTarget.java`.** They insert
   fields, methods and whole classes; anywhere else they would shift the lines the
   Spring. Core cases assert on. Every IDE UX case restores the file at the end.
4. **Caret position is significant.** `Generate | Spring Component…` inserts a *live
   template*, so both the offered component types and where the class lands depend on
   the caret: at file level it creates a package-private top-level sibling, inside the
   class body a `static` nested class. Cases state the caret position for that reason.
5. **The profile-name completion baseline is `dev`, `prod`, `test`.** Three Profiles
   cases assert that exact set. It comes from the `@Profile` declarations in
   `profiles/` plus `spring.profiles.active`. Adding another profile name — or an
   `application-{profile}.properties` file, which IDEA also treats as a profile
   declaration — changes the baseline for all three.
6. **`events.basetype.CatchAllApplicationListener` is typed to `ApplicationEvent`,** so
   it is a target of every publisher of an `ApplicationEvent` subclass. Adding another
   catch-all listener changes the popup contents of the base-type Events case. Note it
   does *not* appear as a target for the plain-POJO events in `events/`: at runtime
   Spring wraps those in a `PayloadApplicationEvent`, but the IDE's gutter does not
   link them, which is why the POJO publisher gutter has a single target.
7. **`ideux/GreetingController.java` must stay self-contained.** A generated
   `@SpringBootApplication` in `ideux` component-scans only that package, so any
   dependency on a bean from another package would make it fail to start.
8. **Pin the commit.** Automation references this repository through
   `GitProjectInfo(..., commitHash = "...")`. After changing anything here, update the
   hash wherever the tests declare it.

## What each package anchors

| Package | Allure feature | Anchor |
|---|---|---|
| *(root)* | — | `SpringCoreSmokeApplication` — `@EnableCaching`, `@EnableScheduling`; the only `@SpringBootApplication`, and a "Choose Bean" target in the Profiles case |
| `events` | Events | `publisher` gutter on all three publish forms (direct call, lambda, method reference), `listener` gutter, publisher ↔ listener navigation |
| `events.basetype` | Events | `publisher` gutter on a base-type event offering three listener shapes: `ApplicationListener<MyApplicationEvent>`, `ApplicationListener<ApplicationEvent>`, `@EventListener(ApplicationEvent)` |
| `caching` | Caching | `showCacheable` gutter on `BookService#findBook`; cache-name completion for `books` |
| `config` | Configuration | `@Bean` gutter on `AppConfig#greetingFormatter` ↔ `GreetingClient#greetingFormatter`; `springScan` on `@ComponentScan` |
| `context` | Context | `showAutowiredCandidates` on `EnglishGreetingService`; `showAutowiredDependencies` on `GreetingClient` fields; `@Primary` vs `@Qualifier` |
| `profiles` | Profiles | completion of `dev` / `prod` / `test` inside `@Profile("")`; expressions (array, negation); the Spring Profiles panel |
| `scheduled` | Scheduled | cron completion; `${report.cron}` → `application.properties` navigation and placeholder folding |
| `async` | Async | `@Async("mailExecutor")` → `AsyncConfig#mailExecutor` |
| `tx` | Transactions | `@Transactional(transactionManager = "txManager")` → `TxConfig#txManager` |
| `ideux` | Spring. Core. IDE UX | `GenerateTarget` — the only place generate actions may be invoked; `BookRepository` for the "Show Repositories" filter; `GreetingController` for Request Mapping generation |

## Known limits of this fixture

- **No Spring Data starter and no `@Entity` classes**, so `Repository` is not offered by
  either component-creation flow. Repository-specific creation cannot be covered here;
  it belongs to Spring Data JPA / Mongo.
- **No Spring XML configuration**, so the `Spring Setter Dependency…` and
  `Spring Constructor Dependency…` generate actions never appear — both are gated on a
  Spring XML config in the module.
- **`spring-boot-starter-web` is required** by `ideux/GreetingController`. Dropping it
  would remove the Request Mapping coverage along with Tomcat.
