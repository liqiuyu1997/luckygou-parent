package cn.itsource.luckygou.service;

import cn.itsource.luckygou.domain.ProductType;
import cn.itsource.luckygou.vo.ProductTypeCrumbVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品目录 服务类
 * </p>
 *
 * @author qiuyu
 * @since 2019-10-12
 */
public interface IProductTypeService extends IService<ProductType> {

    /**
     * 加载类型树
     * @return
     */
    List<ProductType> loadTypeTree();

    void genHomePage();
    //加载面包屑
    List<ProductTypeCrumbVo> loadTypeCrumb(Long productTypeId);
}
