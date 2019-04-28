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
import com.bootdo.system.domain.StorageOutputDO;
import com.bootdo.system.service.StorageOutputService;
import com.bootdo.system.service.StorageService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * @author dc
 */

@Controller
@RequestMapping("/system/storageOutput")
public class StorageOutputController {
    @Autowired
    private StorageOutputService storageOutputService;
    @Autowired
    private StorageService storageService;

    @GetMapping()
    @RequiresPermissions("system:storageOutput:storageOutput")
    String StorageOutput() {
        return "system/storageOutput/storageOutput";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:storageOutput:storageOutput")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<StorageOutputDO> storageOutputList = storageOutputService.list(query);
        int total = storageOutputService.count(query);
        PageUtils pageUtils = new PageUtils(storageOutputList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:storageOutput:add")
    String add() {
        return "system/storageOutput/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("system:storageOutput:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        StorageOutputDO storageOutput = storageOutputService.get(id);
        model.addAttribute("storageOutput", storageOutput);
        return "system/storageOutput/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:storageOutput:add")
    public R save(StorageOutputDO storageOutput) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("goodName", storageOutput.getGoodName());
        map.put("goodNumber", storageOutput.getGoodNumber());
        List<StorageDO> storageList = storageService.list(map);
        StorageDO storageDO = null;
        if (null != storageList && storageList.size() > 0) {
            storageDO = storageList.get(0);
        } else {
            return R.error("库存不足");
        }
        if (storageDO.getGoodCount() < storageOutput.getGoodCount()) {
            return R.error("库存不足");
        }
        if (storageOutputService.save(storageOutput) > 0) {
            storageDO.setGoodCount(storageDO.getGoodCount() - storageOutput.getGoodCount());
            storageService.update(storageDO);
            return R.ok();
        }

        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:storageOutput:edit")
    public R update(StorageOutputDO storageOutput) {
        storageOutputService.update(storageOutput);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:storageOutput:remove")
    public R remove(Long id) {
        if (storageOutputService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:storageOutput:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        storageOutputService.batchRemove(ids);
        return R.ok();
    }

}
