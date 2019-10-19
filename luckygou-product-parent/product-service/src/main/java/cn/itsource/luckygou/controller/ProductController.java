package cn.itsource.luckygou.controller;

import cn.itsource.luckygou.domain.Specification;
import cn.itsource.luckygou.service.IProductService;
import cn.itsource.luckygou.domain.Product;
import cn.itsource.luckygou.query.ProductQuery;
import cn.itsource.luckygou.util.AjaxResult;
import cn.itsource.luckygou.util.PageList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    public IProductService productService;

    /**
    * 新增和修改
    * @param product
    * @return
    */
    @RequestMapping(value="/add",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Product product){
        try {
            if(product.getId()!=null){
                productService.updateById(product);
            }else{
                productService.save(product);
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
            productService.removeById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id)
    {
        return productService.getById(id);
    }

    /**
    * 查看所有
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Product> list(){

        return productService.list(null);
    }

    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<Product> json(@RequestBody ProductQuery query)
    {
        return productService.queryPage(query);
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
            productService.removeByIds(idList);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    /**
     * 根据商品ID查询商品的显示属性
     * @param productId
     * @return
     */
    @GetMapping("/viewProperties/{productId}")
    public List<Specification> getViewProperties(@PathVariable("productId") Long productId){
        return productService.getViewProperties(productId);
    }


    /**
     * 保存显示属性
     * @param productId
     * @return
     */
    @PostMapping("/updateViewProperties")
    public AjaxResult updateViewProperties(@RequestParam("productId")Long productId,
                                           @RequestBody List<Specification> viewProperties){
        try {
            productService.saveViewProperties(productId,viewProperties);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("保存失败！"+e.getMessage());
        }
    }

    /**
     * 根据商品ID查询商品的显示属性
     * @param productId
     * @return
     */
    @GetMapping("/skuProperties/{productId}")
    public List<Specification> getSkuProperties(@PathVariable("productId") Long productId){
        return productService.getSkuProperties(productId);
    }
}
