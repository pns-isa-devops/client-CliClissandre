package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.drone.Exception_Exception;

import java.util.List;

public class RegisterDrone extends Command<DDPublicAPI> {

    private String id;

    @Override
    public String identifier() {
        return "registerDrone";
    }

    @Override
    public void load(List<String> args) {
        id = args.get(0);
    }

    @Override
    public void execute() throws Exception_Exception {
        Boolean rep = shell.system.dws.register(id);
        if (rep) {
            System.out.println("*** Enrégistré ***");
        } else {
            System.out.println("*** Echec de l'enrégistrement ***");
        }
    }

    @Override
    public String describe() {
        return "-----> Enregistrer un nouveau drone";
    }

}
