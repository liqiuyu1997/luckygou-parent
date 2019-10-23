package cn.itsource.luckygou.vo;

import cn.itsource.luckygou.domain.ProductType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductTypeCrumbVo {
    //当前类型
    private ProductType currentType;
    //同级别的其他类型
    private List<ProductType> otherTypes = new ArrayList<>();

    public void setCurrentType(ProductType currentType) {
        this.currentType = currentType;
    }

    public void setOtherTypes(List<ProductType> otherTypes) {
        this.otherTypes = otherTypes;
    }
}
