package package01;

import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 4 弦
 */
public class JsonHandler {
    private JsonObject json01;
    
    public JsonHandler(JsonObject input_json){
        this.json01 =input_json;
    }
    
    public JsonObject getJson(){ return json01; }
    public void setJson(JsonObject input_json){ this.json01 =input_json; }
    
    @Override
    public String toString(){
        StringWriter writer01 =new StringWriter();
        Json.createWriter(writer01).write(json01);
        return writer01.toString();
    }
}
