package cn.itsource.luckygou.mapper;

import cn.itsource.luckygou.domain.Product;
import cn.itsource.luckygou.query.ProductQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商品 Mapper 接口
 * </p>
 *
 * @author qiuyu
 * @since 2019-10-17
 */
public interface ProductMapper extends BaseMapper<Product> {
    /**
     * mybatisplus规定的mapper
     * @param page
     * @param query
     * @return
     */
    IPage queryPage(Page page,@Param("query") ProductQuery query);

    void updateViewProperties(@Param("productId") Long productId,@Param("viewProperties") String viewProperties);
}
