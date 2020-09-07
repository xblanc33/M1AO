package fr.ubordeaux.ao.infra;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ubordeaux.ao.domain.Basket;
import fr.ubordeaux.ao.domain.BasketRepository;
import fr.ubordeaux.ao.domain.CommandLineDTO;

public class BasketRepositoryJSON implements BasketRepository {
    File targetDirectory;

    public BasketRepositoryJSON(File targetDirectory) {
        this.targetDirectory = targetDirectory;

    }

    @Override
    public void add(Basket basket) {
        String json = "{\n";
        json+= "\t\"id\":"+basket.getId()+",\n";
        List<CommandLineDTO> list = basket.getCommandLineList();
        if (list.size() > 0) {
            json += "\t\"lines\":[\n";
        }
        for (CommandLineDTO line : list) {
            json += "\t\t\"reference\":\""+line.getReference().getName()+"\",";
            json += "\t\t\"quantity\":\""+line.getQuantity()+"\"";
        }
        if (list.size() > 0) {
            json += "\t]\n";
        }
        json += "}";
        
        //TODO
        //write json in a new file within the directory
    }

    @Override
    public Basket findBasketById(int id) {
        //TODO
        //read the file within the directory and build the Basket
        return null;
    }
    
}