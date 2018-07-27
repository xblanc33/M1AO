# TD1

Ce TD a pour objectif de :

* Connaitre et exécuter Javac
* Connaitre et exécuter Gradle
* Mieux comprendre les différents types d'objets

## Javac & Java

En utilisant Javac, compilez le code situé dans le répertoire td1/src/main/java et faites en sorte que les classes compilées se retrouvent dans le répertoire td1/classes:

    javac .\src\main\java\fr\ubordeaux\ao\*.java -d classes

En utilisant Java, exécutez le code que vous venez de compiler:
    
    java -cp ./classes fr.ubordeaux.ao.Main

## Gradle

En utilisant Gradle, compiler le code du TD1

    gradle compileJava

En utilisant Gradle, exécuter le test du TD1

    gradle test

## Rôle des classes (Architecture DDD)

En regardant le code du TD1, précisez le rôle (value, entity, aggregate, repository) de chaque classe en vous aidant du tableau suivant.

| Classe de l'objet | Value ? | Entity ? | Aggregate | Repository |
| ------------------|---------|----------|-----------|------------|
| Address           |         |          |           |            |
| Contact           |         |          |           |            |
| Contacts          |         |          |           |            |
| Mail              |         |          |           |            |
| PhoneNumber       |         |          |           |            |
| Town              |         |          |           |            |

## Objets et Machine Virtuelle

Nous allons utiliser les outils **jps**, **jmap** et **jhat** pour analyser la machine virtuelle Java et compter le nombre d'objets Java créés.

### JPS

L'utilitaire **jps** permet d'identifier les programmes Java en cours d'exécution. Chaque programme est identifié par un numéro. Exécutez le TD1 puis dans une autre console de votre shell, exécutez jps pour connaître le numéro du programme.

Dans l'exemple suivant, l'exécution du TD1 s'appelle **Main** et est identifiée par le numéro **82148**.

    Shell1:> java -cp ./classes fr.ubordeaux.ao.Main
    3000 contacts created ! 

    Shell2:> jps
    49572 org.eclipse.equinox.launcher_1.5.100.v20180611-1436.jar
    82148 Main
    33528 Jps

### JMAP

L'utilitaire **jmap** permet de construire un dump d'une exécution et de la sauver dans un fichier pour analyser l'état de la machine Virtuelle.

En continuant l'exemple, et toujours pendant que le TD1 s'exécute, l'exécution de **jmap** construit un dump de la machine virtuelle et le sauve dans le fichier **C:/tmp/x.dmp**

    Shell2:> jmap -dump:file=C:/tmp/x.dmp 82148

### JHAT

Enfin, l'utilitaire **jhat** propose des analyses du fichier dump et permet notamment de compter le nombre d'objets construits.

En continuant l'exemple, l'utilitaire **jhat** lance un serveur web sur le port 7000 qui présente les analyses de la machine virtuelle.

    Shell2:> jhat C:/tmp/x.dmp
    Reading from C:\tmp\x.dmp...
    Dump file created Thu Jul 26 20:24:03 CEST 2018
    Snapshot read, resolving...
    Resolving 42227 objects...
    Chasing references, expect 8 dots........
    Eliminating duplicate references........
    Snapshot resolved.
    Started HTTP server on port 7000
    Server is ready.

Avec mon navigateur web (Chrome), il est possible d'ouvrir la page **http://localhost:7000** et ainsi voir le résultat de l'analyse.

[image de l'analyse](./jhat.png)
