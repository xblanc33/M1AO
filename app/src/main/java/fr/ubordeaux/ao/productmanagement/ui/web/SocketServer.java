package fr.ubordeaux.ao.productmanagement.ui.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.application.command.AddReference;
import fr.ubordeaux.ao.productmanagement.domain.application.command.Gateway;
import fr.ubordeaux.ao.productmanagement.domain.application.command.LinkKeyWordToReference;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.Catalog;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.CollectionManager;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.KeyWord2ReferenceLinkMap;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.ProductRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.ReferenceRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord2ReferenceLink;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.model.service.SearchEngine;
import fr.ubordeaux.ao.productmanagement.domain.model.type.CatalogName;
import fr.ubordeaux.ao.productmanagement.domain.model.type.ReferenceId;
import fr.ubordeaux.ao.productmanagement.infrastructure.command.GatewayImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.command.HandlerImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.CatalogImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.KeyWord2ReferenceLinkMapImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.ProductRepositoryImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.ReferenceRepositoryImpl;

public class SocketServer {
    final int PORT_NUMBER = 8080;
    private Gateway gateway;
    private ServerSocket serverSocket;
    private PrintWriter out;
    private BufferedReader in;

    public SocketServer() {
        try {
            initCollectionManager();
            createCommandGatewayAndHandler();
            createSocket();
            handleClient();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    private void initCollectionManager() {
        Catalog rootCatalog = new CatalogImpl(new CatalogName("root"));
        ProductRepository productRepository = new ProductRepositoryImpl();
        ReferenceRepository referenceRepository = new ReferenceRepositoryImpl();
        KeyWord2ReferenceLinkMap linkMap = new KeyWord2ReferenceLinkMapImpl();
        CollectionManager.createInstance(rootCatalog, productRepository, referenceRepository, linkMap);
    }

    private void createCommandGatewayAndHandler() {
        gateway = new GatewayImpl();
        gateway.addCommandHandler(new HandlerImpl());
    }

    private void createSocket() throws IOException {
        serverSocket = new ServerSocket(PORT_NUMBER);
    }

    private void handleClient() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New Client connected");
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            handleUserInstructions();
        }
    }

    public void handleUserInstructions() throws IOException {
        boolean end = false;
        while (!end) {
            out.println("(1) ajoute une nouvelle référence, (2) lie un mot clé à une référence, (3) ajoute un nouveau produit, (4) ajoute un produit au catalog, (5) quitter");
            out.println("Your choice 1-4:");
            String choice = in.readLine();
            switch (choice) {
                case "1" : createReference();
                            break;
                case "2" : linkKeyWord();
                            break;
                /*case "3" : createProduct();
                            break;
                case "4" : addProductToCatalog();
                            break;*/
                case "5" : end = true;
                default : 
            }
        }
    }

    public void createReference() throws IOException {
        out.println("You ask to create a new reference !");
        out.println("Reference name : ");
        String refName = in.readLine();
        out.println("Reference description : ");
        String refDescription = in.readLine();
        ReferenceId refId =  new ReferenceId();
        gateway.pushCommand(new AddReference(new Reference(refId, refName, refDescription)));
        out.println("Reference ("+refId+") should be created soon !");
    }

    public void linkKeyWord() throws IOException {
        out.println("You ask to create link a (new) KeyWord !");
        out.println("KeyWord name : ");
        String keyWord = in.readLine();
        out.println("Reference name : ");
        String refName = in.readLine();
        
        SearchEngine searchEngine = new SearchEngine();
        Set<Reference> foundReferences = searchEngine.searchReferencesByName(refName);

        for (Reference reference : foundReferences) {
            gateway.pushCommand(new LinkKeyWordToReference(new KeyWord2ReferenceLink(new KeyWord(keyWord), reference)));
            out.println("Reference ("+reference.getId()+") should be linked soon with the keyword "+keyWord+"!");
        }

    }

    public static void main(String[] args) {
        SocketServer socSer = new SocketServer();
        
    }
    
}