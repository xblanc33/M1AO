# TD2
Ce TD a pour objectif de :

* Mesurer l'importance de l'encapsulation
* Mettre en pratique les notions le typage

## Consignes

Les modifications que vous devez apporter au code doivent être compilée (directement en utilisant javac ou gradle)

## Account et Transaction

Le code du TD2 est celui d'une application permettant à un particulier de faire une tenue de ses comptes banquaires. La classe Account représente un compte banquaire (entity). La classe Transaction représente une transaction banquaire (value).

* Quel est l'état de la classe Account (quelles propriétés peuvent changer) ? Coder la méthode commentée //TODO_1 de cette classe en vous assurant que l'état de la classe ne peut pas être changé à l'extérieur de la classe.
* L'identifiant des objets Account est codé par la propriétée String id. De fait, pensez-vous que deux objets Account peuvent avoir le même id ? Si tel est le cas, comment s'assurer que cela n'arrivera pas ?
* Coder les //TODO_2 de la classe Transaction. Pourquoi cette classe ne possède pas de méthodes publiques permettant de changer les valeurs des propriétés ?
* Codez le //TODO_3 de la classe Account pour mettre à jours le solde (balance) du compte.

## Notion de typage

On veut améliorer l'application et surtout son typage. 

* Changez le code pour que le type la date d'une transaction ne soit pas une chaîne de charactère (String) mais une réelle date. 
* Changez le code pour que le type d'un montant ne soit pas un double mais un nombre décimal avec au plus deux chiffres après la virgule. On pourrait même intégrer la notion de devise (euro, dollars, etc.). Vous pouvez vous inspirer de la classe Amount.
 
## Notions avancées

* Dans la classe Account, la méthode addTransaction(Transaction transaction) peut-elle être changée par la méthode addTransaction(String id, String titre, double montant) ? Quelle différence cela fait-il ?
* Modifiez le code pour qu'il soit possible de supprimer une transaction d'un compte mais uniquement en donnant sa date, son titre et son montant.