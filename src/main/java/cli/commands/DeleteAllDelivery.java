package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.customer.Customer;
import stubs.customer.UnknownCustomerException_Exception;

import java.util.List;

public class DeleteAllDelivery extends Command<DDPublicAPI> {


    @Override
    public String identifier() {
        return "deleteD";
    }

    @Override
    public void load(List<String> args) {
    }

    @Override
    public void execute(){
        Boolean rep = shell.system.dews.deleteAll();
        System.out.println("Delete ===> "+rep);
    }

    @Override
    public String describe() {
        return "-----> Supprimer toutes les livraisons";
    }

}
