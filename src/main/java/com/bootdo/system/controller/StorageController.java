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

import com.bootdo.system.domain.StorageDO;
import com.bootdo.system.service.StorageService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * @author dc
 */
@Controller
@RequestMapping("/system/storage")
public class StorageController {
    @Autowired
    private StorageService storageService;

    @GetMapping()
    @RequiresPermissions("system:storage:storage")
    String Storage() {
        return "system/storage/storage";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:storage:storage")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<StorageDO> storageList = storageService.list(query);
        int total = storageService.count(query);
        PageUtils pageUtils = new PageUtils(storageList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:storage:add")
    String add() {
        return "system/storage/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("system:storage:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        StorageDO storage = storageService.get(id);
        model.addAttribute("storage", storage);
        return "system/storage/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:storage:add")
    public R save(StorageDO storage) {
        if (storageService.save(storage) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:storage:edit")
    public R update(StorageDO storage) {
        storageService.update(storage);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:storage:remove")
    public R remove(Long id) {
        if (storageService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:storage:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        storageService.batchRemove(ids);
        return R.ok();
    }

}
