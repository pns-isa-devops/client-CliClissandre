package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.packageR.AlreadyExistingPackageException_Exception;
import stubs.packageR.Provider;
import stubs.packageR.UnknownProviderException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RegisterPackage extends Command<DDPublicAPI> {

    private String number;
    private String provider;
    private double weight;
    private String deliveryDate;
    private String deliveryHour;

    @Override
    public String identifier() {
        return "registerPackage";
    }

    @Override
    public void load(List<String> args) {
        number = args.get(0);
        provider = args.get(1);
        weight = Double.parseDouble(args.get(2));
        deliveryDate = args.get(3);
        if (deliveryDate.equals("TODAY")){
            deliveryDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        deliveryHour = args.get(4);
    }

    @Override
    public void execute() {
        try {
            Provider p = shell.system.packws.findProvider(provider);
            Boolean rep = shell.system.packws.registerPackage(number, weight, deliveryDate + " " + deliveryHour, p.getName());
            System.out.println("*** Enrégistré ***");
        } catch (UnknownProviderException e) {
            System.out.println("*** Transporteur non Connu !***");
        } catch (AlreadyExistingPackageException_Exception e) {
            System.out.println("*** Echec de l'enrégistrement ***");
        }
    }

    @Override
    public String describe() {
        return "-----> Enregistrer un nouveau colis";
    }

}
