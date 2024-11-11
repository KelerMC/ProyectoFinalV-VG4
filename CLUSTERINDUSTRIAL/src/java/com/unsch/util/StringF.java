package com.unsch.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class StringF {

    public StringF() {
    }

    public int nvlfunction(String dato, int valuen) {
        if (dato == null) {
            return valuen;
        }
        if (dato.equalsIgnoreCase("")) {
            return valuen;
        }
        return Integer.parseInt(dato);
    }

    public String nvlfunction(String dato, String valuen) {
        if (dato == null) {
            return valuen;
        }
        if (dato.equalsIgnoreCase("")) {
            return valuen;
        }
        return dato;
    }

    public String nvlfunction(int dato, String valuen) {
        if (dato == 0) {
            return valuen;
        }
        return String.valueOf(dato);
    }

    public String nvlfunction(Date dato, String valuen) {
        if (dato == null) {
            return valuen;
        }
        return dato.toString();
    }

    public Date formatoFecha(String fechaI) {
        if (fechaI == null) {
            return null;
        }
        Date dateVar = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date dt;
        try {
            dt = sdf.parse(fechaI);
            dateVar = new java.sql.Date(dt.getTime());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dateVar;
    }

    public String formatoFecha(Date fechaI) {
        if (fechaI == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String reportDate = null;
        try {
            reportDate = sdf.format(fechaI);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return reportDate;
    }
}
