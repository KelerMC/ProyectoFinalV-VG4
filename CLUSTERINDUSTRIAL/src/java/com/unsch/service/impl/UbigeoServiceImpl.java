/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAOUbigeo;
import com.unsch.domain.BUbigeo;
import com.unsch.service.UbigeoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */
@Service
public class UbigeoServiceImpl implements UbigeoService {

    @Autowired
    private IDAOUbigeo dAOUbigeo;

    public List<BUbigeo> listaUbigeo() {
        return this.dAOUbigeo.listaUbigeo();
    }

  
}
