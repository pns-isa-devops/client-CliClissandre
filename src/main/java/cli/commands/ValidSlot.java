package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.planning.ParseException_Exception;
import stubs.planning.UnvailableSlotTimeException_Exception;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        if (d.equals("TODAY")){
            d = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
    }

    @Override
    public void execute() {
        try {
            Boolean rep = shell.system.plws.validSlot(d, h);
            if (rep) {
                System.out.println("<-------------------/" + "\\------------------------->");
                System.out.println("CRENEAU DISPONIBLE !");
                System.out.println("<-------------------/" + "\\------------------------->");
            } else {
                System.out.println("<-------------------/" + "\\------------------------->");
                System.out.println("CRENEAU INDISPONIBLE !");
                System.out.println("<-------------------/" + "\\------------------------->");
            }
        } catch (ParseException_Exception e) {
            System.out.println("Date Error");
        }
    }

    @Override
    public String describe() {
        return "-----> Vérifier disponibilité d'un créneau horaire";
    }

}
