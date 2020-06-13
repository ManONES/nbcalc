/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import javax.ejb.Local;
import javax.json.JsonArray;
import javax.json.JsonObject;

/**
 *
 * @author SIES
 */
@Local
public interface calcbeanLocal {
    Integer sumar(int a, int b);
    
    public JsonArray dukes();
    
    public JsonObject duke (String name, int age);    
 
    public JsonArray mensajes();
       
    public JsonObject mensaje (String message);
    
    public void certificados(String Cadena);
       
    public JsonObject certificado (String sCveEntidad,String sIdEmpresa,int iIdInstitucion,int iIdUserUcs,
                                   String sRemoteAddress,String sLlavePublica64,String sLlavePrivada64,
                                   String sFraseSeguridad, String sidUsuario, String sNombreUsuarioUCS,
                                   String sToken);    
    
}
