package cn.itsource.luckygou.service;

import cn.itsource.luckygou.domain.Product;
import cn.itsource.luckygou.query.ProductQuery;
import cn.itsource.luckygou.util.PageList;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品 服务类
 * </p>
 *
 * @author qiuyu
 * @since 2019-10-17
 */
public interface IProductService extends IService<Product> {

    PageList<Product> queryPage(ProductQuery query);
}
