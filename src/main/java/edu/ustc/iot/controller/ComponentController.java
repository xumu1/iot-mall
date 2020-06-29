package edu.ustc.iot.controller;

import com.github.pagehelper.PageInfo;
import edu.ustc.iot.pojo.component.Component;
import edu.ustc.iot.pojo.vo.reponse.ComponentResponse;
import edu.ustc.iot.pojo.vo.request.form.ComponentForm;
import edu.ustc.iot.service.impl.ComponentServiceImpl;
import edu.ustc.iot.pojo.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 功能描述：
 *
 * @Author: xumu
 * @Date: 2020-5-18 14:06
 */
@RestController
@RequestMapping("/api")
public class ComponentController {

    @Autowired
    private ComponentServiceImpl componentService;

    //返回商品列表（引入pagehelper达到分页效果），参数通过get请求中携带的参数传递
    @GetMapping("/components")
    public ResponseVo<PageInfo> list(@RequestParam(value = "type", required = false) Integer type,
                                     @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return componentService.list(type, pageNum, pageSize);
    }

    //根据id查询某一产品，参数在url中传递
    @GetMapping("/components/{componentType}/{componentId}")
    public ResponseVo<ComponentResponse> showComponentDetail(@PathVariable(value = "componentId") Integer componentId,
                                                             @PathVariable(value = "componentType") Integer componentType) {
        return componentService.selectByComponentId(componentId, componentType);
    }

    //多条件查询
    @PostMapping("/components")
    public ResponseVo<PageInfo> selectByExample(@RequestBody ComponentForm componentForm) {
        return componentService.selectByExample(componentForm);
    }

    // 添加组件，根据type不同解析方式不同
    @PostMapping("/components/{componentType}")
    public ResponseVo<ComponentResponse> insertComponent(@PathVariable(value = "componentType") Integer componentType,
                                                         @RequestBody Component component) {
        return componentService.insertComponent(componentType, component);
    }
    // 更新组件
    @PutMapping("/components/{componentType}")
    public ResponseVo<ComponentResponse> updateComponent(@PathVariable(value = "componentType") Integer componentType,
                                                         @RequestBody Component component){
        return componentService.updateComponent(componentType,component);
    }

    // 删除组件，根据id和type
    @DeleteMapping("/components/{componentType}/{componentId}")
    public ResponseVo<ComponentResponse> deleteComponent(@PathVariable(value = "componentType") Integer componentType,
                                                         @PathVariable(value = "componentId") Integer componentId){
        return componentService.deleteComponentById(componentType,componentId);
    }
}
