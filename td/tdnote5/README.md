# TD Noté

Pour réaliser ce TD noté vous devez corriger le code source qui vous est donné afin que les 4 tests passent.

## Contexte

Le code donné (répertoire main) correspond à une application permettant de gérer des catalogues de références. Le métier de cette application (package domain) est constitué des classes que vous avez manipulé en TP:

* Catalog: Cette classe représente un catalogue de références et peut contenir des sous-catalogues.
* Reference: Cette classe représente une référence de produit.

et un service:

* SearchEngine: Cette classe permet de retrouver des références par nom ou ID.

Chacune de ces trois classes dispose d'une classe de test qui contient le ou les tests unitaire pour la classe.

## La classe CatalogImplTest (2 Tests)

Cette classe contient deux tests unitaires pour la clase Catalog et CatalogImpl (infrastructure).

Le test **shouldPreserveIntegrity** vérifie le principe de l'encapsulation et visiblement celui-ci n'a pas été respecté.

Le test **shouldNotHaveSubCatalogsWithSameName** vérifie qu'un catalogue ne peut pas avoir deux sous-catalogues contenant le même nom. Le code donné contient une erreur qui permet cela.

## La classe ReferenceTest (1 Test)

Cette classe contient un test unitaire pour la classe Reference.

Le test **shouldTestValuesTypes** vérifie que les vérifications sur les types sont faites (ie. que l'on ne peut pas avoir de prix négatif).

## La classe SearchEngineTest (1 Test)

Cette classe contient un test unitaire pour la classe SearchEngine

Le test **shouldFindReference** vérifie que le moteur de recherche fonctionne comme il le devrait en renvoyant les bonnes références ou null s'il ne la trouve pas.

## Consignes

Pour exécuter les tests vous devez utiliser la commande gradle :

    gradle test

Gradle construira le rapport de résultat montrant que les 4 tests ont tous échoué.

Charge à vous de corriger le code pour que ces tests passent.

Vous ne devez pas toucher au code des tests.
