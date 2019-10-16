package cn.itsource.luckygou.controller;

import cn.itsource.luckygou.util.AjaxResult;
import cn.itsource.luckygou.util.FastDfsApiOpr;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author qiuyu
 * @version 1.0
 * @description TODO
 * @date 2019/10/15 19:44
 */
@RestController
public class FileController {

    /**
     * 文件上传
     * @param file SpringMVC对文件上传的封装
     * @return
     */
    @PostMapping("/file")
    public AjaxResult upload(MultipartFile file){
        try {
            byte[] content = file.getBytes();//获取文件内容
            //文件扩展名
            String fileName = file.getOriginalFilename();
            int index = fileName.lastIndexOf(".");
            String extName = fileName.substring(index + 1);

            String file_id = FastDfsApiOpr.upload(content,extName);

            return AjaxResult.me().setSuccess(true).setMessage("文件上传成功!").setRestObj(file_id);
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("文件上传失败!"+e.getMessage());
        }
    }

    /**
     * 删除文件
     */
    @DeleteMapping("/file")
    public AjaxResult delete(String fileId){
        // fileId = /group1/M00/00/01/rBAEVF2nNauAUZElAAHKwyJlVyg874.jpg
        // group = group1
        // fileName = M00/00/01/rBAEVF2nNauAUZElAAHKwyJlVyg874.jpg
        try {
            //group1/M00/00/01/rBAEVF2nNauAUZElAAHKwyJlVyg874.jpg
            fileId = fileId.substring(1);
            int index = fileId.indexOf("/");
            String group = fileId.substring(0,index);
            String fileName = fileId.substring(index+1);

            FastDfsApiOpr.delete(group, fileName);
            return AjaxResult.me().setSuccess(true).setMessage("文件删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("文件删除失败!"+e.getMessage());
        }
    }

}
