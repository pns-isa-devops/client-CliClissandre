package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.provider.AlreadyExistingProviderException_Exception;

import java.util.List;

public class RegisterProvider extends Command<DDPublicAPI> {

    private String name;


    @Override
    public String identifier() {
        return "registerProvider";
    }

    @Override
    public void load(List<String> args) {
        int l = args.size();
        name = args.get(0);
        for (int i = 1; i < l; i++) {
            name = name + " " + args.get(i);
        }
    }

    @Override
    public void execute() {
        try {
            Boolean rep = shell.system.pws.register(name);
            System.out.println("*** Enrégistré ***");
        } catch (AlreadyExistingProviderException_Exception e) {
            System.out.println("*** Echec de l'enrégistrement ***");
        }
    }

    @Override
    public String describe() {
        return "-----> Enregistrer un nouveau transporteur";
    }

}
