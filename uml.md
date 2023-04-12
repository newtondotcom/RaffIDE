# UML

```plantuml
@startuml
package "Assistant de raffinages" #DDDDDD {

    abstract Structure {
        - afficher();
    }

    interface Action {
        - addFormat(TextFormat format)
        - removeFormat(TextFormat format)
        - getCouleur()
        - setCouleur(TextColor color)
        - getContenu()
        - getTexteFormate()
        - print()
    }

    abstract StructureDeControle {

    }

    interface Elements {
    }

    class Raffinage {

    }

    class StructureSi {

    }

    class StructureTantQue {

    }

    note right of StructureSi
        Généralisation pour toutes 
        les structures de contrôle 
        connues (Sinon, TantQue, etc.)
    end note


    Raffinage o-- Structure
    StructureDeControle o-- Structure
    StructureTantQue-->StructureDeControle
    StructureSi--> StructureDeControle
    Action-->Structure
    StructureDeControle-->Structure
    Elements--Action
    Raffinage --Action


}
@enduml
```