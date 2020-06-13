/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import jdk.nashorn.internal.parser.JSONParser;


/**
 *
 * @author SIES
 */
@Stateless
public class calcbean implements calcbeanLocal {

    @Override
    public Integer sumar(int a, int b) {
        return (a+b);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    @GET
    public JsonArray dukes(){
        return Json.createArrayBuilder().
                add(duke("smart",18)).
                add(duke("nice",42)).
                add(duke("many",55)).
                add(duke("Harry",17)).
                build();
    }
       
    @Override
    public JsonObject duke (String name, int age){
        return Json.createObjectBuilder().
                add("name", name).
                add("age", age).
                build();
    }


    @Override
    @GET
    public JsonArray mensajes(){
        return Json.createArrayBuilder().
                add(mensaje("data received")).
                build();
    }
       
    @Override
    public JsonObject mensaje (String message){
        return Json.createObjectBuilder().  
                add("message", message).
                build();
    }
    
    
    @GET
    @Override
    public void certificados(String Cadena){
        
        
        
    }
       
    @Override
    public JsonObject certificado (String sCveEntidad,String sIdEmpresa,int iIdInstitucion,int iIdUserUcs,
                                   String sRemoteAddress,String sLlavePublica64,String sLlavePrivada64,
                                   String sFraseSeguridad, String sidUsuario, String sNombreUsuarioUCS,
                                   String sToken){
    return Json.createObjectBuilder().
                add("sCveEntidad",sCveEntidad).
                add("sIdEmpresa",sIdEmpresa).
                add("iIdInstitucion",iIdInstitucion).
                add("iIdUserUcs",iIdUserUcs).
                add("sRemoteAddress",sRemoteAddress).
                add("sLlavePublica64",sLlavePublica64).
                add("sLlavePrivada64",sLlavePrivada64).
                add("sFraseSeguridad",sFraseSeguridad).
                add("sidUsuario",sidUsuario).
                add("sNombreUsuarioUCS",sNombreUsuarioUCS).
                add("sToken",sToken).
                build();
    }


    
    
}
