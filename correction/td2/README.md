# TD2

Ce TD a pour objectif de :

* Mesurer l'importance de l'encapsulation
* Mettre en pratique les notions le typage

## Consignes

Les modifications que vous devez apporter au code doivent être compilée (directement en utilisant javac ou gradle)

## Notion de typage

On veut améliorer l'application et surtout son typage.

* Changez le code pour que le type la date d'une transaction ne soit pas une chaîne de charactère (String) mais une réelle date. De plus on veut que la date soit fixé au jours de la création d'une transaction.

    il faut passer par la classe java.util.Date (voir code)

* Changez le code pour que le type d'un montant ne soit pas un double mais un entier positif (on considère que c'est la valeur en centime d'euros). On pourrait même lever une exception (IllegalArgumentException) lors de la création si le montant est égal à zéro.

    voir le code. 


## Account et Transaction

Le code du TD2 est celui d'une application permettant à un particulier de faire une tenue de ses comptes banquaires. La classe Account représente un compte banquaire (entity). La classe Transaction représente une transaction banquaire (value).

* Quel est l'état de la classe Account (quelles propriétés peuvent changer) ? Coder la méthode commentée //TODO_1 de cette classe en vous assurant que l'état de la classe ne peut pas être changé à l'extérieur de la classe.

    Dans la classe Account **balance** et **transactions** sont les deux propriétés qui peuvent changer. Les propriétés **id** et **name** ne changent pas avec le temps. Donc on peut dire que l'état est constitué de ces deux propriétés (balance et transactions).

    Coder le //TODO_1 nécessite de renvoyer une copie de l'ensemble des transactions. Si on ne renvoit pas une copie alors les transactions pourraient être modifiées à l'extérieur de l'objet. On violerait alors le principe d'encapsulation. Notons qu'il n'est pas nécessaire de copier les transactions car celles-ci ne peuvent pas changer (elles sont des value object).

* L'identifiant des objets Account est codé par la propriétée String id. De fait, pensez-vous que deux objets Account peuvent avoir le même id ? Si tel est le cas, comment s'assurer que cela n'arrivera pas ?

    Oui il est tout à fait possible de construire (new) deux Account en leur donnant le même id. Pour se protéger de ce cas, il faut alors interdir l'instantiation (rendre le constructeur privé) et par exemple coder une factory méthode. 

* Coder les //TODO_2 de la classe Transaction. Pourquoi cette classe ne possède pas de méthodes publiques permettant de changer les valeurs des propriétés ?

    Cette classe représente des **Value Object**, une fois créé, la Transaction ne doit pas changer. Il ne faut donc pas mettre de méthode permettant de changer les propriétés !

* Codez le //TODO_3 de la classe Account pour mettre à jours le solde (balance) du compte.
    Voir le code.

## Notions avancées

* Dans la classe Account, la méthode addTransaction(Transaction transaction) peut-elle être changée par la méthode addTransaction(String titre, int montant) ? Quelle différence cela fait-il ?

    Oui c'est possible. Au niveau du comportement de l'application cela ne change rien. Par contre, avec addTransaction(String titre, int montant) on change un peu la signification de la méthode qui ne fait pas seulement l'ajout de la transaction mais qui réalise aussi la construction de l'objet. De fait le nommage de cette méthode serait un peu innaproprié. De plus, on pourrait vouloir mettre dans le code de cette méthode des contrôles visant à s'assurer que l'on peut instancier l'objet. Bref, du coup, ce n'est pas vraiment idéal. 

* Modifiez le code pour qu'il soit possible de supprimer une transaction d'un compte mais uniquement en donnant sa date, son titre et son montant.
  
   Comme les Transactions sont des value object, il est possible de les comparer par valeur (et non pas par référence). Il faut redéfinir la méthode equals (et donc ajouter un id à la transaction) ce qui permet alors de l'exploiter la méthode remove de la collection. (voir code et les tests)