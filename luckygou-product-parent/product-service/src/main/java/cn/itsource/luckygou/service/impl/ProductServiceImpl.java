package cn.itsource.luckygou.service.impl;

import cn.itsource.luckygou.domain.Product;
import cn.itsource.luckygou.domain.ProductExt;
import cn.itsource.luckygou.domain.Specification;
import cn.itsource.luckygou.mapper.ProductExtMapper;
import cn.itsource.luckygou.mapper.ProductMapper;
import cn.itsource.luckygou.mapper.SpecificationMapper;
import cn.itsource.luckygou.query.ProductQuery;
import cn.itsource.luckygou.service.IProductService;
import cn.itsource.luckygou.util.PageList;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author qiuyu
 * @since 2019-10-17
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    private ProductExtMapper productExtMapper;
    @Autowired
    private SpecificationMapper specificationMapper;

    @Override
    @Transactional
    public boolean save(Product product) {
        //创建时间
        product.setCreateTime(System.currentTimeMillis());
        //t_product
        baseMapper.insert(product);//mybatis-plus自动返回生成的主键，主键生成到了product对象中
        //t_product_ext
        ProductExt ext = product.getExt();
        ext.setProductId(product.getId());
        productExtMapper.insert(ext);
        return true;
    }

    @Override
    public PageList<Product> queryPage(ProductQuery query) {
        IPage iPage = baseMapper.queryPage(new Page(query.getPage(), query.getRows()), query);
        return new PageList<>(iPage.getTotal(),iPage.getRecords());
    }

    /**
     * 根据商品ID查询商品的显示属性
     * @param productId
     * @return
     */
    @Override
    public List<Specification> getViewProperties(Long productId) {
        List<Specification> specifications = null;
        //查询商品表中的viewProperties
        Product product = baseMapper.selectById(productId);
        String viewProperties = product.getViewProperties();
//        List<Specification> specifications = JSONArray.parseArray(viewProperties, Specification.class);
        //判断是否为null
        if(StringUtils.isEmpty(viewProperties)){
            //根据商品类型查询属性表
            Long productTypeId = product.getProductTypeId();
            specifications = specificationMapper.selectList(new QueryWrapper<Specification>()
                    .eq("product_type_id", productTypeId).eq("isSku", 0));
        }else{
            specifications = JSONArray.parseArray(viewProperties, Specification.class);//转成List<Specification>
        }
        return specifications;
    }
    /**
     * 保存显示属性
     * @param productId 商品编号
     * @param specifications 显示属性
     * @return
     */
    @Override
    public void saveViewProperties(Long productId, List<Specification> specifications) {
        String viewProperties = JSON.toJSONString(specifications);
        baseMapper.updateViewProperties(productId,viewProperties);
    }
    /**
     * 根据商品ID查询商品的Sku属性
     * @param productId
     * @return
     */
    @Override
    public List<Specification> getSkuProperties(Long productId) {
        List<Specification> specifications = null;
        //查询商品表中的skuProperties
        Product product = baseMapper.selectById(productId);
        String skuProperties = product.getSkuProperties();
        //判断是否为null
        if(StringUtils.isEmpty(skuProperties)){
            //根据商品类型查询属性表
            Long productTypeId = product.getProductTypeId();
            specifications = specificationMapper.selectList(new QueryWrapper<Specification>()
                    .eq("product_type_id", productTypeId).eq("isSku", 1));
        }else{
            specifications = JSONArray.parseArray(skuProperties, Specification.class);//转成List<Specification>
        }
        return specifications;
    }

}
