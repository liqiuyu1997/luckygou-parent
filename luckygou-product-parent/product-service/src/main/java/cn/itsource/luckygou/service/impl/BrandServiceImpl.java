package cn.itsource.luckygou.service.impl;

import cn.itsource.luckygou.domain.Brand;
import cn.itsource.luckygou.mapper.BrandMapper;
import cn.itsource.luckygou.query.BrandQuery;
import cn.itsource.luckygou.service.IBrandService;
import cn.itsource.luckygou.util.PageList;
import cn.itsource.luckygou.vo.BrandVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * <p>
 * 品牌信息 服务实现类
 * </p>
 *
 * @author qiuyu
 * @since 2019-10-14
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    /**
     * 分页高级查询
     * @param query
     * @return
     */
    @Override
    public PageList<Brand> queryPage(BrandQuery query) {
        IPage<Brand> brandIPage =
                baseMapper.queryPage(new Page(query.getPage(), query.getRows()), query);
        PageList<Brand> pageList = new PageList<>(brandIPage.getTotal(),brandIPage.getRecords());
        return pageList;
    }

    /**
     * 根据类型编号查询品牌信息
     * @param productTypeId
     * @return
     */
    @Override
    public BrandVo getByProductTypeId(Long productTypeId) {
        BrandVo vo = new BrandVo();
        List<Brand> brands = baseMapper.selectList(
                new QueryWrapper<Brand>().eq("product_type_id", productTypeId));
        vo.setBrands(brands);
        //首字母  排序 去重
        Set<String> letters = new TreeSet<>();
        for (Brand brand : brands) {
            letters.add(brand.getFirstLetter());
        }
        vo.setLetters(letters);
        return vo;
    }
}
