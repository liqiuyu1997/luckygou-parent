package cn.itsource.luckygou.service;

import cn.itsource.luckygou.domain.Brand;
import cn.itsource.luckygou.query.BrandQuery;
import cn.itsource.luckygou.util.PageList;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 品牌信息 服务类
 * </p>
 *
 * @author qiuyu
 * @since 2019-10-14
 */
public interface IBrandService extends IService<Brand> {

    /**
     * 分页高级查询
     * @param query
     * @return
     */
    PageList<Brand> queryPage(BrandQuery query);
}