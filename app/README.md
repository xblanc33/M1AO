# Mise en oeuvre pédagogique des principes du DDD 

Ce projet est une mise en oeuvre pédagogique des principes du [Domain-Driven Design](https://www.amazon.fr/Domain-Driven-Design-Tackling-Complexity-Software/dp/0321125215/ref=pd_sim_14_6?_encoding=UTF8&psc=1&refRID=XWYJW2DSTZ6FM9AYQV3D). Il se base fortement sur l'approche proposée dans [Implementing Domain-Driven Design](https://www.amazon.fr/Implementing-Domain-Driven-Design-Vaughn-Vernon/dp/0321834577/ref=pd_sim_14_1?_encoding=UTF8&psc=1&refRID=779WNDEZ9PV9Y8X8JYMN).

L'application développée est une application simplifiée de type eCommerce. Elle est composée de deux **bounded context** :

* product management : qui gère les références produit ainsi que le stock.
* order management : qui gère les commandes effectuées par les clients.

## Product Management - fr.ubordeaux.ao.productmanagement

Ce bounded context est développé selon une architecture en couches:

* la couche **domain** contient les concepts et services métiers de l'application (Product, Reference, SearchEngine, etc.)
* la couche **application** contient les service d'accès à la couche domain (utilisés par la couche ui)
* la couche **user interface** contient les interfaces utilisateurs de l'application
* la couche **infrastructure** contient les classes d'implémentation et l'adhérence aux plates-formes techniques.

### La couche domain (La couche métier)

Cette couche suit les principes du DDD. Elles est composées de différents ensembles de classes :

* model : qui contient le coeur de l'application constitué des classes métiers et des collections
* type : qui contient les types supports à l'application 
* service : qui contient les services métiers (à le pas confondre avec la couche application qui contient les services d'accès aux objets et services métiers).
* exception : qui contient les exceptions métiers de l'application.

Le model (core business) est relativement simple. Il contient 3 classes métiers et plusieurs collections correspondantes.

Les classes métiers sont :

* Reference : référence d'un produit (id, nom et description). Cette classe représente des **value object**. En effet, une référence produit ne changera pas avec le temps.
* Produit : un produit en stock (qui a un prix et qui est lié à une référence). Cette classe représente des **entity** car un produit (son prix) peut changer.
* KeyWord : un mot clé permettant de retrouver des références. Cette classe représente des **value object** car un mot clé ne change pas avec le temps.

Les types métiers sont :

* Price : un prix est positif. De plus, on peut imaginer qu'on aura une extension permettant de gérer le type de devise du prix (euro ? dollars ? )
* ReferenceId : même si les références métier sont des **value object** (qui n'ont pas d'état) chaque référence est identifié de manière unique. Le type de cette référence doit être clarifié.
* CatalogName : chaque catalogue a un nom (court, sans espace, etc.).

Les collections métiers sont :

* ReferenceRepository : l'ensemble de toutes les références produit.
* ProductRepository : l'ensemble de tous les produits.
* Catalog : un catalogue a un nom et regroupe plusieurs références produit. Un catalogue peut aussi avoir plusieurs sous-catalogue. On a alors une structure arborescente des catalogues avec une seule racine (le catalogue racine).
* KeyWordMap : une table de correspondance entre les KeyWord et les références.

Il est important de noter que toutes les collections sont codées par des interfaces. Leur implantation sont réalisée dans la couche infrastructure. Ainsi, il est possible de coder une implantation résidant en mémoire vive ou une implantation résidant en base de données.

Les services sont :

* SearchEngine : le moteur de recherche est un très bon exemple de service métier. Il propose de chercher des références ou des produits en fonction de plusieurs critères. Il ajoute donc bien de la valeur au métier. 

Les exceptions sont :

* ProductManagementException : Il n'y a qu'une seule exception métier. Cela reste à améliorer. Il est important de noter que cette exception est une RuntimeException !

### La Couche application (Accès aux objets métiers proposés à la couche UI)

Cette couche suit le pattern CQRS. Elle propose donc des command et des query (les query ne sont pas encore implémentées).

Les command se trouvent dans le package command (AddProduct, AddProductToCatalog, AddReference, CreateSubCatalog, MapKeyWord). Elles héritent de la classe Command.

Le package contient aussi les interfaces Gateway et Handler qui gèrent l'exécution des Command. Ces interfaces devront être réalisées par la couche infrastructure.

### La Couche ui

Cette couche propose deux interface utilisateur :

* Une interface en ligne de commande (shell)
* Une interface via les socket (en utilisant netcat)

Les fonctions supportées par ces interfaces utilisateur sont maigres. L'intérêt est uniquement de montrer comment elles sont codées.

### La Couche infrastructure

Cette couche réalise les interfaces des couches Domain et Application. En particulier, elle réalise les collections (persistence) ainsi que la gestion des commandes (command).

Pour illustrer le fait que la couche infrastructure réalise le lien avec le framework technique, deux réalisations des collections sont proposées : une en mémoire qui exploite les collections Java, une en base de donnée qui exploite JDBC.

On pourrait aussi imaginer deux réalisations des commandes : une en mémoire (l'implémentation actuelle) et une exploitant le message queuing (à la RabbitMQ).

## Order Management - fr.ubordeaux.ao.ordermanagement

Ce bounded context est développé selon une architecture en couches:

* la couche **domain** contient les concepts et services métiers de l'application (Order, OrderLine, etc.)
* la couche **application** contient les service d'accès à la couche domain (utilisés par la couche ui)
* la couche **user interface** contient les interfaces utilisateurs de l'application
* la couche **infrastructure** contient les classes d'implémentation et l'adhérence aux plates-formes techniques.

