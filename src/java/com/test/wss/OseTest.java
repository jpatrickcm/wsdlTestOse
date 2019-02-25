/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.wss;

import javax.ejb.Stateless;
import javax.jws.WebService;
import org.tempuri.IbillServiceGetStatusCdrMessageFaultMessage;
import org.tempuri.IbillServiceGetStatusMessageFaultMessage;
import org.tempuri.IbillServiceSendBillMessageFaultMessage;
import org.tempuri.IbillServiceSendPackMessageFaultMessage;
import org.tempuri.IbillServiceSendSummaryMessageFaultMessage;

/**
 *
 * @author JeanPatrickCampos
 */
@WebService(serviceName = "billService", portName = "BillServicePort", endpointInterface = "org.tempuri.IbillService", targetNamespace = "http://tempuri.org/", wsdlLocation = "META-INF/wsdl/OseTest/ose-test.com/ol-ti-itcpe/billService.wsdl")
@Stateless
public class OseTest {

    public java.lang.String sendSummary(java.lang.String fileName, byte[] contentFile, java.lang.String partyType) throws IbillServiceSendSummaryMessageFaultMessage {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public pe.gob.sunat.service.StatusResponse getStatus(java.lang.String ticket) throws IbillServiceGetStatusMessageFaultMessage {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.String sendPack(java.lang.String fileName, byte[] contentFile) throws IbillServiceSendPackMessageFaultMessage {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public pe.gob.sunat.service.StatusCdrResponse getStatusCdr(java.lang.String rucComprobante, java.lang.String tipoComprobante, java.lang.String serieComprobante, int numeroComprobante) throws IbillServiceGetStatusCdrMessageFaultMessage {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public byte[] sendBill(java.lang.String fileName, byte[] contentFile) throws IbillServiceSendBillMessageFaultMessage {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
