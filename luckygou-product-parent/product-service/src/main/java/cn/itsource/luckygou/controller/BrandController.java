package cn.itsource.luckygou.controller;

import cn.itsource.luckygou.service.IBrandService;
import cn.itsource.luckygou.domain.Brand;
import cn.itsource.luckygou.query.BrandQuery;
import cn.itsource.luckygou.util.AjaxResult;
import cn.itsource.luckygou.util.LetterUtil;
import cn.itsource.luckygou.util.PageList;
import cn.itsource.luckygou.util.AjaxResult;
import cn.itsource.luckygou.vo.BrandVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    public IBrandService brandService;

    /**
     * 保存和修改公用的
     * @param brand  传递的实体
     * @return Ajaxresult转换结果
     */
    @RequestMapping(value="/add",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Brand brand){
        try {
            if(brand.getId()!=null){
                brandService.updateById(brand);
            }else{
                brand.setFirstLetter(LetterUtil.getFirstLetter(brand.getName()));
                brandService.save(brand);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("保存对象失败！"+e.getMessage());
        }
    }

    /**
     * 删除对象信息
     * @param id
     * @return
     */
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Integer id){
        try {
            brandService.removeById(id);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    /**
     * 批量删除对象信息
     * @param ids
     * @return
     */
    @RequestMapping(value="/deleteBatch",method=RequestMethod.DELETE)
    public AjaxResult delete(@RequestParam("ids") String ids){
        try {
              List<Long> idList = cn.itsource.luckygou.util.StrUtils.splitStr2LongArr(ids);
            brandService.removeByIds(idList);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Brand get(@PathVariable("id") Long id)
    {
        return brandService.getById(id);
    }


    /**
     * 查看所有
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Brand> list(){

        return brandService.list(null);
    }


    /**
     * 分页查询数据
     *
     * @param query 查询对象
     * @return PageList 分页对象
     */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<Brand> json(@RequestBody BrandQuery query)
    {
        return brandService.queryPage(query);
    }

    /**
     * 根据类型编号查询品牌信息
     */
    @GetMapping("getByProductTypeId")
    public BrandVo getByProductTypeId(@RequestParam("productTypeId")Long productTypeId){
        return brandService.getByProductTypeId(productTypeId);
    }

}
