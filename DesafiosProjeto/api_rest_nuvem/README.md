
## Diagrama de classes

```mermaid

classDiagram
    class User {
        +String name
    }

    class Account {
        +String number
        +String agency
        +double balance
        +double limit
    }

    class Feature {
        +String icon
        +String description
    }

    class Card {
        +String number
        +double limit
    }

    class News {
        +String icon
        +String description
    }

    User --> Account : has
    User --> Feature : has multiple
    User --> Card : has
