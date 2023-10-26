package org.example.business.concretes;


import lombok.AllArgsConstructor;
import org.example.business.abstracts.CategoryService;
import org.example.business.dto.requests.CreateCategoryRequest;
import org.example.business.dto.requests.UpdateCategoryRequest;
import org.example.business.dto.responses.GetAllCategoriesResponse;
import org.example.business.dto.responses.GetByIdCategoryResponse;
import org.example.core.utilities.mappers.ModelMapperService;
import org.example.dataAccess.abstracts.CategoryRepository;
import org.example.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //Bu sınıf bir business nesnesidir.
public class CategoryManager implements CategoryService {

    //CategoryManager dataaccess i kullanacaktı Bu yüzden; (injection)
    private CategoryRepository categoryRepository; //business interface dışında dataaccessten haberi yok.
    private ModelMapperService modelMapperService; //AllArgsContructor annotation ı olduğu için bu da inject olmuş oldu.

    @Autowired
    public CategoryManager(CategoryRepository categoryRepository, ModelMapperService modelMapperService) {/*markayla ilgili iş kuralı yazabilmek için bana
        repositoryi ver diyoruz.*/
        this.categoryRepository = categoryRepository;
        this.modelMapperService=modelMapperService;
    }

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        //İŞ KURALLARI
        //--------------------------------------------------------------------------------------------------------
        //AŞAĞIDAKİ KOD DAHA FAZLA NESNEMİZ OLDUĞUNDA ÇOK UZUN OLACAĞI İÇİN AŞAĞIDAKİ KODUN YERİNE BURADA BİRBİRNE
        // BENZEYEN NESNELERİ ÖRNEĞİN AŞAĞIDAKİ İKİ KODDA YER ALAN CATEGORY'İ GETALLCATEGORİESRESPONSE' ÇEVİRMEK İÇİN MAPPERLARDAN YARARLANIRIZ.
        //List<Category> categories = categoryRepository.findAll();
        //List<GetAllCategoriesResponse> categoriesResponse = new ArrayList<GetAllCategoriesResponse>();
        /*--------------------------------------------------------------------------------------------------------
        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoriesResponse> categoriesResponse = new ArrayList<GetAllCategoriesResponse>();
        for (Category category : categories) {
            GetAllCategoriesResponse responseItem = new GetAllCategoriesResponse();
            responseItem.setCategoryName(category.getCategoryName());

            categoriesResponse.add(responseItem);
        }*/ //Buranın yerine aşağıdaki kodu yazdık.

        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoriesResponse> categoriesResponse=categories.stream().map(category->this.modelMapperService.forResponse().map(category, GetAllCategoriesResponse.class)).collect(Collectors.toList());//bunları topla list tipine çevir
        return categoriesResponse;
        /*stream elimizde bir liste varsa
        foreachde olduğu gibi onu tek tek dolaşmamımızı sağlıyor ve her birini dolaşırken o an gezdiğimiz category için (Takma adı-- ) mapleme yap.*/
        //her bir category için bir mappleme yap
        //ilk map stream in mapi. İkincisi mapperımızın mapi
    }
    @Override
    public void add(CreateCategoryRequest createCategoryRequest) {//Veri tabanına veri kaydetme
        /* Category category=new Category();
        category.setCategoryName(createCategoryRequest.getCategoryName());*///Bunun alanlarını yukarıdaki nesneyle maplemeye çalışıyor
        Category category=this.modelMapperService.forRequest().map(createCategoryRequest, Category.class);//Benim bir createCategoryRequest im var onu Category tipine çevir
        //forRequest() --> senin için Category category=new Category(); bu newleme işlemini yapıyor
        //map(createCategoryRequest, Category.class) --> tek tek karşılaştırıyor aynı olanları mapliyor
        this.categoryRepository.save(category);
    }
    @Override
    public GetByIdCategoryResponse getById(int categoryId) {
        Category category=this.categoryRepository.findById(categoryId).orElseThrow();
        GetByIdCategoryResponse response=this.modelMapperService.forResponse().map(category, GetByIdCategoryResponse.class);
        return response;
    }


    @Override
    public void update(UpdateCategoryRequest updateCategoryRequest) {
        Category category=this.modelMapperService.forRequest().map(updateCategoryRequest,Category.class);
        this.categoryRepository.save(category);
    }

    @Override
    public void delete(int categoryId) {
        this.categoryRepository.deleteById(categoryId);
    }

}
//Category--> id, name, quantity
//GetAllCategoryResponse--> id, name gözüksün istiyorum sadece. O zaman yukarıdaki id ve name imizi buradaki id ve name' e eşitleriz;
//Buna "mapping" denir.
