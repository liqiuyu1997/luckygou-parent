package cn.itsource.luckygou.service.impl;

import cn.itsource.luckygou.domain.Sku;
import cn.itsource.luckygou.mapper.SkuMapper;
import cn.itsource.luckygou.service.ISkuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * SKU 服务实现类
 * </p>
 *
 * @author qiuyu
 * @since 2019-10-17
 */
@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements ISkuService {

    /**
     * 查询价格
     * @param productId
     * @return
     */
    @Override
    public List<Sku> getPrices(Long productId) {
        return baseMapper.selectList(new QueryWrapper<Sku>().eq("product_id", productId));
    }

    @Override
    public Map<String, Object> skuChange(Long productId, String indexs) {

        Sku sku = baseMapper.selectOne(new QueryWrapper<Sku>().eq("product_id", productId).eq("indexs", indexs));
        Map<String, Object> map = new HashMap<>();
        map.put("price",sku.getPrice());
        map.put("store",sku.getAvailableStock());
        return map;

    }
}
