package cn.itsource.luckygou.service.impl;

import cn.itsource.luckygou.domain.ProductComment;
import cn.itsource.luckygou.mapper.ProductCommentMapper;
import cn.itsource.luckygou.service.IProductCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评价 服务实现类
 * </p>
 *
 * @author qiuyu
 * @since 2019-10-17
 */
@Service
public class ProductCommentServiceImpl extends ServiceImpl<ProductCommentMapper, ProductComment> implements IProductCommentService {

}
