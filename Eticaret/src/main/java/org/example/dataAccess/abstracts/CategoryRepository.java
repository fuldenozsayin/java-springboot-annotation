package org.example.dataAccess.abstracts;

import org.example.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepository extends JpaRepository<Category, Integer> {//ınteger category inin primary keysi
//Jpa generic bir yapıda çalışıyor ve bizim için ilgili (JpaRepository nesnesi) nesne için bellekte onu sanki implement
// etmiş gibi bir class üretip onu da belleğe koyuyor. Yani spring bizim için concretei hazırlamış oluyor.
}


/*Java Spring framework içinde JPA (Java Persistence API), Java nesnelerinin ilişkisel veritabanlarında depolanması ve
alınması için bir API'dir. JPA, Java EE (Enterprise Edition) standardının bir parçasıdır ve nesne ilişkisel eşleme (ORM)
 teknolojileri için bir standart sunar. ORM, Java nesnelerini ilişkisel veritabanı tablolarıyla eşlemeyi sağlayan bir
 tekniktir. JPA, bu tür eşlemeleri kolaylaştırmak için kullanılır ve veritabanı işlemlerini daha basitleştirir.*/