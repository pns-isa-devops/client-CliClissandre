package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;
import stubs.delivery.Delivery;
import stubs.delivery.Exception_Exception;
import stubs.delivery.ParseException_Exception;

import java.text.ParseException;
import java.util.List;

public class NextDelivery extends Command<DDPublicAPI> {

    @Override
    public String identifier() {
        return "nextDelivery";
    }

    @Override
    public void load(List<String> args) {
    }

    @Override
    public void execute() {
        try {
            Delivery p = shell.system.dews.getNextDelivery();
            if (p!= null){
                System.out.println("<-------------------/" + "\\------------------------->");
                System.out.println("Num :: " + p.getPackageDelivered().getSecretNumber());
                System.out.println("Poids :: " + p.getPackageDelivered().getWeight());
                System.out.println("Transporteur :: " + p.getPackageDelivered().getProvider().getName());
                System.out.println("Date d'enregistrement :: " + p.getPackageDelivered().getRegisterDate());
                System.out.println("Date de Livraison :: " + p.getDeliveryDate());
                System.out.println("Drone chargé de la livraison :: " + p.getDrone().getDroneId());
                System.out.println("<-------------------/" + "\\------------------------->");
            }else {
                System.out.println("<-------------------/" + "\\------------------------->");
                System.out.println("AUCUNE LIVRAISON DISPONIBLE !");
                System.out.println("<-------------------/" + "\\------------------------->");
            }
        } catch (ParseException_Exception e) {
            System.out.println("Parsing Error!");
        }
    }

    @Override
    public String describe() {
        return "-----> Avoir la prochaine livraison";
    }

}
