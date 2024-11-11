/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.util;

import java.io.ByteArrayInputStream;
import java.util.zip.Deflater;
import java.util.zip.InflaterInputStream;

/**
 *
 * @author ARANGO
 */
public class utils_compress {

    public static String Inflate(byte[] src) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(src);
            InflaterInputStream iis = new InflaterInputStream(bis);
            StringBuffer sb = new StringBuffer();
            for (int c = iis.read(); c != -1; c = iis.read()) {
                sb.append((char) c);
            }
            return sb.toString();
        } catch (Exception e) {
        }
        return null;
    }

    public static byte[] Deflate(String src, int quality) {
        try {
            byte[] tmp = new byte[src.length() + 100];
            Deflater defl = new Deflater(quality);
            defl.setInput(src.getBytes("UTF-8"));
            defl.finish();
            int cnt = defl.deflate(tmp);
            byte[] res = new byte[cnt];
            for (int i = 0; i < cnt; i++) {
                res[i] = tmp[i];
            }
            return res;
        } catch (Exception e) {
        }
        return null;
    }
}
