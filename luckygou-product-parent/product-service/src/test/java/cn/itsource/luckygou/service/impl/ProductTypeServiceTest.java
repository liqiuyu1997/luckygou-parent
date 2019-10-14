package cn.itsource.luckygou.service.impl;

import cn.itsource.luckygou.ProductApplicaiton;
import cn.itsource.luckygou.domain.ProductType;
import cn.itsource.luckygou.service.IProductTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductApplicaiton.class)
public class ProductTypeServiceTest {

    @Autowired
    private IProductTypeService productTypeService;

    @Test
    public void loadTypeTree() {
        List<ProductType> productTypes = productTypeService.loadTypeTree();
    }
}