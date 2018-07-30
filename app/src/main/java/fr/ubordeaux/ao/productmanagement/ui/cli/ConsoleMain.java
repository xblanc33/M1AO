package fr.ubordeaux.ao.productmanagement.ui.cli;

import java.util.Scanner;
import java.util.Set;


import fr.ubordeaux.ao.productmanagement.application.command.AddReference;
import fr.ubordeaux.ao.productmanagement.application.command.Gateway;
import fr.ubordeaux.ao.productmanagement.application.command.AddSemanticLink;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.CollectionManager;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.service.SearchEngine;
import fr.ubordeaux.ao.productmanagement.domain.type.CatalogName;
import fr.ubordeaux.ao.productmanagement.domain.type.ReferenceId;
import fr.ubordeaux.ao.productmanagement.infrastructure.command.GatewayImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.command.HandlerImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.CatalogImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.SemanticLinkMapImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.ProductRepositoryImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.ReferenceRepositoryImpl;




public class ConsoleMain {
    private static Gateway gateway;
    private static Scanner scanner;

    public static void main(String[] args) {
        createCollections();
        createCommandGatewayAndHandler();
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("(1) ajoute une nouvelle référence, (2) lie un mot clé à une référence, (3) ajoute un nouveau produit, (4) ajoute un produit au catalog, (5) quitter");
            System.out.println("Your choice 1-4:");
            String choice = scanner.nextLine();
            handleUserInstruction(choice);
        }
        /*addSomeReferences(gateway);
        addSomeKeyWords(gateway);
        addSomeProducts(gateway);
        addSomeProducts2Catalog(gateway);
        performSomeSearches();*/
    }

    private static void createCollections() {
        CollectionManager.createInstance(new CatalogImpl(new CatalogName("root")), new ProductRepositoryImpl(), new ReferenceRepositoryImpl(), new SemanticLinkMapImpl());
    }

    private static void createCommandGatewayAndHandler() {
        gateway = new GatewayImpl();
        gateway.addCommandHandler(new HandlerImpl());
    }

    public static void handleUserInstruction(String instruction) {
        switch (instruction) {
            case "1" : createReference();
                        break;
            case "2" : linkKeyWord();
                        break;
            /*case "3" : createProduct();
                        break;
            case "4" : addProductToCatalog();
                        break;*/
            case "5" : System.exit(0);
            default : 
        }
    }

    public static void createReference() {
        System.out.println("You ask to create a new reference !");
        System.out.println("Reference name : ");
        String refName = scanner.nextLine();
        System.out.println("Reference description : ");
        String refDescription = scanner.nextLine();
        ReferenceId refId =  new ReferenceId();
        gateway.pushCommand(new AddReference(new Reference(refId, refName, refDescription)));
        System.out.println("Reference ("+refId+") should be created soon !");
    }

    public static void linkKeyWord() {
        System.out.println("You ask to create link a (new) KeyWord !");
        System.out.println("KeyWord name : ");
        String keyWord = scanner.nextLine();
        System.out.println("Reference name : ");
        String refName = scanner.nextLine();
        
        SearchEngine searchEngine = new SearchEngine();
        Set<Reference> foundReferences = searchEngine.searchReferencesByName(refName);

        for (Reference reference : foundReferences) {
            gateway.pushCommand(new AddSemanticLink(new KeyWord(keyWord), reference));
            System.out.println("Reference ("+reference.getId()+") should be linked soon with the keyword "+keyWord+"!");
        }

    }
}