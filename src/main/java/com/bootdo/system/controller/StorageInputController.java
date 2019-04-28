package com.bootdo.system.controller;

import java.util.HashMap;
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
import com.bootdo.system.domain.StorageInputDO;
import com.bootdo.system.service.StorageInputService;
import com.bootdo.system.service.StorageService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * @author dc
 */

@Controller
@RequestMapping("/system/storageInput")
public class StorageInputController {
    @Autowired
    private StorageInputService storageInputService;
    @Autowired
    private StorageService storageService;

    @GetMapping()
    @RequiresPermissions("system:storageInput:storageInput")
    String StorageInput() {
        return "system/storageInput/storageInput";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:storageInput:storageInput")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<StorageInputDO> storageInputList = storageInputService.list(query);
        int total = storageInputService.count(query);
        PageUtils pageUtils = new PageUtils(storageInputList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:storageInput:add")
    String add() {
        return "system/storageInput/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("system:storageInput:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        StorageInputDO storageInput = storageInputService.get(id);
        model.addAttribute("storageInput", storageInput);
        return "system/storageInput/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:storageInput:add")
    public R save(StorageInputDO storageInput) {
        if (storageInputService.save(storageInput) > 0) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("goodName", storageInput.getGoodName());
            map.put("goodNumber", storageInput.getGoodNumber());
            List<StorageDO> storageList = storageService.list(map);
            if (null != storageList && storageList.size() > 0) {
                StorageDO storageDO = storageList.get(0);
                storageDO.setGoodCount(storageDO.getGoodCount() + storageInput.getGoodCount());
                storageService.update(storageDO);
            }
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:storageInput:edit")
    public R update(StorageInputDO storageInput) {
        storageInputService.update(storageInput);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:storageInput:remove")
    public R remove(Long id) {
        if (storageInputService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:storageInput:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        storageInputService.batchRemove(ids);
        return R.ok();
    }

}
