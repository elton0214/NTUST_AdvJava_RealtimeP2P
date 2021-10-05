
package package01;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class FigureEncoder implements Encoder.Text<JsonHandler>{

    @Override
    public String encode(JsonHandler input_figurejson) throws EncodeException {
        return input_figurejson.getJson().toString();
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
