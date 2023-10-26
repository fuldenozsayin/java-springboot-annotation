package org.example.business.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor //entitydeki gibi diğerlerini eklemeye gerek yok çünkü bu entity değil
public class CreateCategoryRequest {
    private String categoryName;
}
