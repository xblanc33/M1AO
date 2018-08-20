# TD5

Ce TD a pour objectif de :

* Réaliser les corrections proposées par un linter
* Coder un test d'acceptation
* Coder un test Unitaire

## Consignes

Les modifications que vous devez apporter au code doivent être compilée (directement en utilisant javac ou gradle)

## Linter

Exécuter le linter Checkstyle

    gradle checkstyleMain

Réalisez les recommandations qu'il vous propose pour la classe **Reference.java**. Pour lire les recommandations, il faut aller dans le répertoire **build/reports**

    Voir fichier Reference.java pour les corrections.

Exécuter le linter Findbugs

    gradle findbugsMain

Réalisez les recommandations **Correctness Warnings** qu'il vous propose. Pour lire les recommandations, il faut aller dans le répertoire **build/reports**

    C'est le fichier CatalogImpl.java qui contient un erreur dans le contructeur. En effet on a créé un variable locale au constructeur **references**. Voir le code pour.


## Test d'acceptation

En reprenant le code du TD4, testez les scénarios suivants :

* Ajout d'une référence dans le catalogue
* Recherche d'une référence

    Dans le code il y a un petit test d'acceptation. On voit que le but n'est pas de mettre en défaut le code mais de vérifier que tout va bien sur un comportement normal.

## Test Unitaire

Vous allez changer l'interface Catalog et sa classe d'implantation CatalogImpl pour faire en sorte qu'un catalogue respecte les besoins suivants:

* Un catalogue a un nom (composé uniquement de lettres minuscules, minimum 3 lettres maximum 10 lettres)
* Un catalogue peut avoir plusieurs sous-catalogues
* Les noms des catalogues frères (sous-catalogues d'un même catalogue) doivent avoir des noms différents
* On peut obtenir la liste des références contenues directement par un catalogue (getOwnReferences) ou avoir les références contenues par un catalogue et toute sa descendance (getAllReferences)  
  
Tester Unitairement la classe Catalogue en veillant à ce que les besoins soient bien respectés.

    Dans le code il y a maintenant un nouveau type (CatalogName) et son test unitaire associé qui tente de mettre la contrainte en défaut. Ensuite il y a un test unitaire sur InMemoryCatalog qui lui aussi tente de mettre la classe CatalogImpl en défaut. D'ailleurs si on enlève le commentaire, le test ne marche pas. Ce qui veut dire que la classe est mal codée ...