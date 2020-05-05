package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.planning.ParseException_Exception;
import stubs.planning.UnvailableSlotTimeException_Exception;


import java.util.List;

public class ValidSlot extends Command<DDPublicAPI> {

    private String d;
    private String h;

    @Override
    public String identifier() {
        return "validSlot";
    }

    @Override
    public void load(List<String> args) {
        d = args.get(0);
        h = args.get(1);
    }

    @Override
    public void execute() {
        try {
            Boolean rep = shell.system.plws.validSlot(d,h);
            System.out.println("<-------------------/" + "\\------------------------->");
            System.out.println("CRENEAU DISPONIBLE !");
            System.out.println("<-------------------/" + "\\------------------------->");;
        } catch (ParseException_Exception e) {
            System.out.println("Date Error");
        }
    }

    @Override
    public String describe() {
        return "-----> Vérifier disponibilité d'un créneau horaire";
    }

}
