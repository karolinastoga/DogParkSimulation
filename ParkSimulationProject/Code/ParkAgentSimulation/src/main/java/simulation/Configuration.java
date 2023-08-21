package simulation;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import configuration.ParkConfiguration;

import java.io.File;
import java.io.IOException;

public class Configuration {

    public static ParkConfiguration config;

    /**
     * Getting set up configuration file
     */
    public static void setUpConfiguration(){
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
            config = mapper.readValue(new File("src/main/resources/configurations/config"), ParkConfiguration.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
