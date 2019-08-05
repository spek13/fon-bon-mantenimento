//<<<<<<< HEAD
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.springframework.samples.petclinic.owner;
//
//import java.util.Collection;
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.repository.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// *
// * @author JuniorFaviel
// */
//public interface ImageRepository extends Repository<Image, Integer>{
//     
//    @Transactional(readOnly = true)
//    Collection<Image> findAll() throws DataAccessException;
//
////}
//=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.owner;

import java.util.Collection;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JuniorFaviel
 */
public interface ImageRepository extends Repository<Image, Integer>{
     
    @Transactional(readOnly = true)
     Collection<Image> findAll() throws DataAccessException;
     
     void save(Image image) throws DataAccessException;
}
//>>>>>>> origin/upload
