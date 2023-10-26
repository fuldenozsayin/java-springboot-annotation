package org.example.core.utilities.mappers;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

/* ModelMapper, Java'daki nesneler arasında alanları eşleştirmek ve bir nesneyi başka bir nesneye dönüştürmek için
kullanılan bir kütüphanedir.*/
@Service//her seferinde modelmapper üretilsin istemiyorum. IoC ye yerleşsin istiyorum
@AllArgsConstructor //model mapper injection yapacağım için
public class ModelMapperManager implements ModelMapperService{

    private ModelMapper modelMapper;
    @Override
    public ModelMapper forResponse() {//Responselar için
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true) //belirsizlik olduğu durumda onu ignore edeyim mi? Evet.(aynı isimde nesneler olması vs gibi) Belirsizlik olması durumunda hata verme ben dikakt edeeğim demek
                .setMatchingStrategy(MatchingStrategies.LOOSE);//VERİTABANIMDAKİ HER ŞEYİ MAPPLENMEZSE KIZMA RESPONSE NESNEMDEKİLERİ MAPPLE (GEVŞEK MAPPLEME)
                return this.modelMapper;
    }
    @Override
    public ModelMapper forRequest() {//Requestler için
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);//HER ŞEY MAPPLENSİN HER ŞEYİN BİR KARŞILIĞI OLSUN
                return this.modelMapper;
    }
}
