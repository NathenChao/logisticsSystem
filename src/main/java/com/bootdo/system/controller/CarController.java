package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.system.domain.CarDO;
import com.bootdo.system.service.CarService;

/**
 * @author dc
 */

@Controller
//处理请求的处理
@RequestMapping("/system/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping()
    @RequiresPermissions("system:car:car")
    String Car() {
        return "system/car/car";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:car:car")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<CarDO> carList = carService.list(query);
        int total = carService.count(query);
        PageUtils pageUtils = new PageUtils(carList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:car:add")
    String add() {
        return "system/car/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("system:car:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        CarDO car = carService.get(id);
        model.addAttribute("car", car);
        return "system/car/edit";
    }

    @GetMapping("/view/{id}")
    @RequiresPermissions("system:car:view")
    String view(@PathVariable("id") Long id, Model model) {
        CarDO car = carService.get(id);
        model.addAttribute("car", car);
        return "system/car/view";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:car:add")
    public R save(CarDO car) {
        if (carService.save(car) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:car:edit")
    public R update(CarDO car) {
        carService.update(car);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:car:remove")
    public R remove(Long id) {
        if (carService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:car:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        carService.batchRemove(ids);
        return R.ok();
    }

}
