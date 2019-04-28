package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.system.domain.GoodDO;
import com.bootdo.system.domain.StorageDO;
import com.bootdo.system.service.GoodService;
import com.bootdo.system.service.StorageService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * @author dc
 */
@Controller
@RequestMapping("/system/good")
public class GoodController {
    @Autowired
    private GoodService goodService;
    @Autowired
    private StorageService storageService;

    @GetMapping()
    @RequiresPermissions("system:good:good")
    String Good() {
        return "system/good/good";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:good:good")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<GoodDO> goodList = goodService.list(query);
        int total = goodService.count(query);
        PageUtils pageUtils = new PageUtils(goodList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:good:add")
    String add() {
        return "system/good/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("system:good:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        GoodDO good = goodService.get(id);
        model.addAttribute("good", good);
        return "system/good/edit";
    }

    @GetMapping("/view/{id}")
    @RequiresPermissions("system:good:view")
    String view(@PathVariable("id") Long id, Model model) {
        GoodDO good = goodService.get(id);
        model.addAttribute("good", good);
        return "system/good/view";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:good:add")
    public R save(GoodDO good) {
        if (goodService.save(good) > 0) {
            StorageDO storage = new StorageDO();
            storage.setGoodNumber(good.getNumber());
            storage.setGoodName(good.getTitle());
            storage.setGoodCount(0);
            storageService.save(storage);
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:good:edit")
    public R update(GoodDO good) {
        goodService.update(good);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:good:remove")
    public R remove(Long id) {
        if (goodService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:good:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        goodService.batchRemove(ids);
        return R.ok();
    }

}
