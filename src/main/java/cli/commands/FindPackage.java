package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.packageR.Package;
import stubs.packageR.UnknownPackageException_Exception;

import java.util.List;

public class FindPackage extends Command<DDPublicAPI> {

    private String secretNumber;

    @Override
    public String identifier() {
        return "findPackage";
    }

    @Override
    public void load(List<String> args) {
        secretNumber = args.get(0);
    }

    @Override
    public void execute() throws UnknownPackageException_Exception {
        try {
            Package p = shell.system.packws.findPackage(secretNumber);
            System.out.println("<-------------------/" + "\\------------------------->");
            System.out.println("Num :: " + p.getSecretNumber());
            System.out.println("Poids :: " + p.getWeight());
            System.out.println("Transporteur :: " + p.getProvider().getName());
            System.out.println("Date d'enregistrement :: " + p.getRegisterDate());
            System.out.println("Date de Livraison :: " + p.getDeliveryDate());
            System.out.println("<-------------------/" + "\\------------------------->");
        }catch (UnknownPackageException_Exception e){
            System.out.println("Ce colis n'a pas encore été enregistré !");
        }
    }

    @Override
    public String describe() {
        return "-----> Rechercher un colis";
    }

}
