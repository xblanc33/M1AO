# TD2
Ce TD a pour objectif de :

* Coder une hierarchie de classes

## Consignes

Les modifications que vous devez apporter au code doivent être compilée (directement en utilisant javac ou gradle)

## SVG

Le code du TD3 est une implantation partielle de [SVG](https://www.w3schools.com/graphics/svg_intro.asp).

* Complétez ce code et proposez une hierarchie de classe réduisant au maximum la redondance de code. Discuter de l'intérêt de votre hierarchie de classe. En outre, maximiser la redondance peut-il nuire à la lecture du code ?
  
    Le code donné en correction réduit au maximum la redondance. Du coup les noms donnés aux propriétés n'ont plus de sens. Par exemple X,Y correspond à la fois au centre du Cercle, au début de la ligne et au coin haut gauche du rectangle ...
    L'intérêt de la hierarchie vient ici de la méthode toSVG() mais aussi de pouvoir ajouter n'importe quelle forme au SVG. Idéalement une super classe (voir même une interface) serait déjà très bien. Pas la peine d'en rajouter.

* Modifiez votre code pour ajouter un moyen d'afficher à l'écran (ou même de sauvegarder dans un fichier) le format SVG correspondant.

    Voir le code. La méthode toSVG prend tout son sens ici.

* Modifiez la classe SVG pour qu'il soit possible d'ajouter des formes : circle, ellipse, line, rectangle. Vous ferez notamment attention à la création des objets et à leurs modifictaions. En outre, vaut-il mieux modifier une forme existante (pour changer sa taille par exemple) ou la remplacer par une nouvelle forme ? 

    Dans le code donné en correction, il n'est pas possible de modifier les Form une fois qu'elles ont été construites. Si on veut modifier une forme, il faut la supprimer et en ajouter une nouvelle. En terme de consommation mémoire cela ne change pas beaucoup. Ce qui change c'est que le changement du SVG réside uniquement dans deux méthode (add et remove de la classe SVG). Si on met des setter sur les form alors tout ces setter peuvent modifier l'image SVG, tracer les modifications devient alors un peu plus complexe. On peut noter que les framework graphique modernes sont en train de privilégier l'ajout et la suppression plutôt que la modification. 
