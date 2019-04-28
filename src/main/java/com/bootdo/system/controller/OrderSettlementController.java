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

import com.bootdo.system.domain.OrderSettlementDO;
import com.bootdo.system.service.OrderSettlementService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * @author dc
 */

@Controller
@RequestMapping("/system/orderSettlement")
public class OrderSettlementController {
    @Autowired
    private OrderSettlementService orderSettlementService;

    @GetMapping()
    @RequiresPermissions("system:orderSettlement:orderSettlement")
    String OrderSettlement() {
        return "system/orderSettlement/orderSettlement";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:orderSettlement:orderSettlement")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<OrderSettlementDO> orderSettlementList = orderSettlementService.list(query);
        int total = orderSettlementService.count(query);
        PageUtils pageUtils = new PageUtils(orderSettlementList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:orderSettlement:add")
    String add() {
        return "system/orderSettlement/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("system:orderSettlement:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        OrderSettlementDO orderSettlement = orderSettlementService.get(id);
        model.addAttribute("orderSettlement", orderSettlement);
        return "system/orderSettlement/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:orderSettlement:add")
    public R save(OrderSettlementDO orderSettlement) {
        if (orderSettlementService.save(orderSettlement) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:orderSettlement:edit")
    public R update(OrderSettlementDO orderSettlement) {
        orderSettlementService.update(orderSettlement);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:orderSettlement:remove")
    public R remove(Long id) {
        if (orderSettlementService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:orderSettlement:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        orderSettlementService.batchRemove(ids);
        return R.ok();
    }

}
