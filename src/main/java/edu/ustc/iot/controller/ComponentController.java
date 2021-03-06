package edu.ustc.iot.controller;

import com.github.pagehelper.PageInfo;
import edu.ustc.iot.pojo.component.Component;
import edu.ustc.iot.pojo.component.Gateway;
import edu.ustc.iot.pojo.component.Sensor;
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
    @PostMapping("/components/pageQuery/0")
    public ResponseVo<PageInfo> selectBySensorExample(@RequestBody ComponentForm<Sensor> componentForm) {
        return componentService.selectByExample(componentForm);
    }
    @PostMapping("/components/pageQuery/1")
    public ResponseVo<PageInfo> selectByGatewayExample(@RequestBody ComponentForm<Gateway> componentForm) {
        return componentService.selectByExample(componentForm);
    }

    // 添加组件，根据type不同解析方式不同
    @PostMapping("/components/0")
    public ResponseVo<ComponentResponse> insertSensor(@RequestBody Sensor component) {
        return componentService.insertComponent(0, component);
    }
    @PostMapping("/components/1")
    public ResponseVo<ComponentResponse> insertGateway(@RequestBody Gateway component) {
        return componentService.insertComponent(1, component);
    }

    // 更新组件
    @PutMapping("/components/0")
    public ResponseVo<ComponentResponse> updateSensor(@RequestBody Sensor component){
        return componentService.updateComponent(0,component);
    }
    @PutMapping("/components/1")
    public ResponseVo<ComponentResponse> updateGateway(@RequestBody Gateway component){
        return componentService.updateComponent(1,component);
    }

    // 删除组件，根据id和type
    @DeleteMapping("/components/{componentType}/{componentId}")
    public ResponseVo<ComponentResponse> deleteComponent(@PathVariable(value = "componentType") Integer componentType,
                                                         @PathVariable(value = "componentId") Integer componentId){
        return componentService.deleteComponentById(componentType,componentId);
    }
}
