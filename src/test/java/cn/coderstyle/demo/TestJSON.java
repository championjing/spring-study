package cn.coderstyle.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import javax.sound.midi.Soundbank;

/**
 * @author : championjing
 * @ClassName: TestJSON
 * @Description: TODO
 * @Date: 3/6/2019 4:29 PM
 */
public class TestJSON {
    
    @Test
    public void testJsonParse(){ 
        String str = "{num':'123'}";
        try {
            JSONObject json = (JSONObject) JSONObject.parse(str);
            System.out.println("json:"+json.toJSONString());
        } catch (com.alibaba.fastjson.JSONException ex){
            System.out.println("error");
        }
    }
    
    @Test
    public void testStrToValue(){
        String string = "";
        Integer b = Integer.parseInt(string);
        System.out.println(b);
    }
}
