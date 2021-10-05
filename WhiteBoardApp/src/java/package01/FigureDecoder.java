
package package01;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class FigureDecoder implements Decoder.Text<JsonHandler>{

    @Override
    public JsonHandler decode(String string01) throws DecodeException {
        JsonObject jsonObj01 =Json.createReader(new StringReader(string01)).readObject();
        return new JsonHandler(jsonObj01);
    }

    //Determine if the message can be converted.
    @Override
    public boolean willDecode(String string01) {
        try {
            Json.createReader(new StringReader(string01)).readObject();
            return true;
        } catch (JsonException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public void init(EndpointConfig config) {
        System.out.println("init");
    }

    @Override
    public void destroy() {
        System.out.println("destory");
    }
    
}
