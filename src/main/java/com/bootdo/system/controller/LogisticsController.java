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
import com.bootdo.system.domain.LogisticsDO;
import com.bootdo.system.service.LogisticsService;

/**
 * @author dc
 */

@Controller
@RequestMapping("/system/logistics")
public class LogisticsController {
    @Autowired
    private LogisticsService logisticsService;

    @GetMapping()
    @RequiresPermissions("system:logistics:logistics")
    String Logistics() {
        return "system/logistics/logistics";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:logistics:logistics")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<LogisticsDO> logisticsList = logisticsService.list(query);
        int total = logisticsService.count(query);
        PageUtils pageUtils = new PageUtils(logisticsList, total);
        return pageUtils;
    }


    @GetMapping("/add")
    @RequiresPermissions("system:logistics:add")
    String add() {
        return "system/logistics/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("system:logistics:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        LogisticsDO logistics = logisticsService.get(id);
        model.addAttribute("logistics", logistics);
        return "system/logistics/edit";
    }

    @GetMapping("/view/{id}")
    @RequiresPermissions("system:logistics:view")
    String view(@PathVariable("id") Long id, Model model) {
        LogisticsDO logistics = logisticsService.get(id);
        model.addAttribute("logistics", logistics);
        return "system/logistics/view";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:logistics:add")
    public R save(LogisticsDO logistics) {
        if (logisticsService.save(logistics) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:logistics:edit")
    public R update(LogisticsDO logistics) {
        logisticsService.update(logistics);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:logistics:remove")
    public R remove(Long id) {
        if (logisticsService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:logistics:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        logisticsService.batchRemove(ids);
        return R.ok();
    }

}
