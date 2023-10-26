package org.example.business.abstracts;

import org.example.business.dto.requests.CreateCategoryRequest;
import org.example.business.dto.requests.UpdateCategoryRequest;
import org.example.business.dto.responses.GetAllCategoriesResponse;
import org.example.business.dto.responses.GetByIdCategoryResponse;

import java.util.List;

public interface CategoryService {//iş kurallarını yazacağım yapıyı tasarlıyorum.
    List<GetAllCategoriesResponse> getAll();//Kategorileri listelediğimiz // BU RESPONSE'DUR.

    GetByIdCategoryResponse getById(int categoryId);

    void add(CreateCategoryRequest createCategoryRequest);
    void update(UpdateCategoryRequest updateCategoryRequest);
    void delete(int categoryId);
}
