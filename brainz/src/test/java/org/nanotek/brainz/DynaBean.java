package org.nanotek.brainz;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Example of how @JsonAnyGetter and @JsonAnySetter can be used to
 * create extensible "beans" (dyna-beans)
 *
 * @since 1.9
 */
public class DynaBean
{
    // Two mandatory properties
    
    public int id;
    public String name;

    // and then "other" stuff:
    
    protected Map<String,Object> other = new HashMap<String,Object>();

    @JsonCreator
    public DynaBean(@JsonProperty("id") int id, @JsonProperty("name") String name)
    {
        this.id = id;
        this.name = name;
    }
    
    @JsonAnyGetter
    public Map<String,Object> any() {
        return other;
    }

    @JsonAnySetter
    public void set(String name, Object value) {
        other.put(name, value);
    }

    public static void main(String[] args) throws Exception
    {
        DynaBean bean = new DynaBean(13, "Bob");
        bean.set("age", Integer.valueOf(37));
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(bean);
        Map<String,Object> theMap = new HashMap<>();
        theMap.put("id" , 13);
        theMap.put("name" , "Bob");
        theMap.put("age" , 37);
        System.out.println("JSON in: "+json);
        json = mapper.writeValueAsString(theMap);
        System.out.println("JSON in: "+json);
        JsonNode node;
        // should also come back ok
        /*DynaBean result =*/ mapper.readValue(json, DynaBean.class);
    }
}
