package cn.itsource.luckygou.vo;

import cn.itsource.luckygou.domain.Specification;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author qiuyu
 * @version 1.0
 * @description TODO
 * @date 2019/10/20 18:14
 */
@Data
public class SkusVo {

    private List<Specification> skuProperties;

    private List<Map<String,String>> skus;

    public List<Specification> getSkuProperties() {
        return skuProperties;
    }

    public List<Map<String,String>> getSkus() {
        return skus;
    }
}
