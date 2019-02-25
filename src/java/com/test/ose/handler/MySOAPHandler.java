/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.ose.handler;

import java.util.HashSet;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author JeanPatrickCampos
 */
public class MySOAPHandler implements SOAPHandler<SOAPMessageContext> {

    private String token;

    public MySOAPHandler(String token) {
        this.token = token;
    }

    public boolean handleMessage(SOAPMessageContext messageContext) {
        SOAPMessage msg = messageContext.getMessage();
        if ((Boolean) messageContext.get(messageContext.MESSAGE_OUTBOUND_PROPERTY)) {
            try {
                SOAPEnvelope envelope = msg.getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.addHeader();
                SOAPElement el = header.addHeaderElement(envelope.createName("TicketHeader",
                        "", "http://ws.service.com/"));
                el = el.addChildElement(envelope.createName("Ticket", "", "http://ws.service.com/"));
                el.setValue(token);
                msg.saveChanges();
            } catch (SOAPException e) {
                return false;
            }
        }
        return true;
    }

    public boolean handleFault(SOAPMessageContext messageContext) {
        return true;
    }

    public void close(MessageContext messageContext) {
    }

    // I'm not quite sure about what should this function do, but I guess something like this...
    public Set getHeaders() {
        Set headers = new HashSet();
        headers.add(new QName("https://ws.service.com/", "TicketHeader"));
        return headers;
    }
}
