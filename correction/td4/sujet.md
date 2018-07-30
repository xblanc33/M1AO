# TD4
Ce TD a pour objectif de :

* Coder une application en suivant l'achitecture hexagonale
* Rendre indépendant l'insfrastructure

## Consignes

Les modifications que vous devez apporter au code doivent être compilée (directement en utilisant javac ou gradle)

## Catalogue de Références, et stock de produits

Dans ce TD vous allez développer le catalogue de références d'un magasin de eCommerce ainsi que le stock de ses produits.

## Couche domain

La couche model contient les concepts métiers suivants:

* Reference : Une référence produit (id, nom, description)
* Produit : Un produit en stock (id, référence, prix, état)
* Catalog : le catalogue des références
* Stock : la liste des produits en stock

De plus, cette couche propose le service suivant:

* SearchEngine : qui permet de retrouver des références ou des produits selon différents critère (par id, par référence, par prix, par état, etc.)

## Couche application

La couche application suit les principes CQRS et prose donc :

* des commandes (création d'une référence, création d'un produit, etc.)
* des query (naviguer dans la liste des références, des produits, etc.)

## Couche infrastructure

Cette couche se fera en mémoire. Elle contient donc les classes d'infrastructure permettant de gérer en mémoire vive le catalogue et le stock.

## Couche UI

Cette couche se fera en ligne de commande. Elle proposera une interaction simple permettant à un utilisateur d'intéragir avec l'application.

