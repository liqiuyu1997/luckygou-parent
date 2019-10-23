package cn.itsource.luckygou.service;

import cn.itsource.luckygou.domain.Sku;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * SKU 服务类
 * </p>
 *
 * @author qiuyu
 * @since 2019-10-17
 */
public interface ISkuService extends IService<Sku> {

    /**
     * 查询价格
     * @param productId
     * @return
     */
    List<Sku> getPrices(Long productId);
}
