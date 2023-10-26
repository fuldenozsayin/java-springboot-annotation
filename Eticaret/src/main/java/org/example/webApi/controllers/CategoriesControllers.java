package org.example.webApi.controllers;

import lombok.AllArgsConstructor;
import org.example.business.abstracts.CategoryService;
import org.example.business.dto.requests.CreateCategoryRequest;
import org.example.business.dto.requests.UpdateCategoryRequest;
import org.example.business.dto.responses.GetAllCategoriesResponse;
import org.example.business.dto.responses.GetByIdCategoryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoriesControllers {

    private CategoryService categoryService;

    @GetMapping()
    public List<GetAllCategoriesResponse> getAll(){
        //IoC--> CategoryManager categoryManager=new CategoryManager(new CategoryRepositoryImp()); ---> Spring bootta otomatik Autowird annotationı ile geliyor.
        return categoryService.getAll();
    }
    @GetMapping("/{categoryId}")
    public GetByIdCategoryResponse getById(@PathVariable int categoryId){//gideceği linki bu anotasyonun bulunduğundan al
        return categoryService.getById(categoryId);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)//postlar 201 döndürsün diye
    public void add(@RequestBody() CreateCategoryRequest createCategoryRequest){//@RequestBody() CreateCategoryRequest createCategoryRequest --> bu annotation otomatik geliyo artık
        this.categoryService.add(createCategoryRequest);
    }

    @PutMapping
    public void update (@RequestBody() UpdateCategoryRequest updateCategoryRequest){
        this.categoryService.update(updateCategoryRequest);
    }

    @DeleteMapping("/{categoryId}")
    public void delete(@PathVariable int categoryId){
        this.categoryService.delete(categoryId);
    }
}
