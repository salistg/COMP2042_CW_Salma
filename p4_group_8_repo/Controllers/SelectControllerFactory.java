package p4_group_8_repo.Controllers;

import p4_group_8_repo.Models.Actor;

/**
 * Factory class following the Factory Design Pattern.
 * Allows the caller to select which controller class
 * to use. This reduces coupling between classes
 * as the caller is not dependent on the class they're calling directly.
 * If any changes occur to the class being called, the changes
 * will only be reflected on the factory class while
 * the caller remains in the unknown about it.
 */
public class SelectControllerFactory {

    /**
     * Instantiates a Controller object depending on the
     * selection made by the client class/caller.
     *
     * @param type type of controller. 1 for Animal Controller, 2 for ActorMovementController
     * @param actor Actor object for which the controllers are needed.
     * @return the instantiated Controller object
     */
    public Controllers getController(int type, Actor actor){
        return switch(type){
            case 1 -> new AnimalController(actor);
            case 2 -> new AnimalMovementController(actor);
            default -> null;
        };
    }

}
