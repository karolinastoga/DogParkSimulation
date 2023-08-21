package park;

import agents.AgentsGenerator;
import simulation.GUI.CreatedAgents;

import java.io.IOException;
import java.util.HashMap;

import static simulation.Configuration.config;

/**
 * Class responsible for generating park
 */
public class GeneratePark {

    private static String parkName;
    private static AgentsGenerator agents;
    private static Board park;

    /**
     * Method that generates park with given values
     * @param parkNameSt Name of the park
     * @param initialValues Information about agents and resources
     * @throws IOException Exception thrown when cannot read a file
     */
    public static void generatePark(String parkNameSt, HashMap<String, Integer> initialValues) throws IOException {

        parkName = parkNameSt;
        generateAgents(initialValues);
        generateBoard(initialValues);

        CreatedAgents agentsBefore = new CreatedAgents();
        agentsBefore.display();

        System.out.println("Successful park generation!");
    }

    /**
     * Method generating agents
     * @param initialValues Given agents
     * @throws IOException Exception thrown when cannot read a file
     */
    public static void generateAgents(HashMap<String, Integer> initialValues) throws IOException {
        agents = new AgentsGenerator();
        agents.generateAgents(
                initialValues.get(config.agents.dog_breeds.DACHSHUNDS),
                initialValues.get(config.agents.dog_breeds.GOLDEN_RETRIEVERS),
                initialValues.get(config.agents.dog_breeds.ROTTWEILERS),
                initialValues.get(config.agents.human_types.DOG_CATCHERS),
                initialValues.get(config.agents.human_types.WALKERS));
    }

    /**
     * Method generating size and resources on board
     * @param initialValues Resources and size
     */
    public static void generateBoard(HashMap<String, Integer> initialValues){
        park = new Board(
                initialValues.get(config.board.size.x),
                initialValues.get(config.board.size.y),
                initialValues.get(config.board.resources.bones),
                initialValues.get(config.board.resources.poisons));
        park.prepareBoard(agents.getDachshunds(), agents.getGoldenRetrievers(), agents.getRottweilers(), agents.getDogCatchers(), agents.getWalkers());
    }

    public static AgentsGenerator getAgents() {
        return agents;
    }

    public static void setAgents(AgentsGenerator agents) {
        GeneratePark.agents = agents;
    }

    public static Board getPark() {
        return park;
    }

    public static void setPark(Board park) {
        GeneratePark.park = park;
    }

    public static String getParkName() {
        return parkName;
    }

    public static void setParkName(String parkName) {
        GeneratePark.parkName = parkName;
    }
}
