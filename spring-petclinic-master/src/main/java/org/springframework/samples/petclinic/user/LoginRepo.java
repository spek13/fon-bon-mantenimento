package org.springframework.samples.petclinic.user;

import java.util.Collection;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oswaldo
 */
interface LoginRepo extends Repository< UserSession, Integer>{
    
    void save(UserSession userSession);
    
    @Transactional(readOnly = true)
    Collection<UserSession> findAll() throws DataAccessException;

}