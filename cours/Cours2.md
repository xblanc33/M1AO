# Cours n°2 : Les classes

## Rappels (10 min) :
Objet :
* Identifiant 
* Traitement 
* Etat 

Les objets communiquent par échange de messages

Les objets existent dans la VM.

## principes de base

### Description d'un objet  (10 min)

Comment décrire:
=> l'id
=> l'état
=> le comportement

En extension:
```javascript
let o1 = {}; //JavaScript donne un id à cet objet, la variable o1 le référence
o1.a = 0 ; //maintenant l'objet à un état
o1.foo = function() { return this.a;}; //maintenant l'objet à des traitements
```

Par définition, en définissant sa classe

### La Classe – description de plusieurs objets (20 minutes)

Une classe définit une **classe** d'objets.

L'objet appartient à la classe si son état et ses traitements correspondent à ce que décrit la classe.
En fait, la classe est surtout un moule qui permet de construire des objets conformes.

Essentiellement une liste d’opérations avec le code + et une liste d’attributs

```java
public class Pile {
	int[] places;
	int curseur;
	
	public void empiler(int nb) {
		if (curseur < places.length) places[curseur++] = nb;
	}
	public int depiler() {
		if (curseur >0) return places[--curseur];
		else return 0;
	}
	public Pile(){
		places = new int[10];
		curseur = 0;
	}
}
```

### Visibilité public et private (20 minutes)
accès depuis .... sur un membre	private	public
la classe elle-même	OUI	OUI
Les autres	NON	OUI

Règles de bonne pratiques :
Blanc : attribut private, pas d’accesseur et de modificateur 
Vert : attribut private, accesseur si besoin, pas de modificateur 
Rouge : attribut private, accesseur et modificateur si besoin
 Noir : attribut private, accesseur et modificateur par défaut

### L’instantiation & Classe Main (20 minutes)
Rappeler qu’il faut toujours un main (initialisation d’une application).
On met le main dans une classe à part.

```java
public class PileMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PileItf p = new Pile();
		p.empiler(3);
		p.empiler(4);
		System.out.println("on dépile "+p.depiler());
		System.out.println("on dépile "+p.depiler());
		System.out.println("on dépile "+p.depiler());
		p.empiler(4);
		System.out.println("on dépile "+p.depiler());
	}

}
```

### Le typage

Les types des propriétés sont des contraintes sur les valeurs contenues dans les objets.

Plus c'est typé plus on "sait" ce que contient la valeur, moins on fait de faute (est-ce vraiment réel ? il y a des papiers de recherche la dessus)

## Evolution du code

La classe est l'élément premier du code.

Les variables sont typées par des classes.

Il faut pouvoir modifier les classes "sans tout casser".

### Héritage (20 minutes)

L'héritage est une relation entre classes. C'est une relation ensembliste. La sous classe est inclue dans la super classe.
Donc les objets sont plus spécifiques. Ils peuvent faire plus de choses ;)

On hérite pour :
* Factoriser du code (pull-up method). Les arbres d’héritage poussent par les feuilles.
* Réutiliser du code (j’hérite d’une classe qui fait quasiment ce que je veux)
* Collaborer avec un autre développeur que je ne connais pas encore (je décris une classe et il va en hériter). Coder pour être réutiliser.
* 
Attention en Java, l’héritage multiple n’est pas autorisé.

### Polymorphisme (20 minutes)
Une classe fille peut définir un nouveau code pour une des opérations définies dans sa classe mère. On parle alors de polymorphisme. Remarque, c’est l’objet qui exécute l’opération et non pas la classe. Un objet a un type (celui qui a permis son instanciation). Selon le type de l’objet, la bonne opération sera alors exécutée.

### Surcharge (20 minutes)
La surcharge c’est quand deux opérations ont le même nom mais pas les mêmes paramètres.


## Illustration
Faire un mini exercice : Des concessionaires de voitures de location
* Un objet par concession, 
* un objet par voiture

On veut coder une recherche de voiture d'un certain type, la plus proche de chez soi.


Ex : Centre de voiture de location (Un objet par centre, un objet par voiture, une pile par centre).
Trouver un véhicule libre chez les voisins.

## Synthèse (10 minutes)
Id+Données+Traitement
Classe pour programmer les objets
Héritage
Polymorphisme et surcharge
