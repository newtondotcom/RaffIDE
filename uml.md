```
@startuml
package "Assistant de raffinages" #DDDDDD {

    interface Structure {
       {method} toString();
    }

    interface Action {
        {method} addFormat(TextFormat format)
        {method} removeFormat(TextFormat format)
        {method} getCouleur()
        {method} setCouleur(TextColor color)
        {method} getContenu()
        {method} getTexteFormate()
        {method} print()
    }

    abstract StructureDeControle {
     {field}StructureDeControle()
    add(Structure struct)
    delete(Structure struct)
     setCondition(String s)
    getNom()
   getCondition()
    getCorps()
    }

    class ActionElementaire {
    }

    class ActionComplexe {
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


    Action o-- Structure
    StructureDeControle o-- Structure
    StructureTantQue-->StructureDeControle : extends
    StructureSi--> StructureDeControle : extends
    ActionComplexe--o Structure
    StructureDeControle --> Structure
    ActionElementaire--Action : implements
    ActionComplexe --Action : implements


}
@enduml
```