# TD5

Ce TD a pour objectif de :

* Coder un test Unitaire
* Réaliser les corrections proposées par un linter

## Consignes

Les modifications que vous devez apporter au code doivent être compilée (directement en utilisant javac ou gradle)

## Test Unitaire

Vous allez changer l'interface Catalog et sa classe d'implantation CatalogImpl pour faire en sorte qu'un catalogue respecte les besoins suivants:

* Un catalogue a un nom (composé uniquement de lettres minuscules, minimum 3 lettres maximum 10 lettres)
* Un catalogue peut avoir plusieurs sous-catalogues
* Les noms des catalogues frères (sous-catalogues d'un même catalogue) doivent avoir des noms différents
* On peut obtenir la liste des références contenues directement par un catalogue (getOwnReferences) ou avoir les références contenues par un catalogue et toute sa descendance (getAllReferences)  
  
Tester Unitairement la classe Catalogue en veillant à ce que les besoins soient bien respectés.

    Dans le code il y a maintenant un nouveau type (CatalogName) et son test unitaire associé qui tente de mettre la contrainte en défaut. Ensuite il y a un test unitaire sur InMemoryCatalog qui lui aussi tente de mettre la classe CatalogImpl en défaut. D'ailleurs si on enlève le commentaire, le test ne marche pas. Ce qui veut dire que la classe est mal codée ...

## Linter

Exécuter le linter Checkstyle

    gradle checkstyleMain

Réalisez les recommandations qu'il vous propose pour la classe **Reference.java**. Pour lire les recommandations, il faut aller dans le répertoire **build/reports**

    Voir fichier Reference.java pour les corrections.

Exécuter le linter SpotBug

    gradle spotbugsMain

Réalisez les recommandations **Correctness Warnings** qu'il vous propose. Pour lire les recommandations, il faut aller dans le répertoire **build/reports**

    C'est le fichier CatalogImpl.java qui contient un erreur dans le contructeur. En effet on a créé un variable locale au constructeur **references**. Voir le code pour.



