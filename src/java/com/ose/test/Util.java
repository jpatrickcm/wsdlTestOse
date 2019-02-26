/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ose.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.commons.codec.binary.Base64;

public class Util {
    
    // RutaDescargaAdjunto : Ruta donde se guardara el(los) XML's del zip retornado 
    public static String RutaDescargaAdjunto = "D:\\";
    
    // fileNameTest : nombre de archivo en consulta
    public static String fileNameTest  = "20100119065-01-F123-00012506.ZIP";
    
    // contentFileTest : arreglo de bytes enviado a SUNAT
    public static byte[] contentFileTest(){
        String asd  = "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";
        byte[] byteArray = Base64.decodeBase64(asd.getBytes());
        return byteArray;
    }
    
    public static InputStream byteToInputStream(byte[] myBytes){
        return new ByteArrayInputStream(myBytes);
    }
    
    public static List<ArchivoZIP> getInputStreamElementZip(InputStream zip) throws IOException {
        List<ArchivoZIP> lelementozip = new ArrayList<ArchivoZIP>();
        ZipInputStream zin = new ZipInputStream(zip);
        ArchivoZIP archivo ;
        for (ZipEntry e; (e = zin.getNextEntry()) != null;) {
            if (e.getName().toUpperCase().contains(".XML")) {
                String filename = RutaDescargaAdjunto + e.getName() ;
                FileOutputStream fos = new FileOutputStream(filename);
                int leido;
                byte [] buffer = new byte[1024];
                while (0<(leido=zin.read(buffer))){
                   fos.write(buffer,0,leido);
                }
                fos.close();
                zin.closeEntry();               
                File af = new File(filename);
                if (af.exists()) {      
                    archivo = new ArchivoZIP();
                    archivo.Nombre = e.getName();
                    archivo.RutaArchivo = filename;
                    lelementozip.add(archivo);
                }
            }
        }
        return lelementozip;       
    }
    
    static class ArchivoZIP {
        String Nombre;
        InputStream ArchivoElemento;
        String RutaArchivo;

        public ArchivoZIP() {
            Nombre = "";
            ArchivoElemento = null;
            RutaArchivo = "";
        }
    }
}
