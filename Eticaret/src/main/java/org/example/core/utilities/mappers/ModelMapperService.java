package org.example.core.utilities.mappers;

import org.modelmapper.ModelMapper;


/* ModelMapper, Java'daki nesneler arasında alanları eşleştirmek ve bir nesneyi başka bir nesneye dönüştürmek için
kullanılan bir kütüphanedir.*/
public interface ModelMapperService {//Model mapperlar için strateji yazmak için.
    /*Strateji derken; veri tabanımdan gelen her şeyi map etmek zorunda değilim ama bir request geldiğinde requestten gelen her şeyi
    * map olmasını isteyebilirim. Böyle durumlarda mapperlar için stratejiler yazılabiliyor. */
    ModelMapper forResponse();
    ModelMapper forRequest();
}
