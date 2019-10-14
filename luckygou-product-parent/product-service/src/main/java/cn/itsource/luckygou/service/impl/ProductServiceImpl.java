package cn.itsource.luckygou.service.impl;

import cn.itsource.luckygou.domain.Product;
import cn.itsource.luckygou.mapper.ProductMapper;
import cn.itsource.luckygou.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author qiuyu
 * @since 2019-10-14
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
