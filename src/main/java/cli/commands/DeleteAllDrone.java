package cli.commands;

import api.DDPublicAPI;
import cli.framework.Command;

import java.util.List;

public class DeleteAllDrone extends Command<DDPublicAPI> {


    @Override
    public String identifier() {
        return "deleteDr";
    }

    @Override
    public void load(List<String> args) {
    }

    @Override
    public void execute(){
        Boolean rep = shell.system.dws.deleteAll();
        System.out.println("Delete ===> "+rep);
    }

    @Override
    public String describe() {
        return "-----> Supprimer tous les drones";
    }

}
