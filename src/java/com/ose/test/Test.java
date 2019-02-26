package com.ose.test;

import TEST.IbillService;
import TEST.IbillServiceSendBillMessageFaultMessage;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

public class Test {
    
    public static void main(String[] args) {
        IbillService port = null;        
        try {            
            QName serviceName = new QName("http://tempuri.org/", "billService");  
            URL wsdlURL = new URL("https://ose-test.com/ol-ti-itcpe/billService?wsdl");  
            Service service = Service.create(wsdlURL, serviceName);
                port = service.getPort(IbillService.class);
            Map<String, Object> reqContext = ((BindingProvider) port).getRequestContext();
                reqContext.put(BindingProvider.USERNAME_PROPERTY, "20100119065MODDATOS");
                reqContext.put(BindingProvider.PASSWORD_PROPERTY, "moddatos");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            byte[] response =  port.sendBill(Util.fileNameTest, Util.contentFileTest());
            List<Util.ArchivoZIP> listado = Util.getInputStreamElementZip(
                    Util.byteToInputStream(response)
            );
            System.out.println("LISTADO DE ARCHIVOS\n");
            for (Util.ArchivoZIP archivo : listado) {
                System.out.println("Nombre XML : " + archivo.Nombre);
            }
        } catch (IbillServiceSendBillMessageFaultMessage e) {
            System.out.println("ERROR AL OBTENER ARCHIVOS\n");
            System.out.println("Codigo : " + e.getMessage());
            System.out.println("Mensaje : " + e.getFaultInfo());
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }    
}
