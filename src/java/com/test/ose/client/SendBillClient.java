
package com.test.ose.client;

import com.test.ose.util.Util;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;
import org.tempuri.IbillService;

public class SendBillClient {
    
    private static final String WS_URL = "https://ose-test.com/ol-ti-itcpe/billService";
        
     public static void main(String[] args) {
        try {                    
            URL url = new URL(WS_URL);
            QName qName = new QName("http://tempuri.org/", "billService");
             
            Service service = Service.create(url, qName);
            IbillService port = service.getPort(IbillService.class);
            
            BindingProvider bindingProvider = (BindingProvider)port;
            Map<String, Object> req_ctx = bindingProvider.getRequestContext();
            req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);
            req_ctx.put(BindingProvider.USERNAME_PROPERTY, "20100119065MODDATOS");
            req_ctx.put(BindingProvider.PASSWORD_PROPERTY, "moddatos");
            bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, req_ctx);
            
            
            // This is the block that apply the Ws Security to the request
//            BindingProvider bindingProvider = (BindingProvider) billService;
//            @SuppressWarnings("rawtypes")
//            List<Handler> handlerChain = new ArrayList<Handler>();
//            handlerChain.add(new WSSecurityHeaderSOAPHandler("20100119065MODDATOS", "moddatos"));
//            bindingProvider.getBinding().setHandlerChain(handlerChain);
 
            
            byte[] objResponseExample =  port.sendBill("20100119065-01-F123-00012506.ZIP", Util.contentFileTest());
            System.out.println(""
                    + "objResponseExample : "
                    + objResponseExample);
        } catch(WebServiceException e) {
            e.printStackTrace();        
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
     
    
}
