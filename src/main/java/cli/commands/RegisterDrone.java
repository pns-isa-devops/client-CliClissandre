package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.drone.ParseException_Exception;

import java.util.List;

public class RegisterDrone extends Command<DDPublicAPI> {

    private String id;
    private String date;
    private String hour;

    @Override
    public String identifier() {
        return "registerDrone";
    }

    @Override
    public void load(List<String> args) {
        id = args.get(0);
        date = args.get(1);
        hour = args.get(2);
    }

    @Override
    public void execute() throws ParseException_Exception {
        Boolean rep = shell.system.dws.register(id,date,hour);
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
