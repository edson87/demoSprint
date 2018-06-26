package com.dh.spring5webapp.model.bootstrap;

import com.dh.spring5webapp.model.*;
import com.dh.spring5webapp.repositories.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

//Para introducir datos por defecto , reconoce como un bean
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private CategoryRepository categoryRepository;
    private SubCategoryRepository subCategoryRepository;
    private ItemRepository itemRepository;
    private EmployeeRepository employeeRepository;
    private PositionRepository positionRepository;
    private ContractRepository contractRepository;

    public DevBootstrap(CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository, ItemRepository itemRepository, EmployeeRepository employeeRepository, PositionRepository positionRepository, ContractRepository contractRepository) {
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.itemRepository = itemRepository;
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.contractRepository = contractRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        initData();
    }

    private void initData() {
        //equipo proteccion personal para categoria
        Category eppCategory = new Category();
        eppCategory.setCode("EPP");
        eppCategory.setName("EPP");
        categoryRepository.save(eppCategory);


        Category resourceCategory = new Category();
        resourceCategory.setCode("RES");
        resourceCategory.setName("RESOURCE");
        categoryRepository.save(resourceCategory);

        SubCategory rawMaterialSubCategory = new SubCategory();
        rawMaterialSubCategory.setCategory(resourceCategory);
        rawMaterialSubCategory.setCode("RW");
        rawMaterialSubCategory.setName("RW CATEGORY");
        subCategoryRepository.save(rawMaterialSubCategory);

        SubCategory safetySubCategory = new SubCategory();
        safetySubCategory.setCategory(eppCategory);
        safetySubCategory.setCode("SF");
        safetySubCategory.setName("SAFETY");
        subCategoryRepository.save(safetySubCategory);

        Item helmet = new Item();
        helmet.setCode("Hel");
        helmet.setName("HELMET");
        helmet.setSubCategory(safetySubCategory);
        itemRepository.save(helmet);

        Item ink = new Item();
        ink.setCode("IN");
        ink.setName("INK");
        ink.setSubCategory(rawMaterialSubCategory);
        itemRepository.save(ink);

        Employee jhon = new Employee();
        jhon.setFirstName("JHON");
        jhon.setLastName("DON");

        Position position = new Position();
        position.setName("Operative");
        positionRepository.save(position);

        Contract contract = new Contract();
        contract.setEmployee(jhon);
        contract.setInitDate(new Date(2018,6,21));
        contract.setPosition(position);



        jhon.getContracts().add(contract);
        employeeRepository.save(jhon);
        contractRepository.save(contract);
    }
}
