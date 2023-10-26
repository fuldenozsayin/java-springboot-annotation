package org.example.entities.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="categories") //postgresql deki categories tablomu oluştur.
@Data //(lombok annotation) data barındırır, getter ve setterlarını benim için oluştur demek (@Getter + @Setter)
@AllArgsConstructor // Tüm parametlerden oluşan bir constructor ın var
@NoArgsConstructor //parametresiz bir constructorın var.
@Entity //Sen bir veritabanı varlığısın tablo olarak da yukarıdaki table a karşılık geliyosun. Sınıfın veritabanında bir tabloyu temsil ettiğini belirtir.
public class Category{

    @Id//bu column primary keysi olduğunu söylemiş oluyoruz.
    @GeneratedValue(strategy = GenerationType.IDENTITY)//1'den başlayarak otomatik idsini artır
    @Column(name = "categoryId")
    private int categoryId;

    @Column(name = "categoryName")
    private String categoryName;

}
