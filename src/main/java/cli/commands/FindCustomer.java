package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.customer.Customer;
import stubs.customer.UnknownCustomerException_Exception;

import java.util.List;

public class FindCustomer extends Command<DDPublicAPI> {

    private String customerName;

    @Override
    public String identifier() {
        return "findCustomer";
    }

    @Override
    public void load(List<String> args) {
        customerName = args.get(0) + " " + args.get(1);
    }

    @Override
    public void execute(){
        try {
            Customer c = shell.system.cws.findCustomer(customerName);
            System.out.println("<-------------------/" + "\\------------------------->");
            System.out.println("Nom :: " + c.getName());
            System.out.println("Adresse :: " + c.getAddress());
            System.out.println("<-------------------/" + "\\------------------------->");
        }catch (UnknownCustomerException_Exception e) {
            System.out.println("Ce client n'a pas encore été enregistré !");
        }
    }

    @Override
    public String describe() {
        return "-----> Rechercher un client";
    }

}
