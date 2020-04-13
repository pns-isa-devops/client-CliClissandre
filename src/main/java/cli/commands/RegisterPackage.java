package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.packageR.Provider;

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
        deliveryHour = args.get(4);
    }

    @Override
    public void execute() {
        Provider p = shell.system.packws.findProvider(provider);
        if (p !=null){
            Boolean rep = shell.system.packws.register(number, weight, deliveryDate + " " + deliveryHour, p);
            if (rep) {
                System.out.println("*** Enrégistré ***");
            } else {
                System.out.println("*** Echec de l'enrégistrement ***");
            }
        }else{
            System.out.println("*** Transporteur non Connu !***");
        }
    }

    @Override
    public String describe() {
        return "-----> Enregistrer un nouveau colis";
    }

}
