package cn.itsource.luckygou.mapper;

import cn.itsource.luckygou.domain.Product;
import cn.itsource.luckygou.query.ProductQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品 Mapper 接口
 * </p>
 *
 * @author qiuyu
 * @since 2019-10-17
 */
public interface ProductMapper extends BaseMapper<Product> {
    //mybatisplus规定的mapper
    IPage queryPage(Page page,@Param("query") ProductQuery query);

    void updateViewProperties(@Param("productId") Long productId,@Param("viewProperties") String viewProperties);

    //修改商品的sku属性
    void updateSkuProperties(@Param("productId") Long productId, @Param("skuProperties") String skuPropertiesJSON);
    //商品上架
    void onSale(@Param("ids") List<Long> ids,@Param("onSaleTime") Long onSaleTime);

    //商品下架
    void offSale(@Param("ids") List<Long> ids,@Param("offSaleTime") Long offSaleTime);
}
