# Cours n°1 : Les objets

## Clarification Administrative (10 min) :

Objectif du cours : 
* Comprendre ce qu’est une conception Orienté Objet (vs Algorithmique)
* Connaître les concepts de conception objet (classe abstraite, interface, design pattern)
* Voir les principes du Clean Code
* Savoir Tester des applications OO
* Voir les principes du DDD
* Comprendre le lien avec les bases de données
* Comprendre le lien avec les interfaces web (REST ou Graphique)

Organisation Cours / TD : 
* Un TD par cours.
* Contrôle continu : 
  * Contrôle surprise 
  * un TP noté.


## L’objet (40 minutes)

### Principes de base (10 minutes)

Un objet c'est :
* Id 
* Traitement 
* Etat

L'égalité en java `==`, c'est une égalité d'id.

### Messages et références (10 minutes)

Les objets communiquent entre eux par échange de messages:
* Un message est envoyé par un objet à destination d'un autre objet. Il faut donc que l'objet qui envoie le message, connaise l'id du destinataire.
* Le message principal est une demande de réalisation de traitement.
* Le message précise le nom du traitement et donne les données nécessaires à la réalisation du traitement.
* Dans la réponse on donne le résultat du traitement.

Synchrone : Les messages sont envoyés de manière synchrone. Lorsqu'un objet envoie un message, il attend et ne fait rien d'autre tant qu'il n'a pas reçu la réponse.

### Création d’objets, références d’objets (10 minutes)
Un objet a un cycle de vie : 
1. il est créé (instanciation), 
2. il répond aux messages qu’on lui envoie,
3. il est détruit. 

Tout objet peut construire un autre objet ! 
L’objet créateur est le seul à initialement connaitre l’identifiant de l’objet créé.
Pour que d’autres objets utilisent l’objet construit, il faut alors que l’objet créateur leur donne la référence.

## L’application

### La classe Main (10 minutes)
Le main d’une application correspond au démarrage de l’application.
1. Instanciation d’objets. 
2. Echanges de références. 
3. Envoi des premiers messages.

L’interface graphique est un ensemble d’objets qui savent recevoir des messages venant de la machine et qui font suites à des interactions d'utilisateur (click, etc.).

## Conception des objets (10 minutes)

### Identification des objets (10)
Lorsqu'on concoit une application il faut préciser :
1. quels sont les objets ?
2. quelles sont leurs états
3. quelles sont les traitements qu’ils savent réaliser.

### Responsabilité / Cohérence

Un objet est responsable des traitements qu'il propose : il détient toutes les informations pour réaliser ces traitements.

Le traitement réalisé par un objet dépend de l’état de cet objet.
L'état de l'objet lui sert à bien réaliser les traitements qu'il propose. 
Un objet cohérent possède les données nécessaires et suffisante à la réalisation des traitements qu'il propose.

L’objet contrôle donc les accès à son état. Idéalement, l’état d’un objet est inaccessible. Il gouverne sa cohérence.

### Couplage

Un objet peut faire appel à d'autres objets pour réaliser les traitements qu'il propose. 

Les id de ces objets doivent donc faire partie de l'état de l'objet.

Plus un objet à besoin d'autres objets pour réaliser les traitements dont il est responsable, plus il dépend de ces objets, il y est couplé, il est donc moins responsable.

### Optimisation

Un conception objet est donc un optimisation cohérence / couplage !

L'objet est d'optimiser le nombre d'objet et le nombre de message échangés.

## Synthèse (10 minutes)
* Id+Données+Traitement
* Cohérence / Couplage
* Conception = Cohérence vs Couplage / Optimisation