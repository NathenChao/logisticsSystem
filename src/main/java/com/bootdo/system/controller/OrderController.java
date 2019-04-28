package com.bootdo.system.controller;

import java.util.Date;
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
import com.bootdo.system.domain.OrderDO;
import com.bootdo.system.domain.OrderSettlementDO;
import com.bootdo.system.service.OrderService;
import com.bootdo.system.service.OrderSettlementService;

/**
 * @author dc
 */

@Controller
@RequestMapping("/system/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderSettlementService orderSettlementService;

    @GetMapping()
    @RequiresPermissions("system:order:order")
    String Order() {
        return "system/order/order";
    }

    @GetMapping("/statistics")
    @RequiresPermissions("system:order:statistics")
    String statistics() {
        return "system/order/statistics";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:order:order")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<OrderDO> orderList = orderService.list(query);
        int total = orderService.count(query);
        PageUtils pageUtils = new PageUtils(orderList, total);
        return pageUtils;
    }

    @ResponseBody
    @GetMapping("/statisticsList")
    @RequiresPermissions("system:order:statistics")
    public PageUtils statisticsList(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<OrderDO> logisticsList = orderService.statistics(query);
        int total = orderService.statisticsCount(query);
        PageUtils pageUtils = new PageUtils(logisticsList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:order:add")
    String add() {
        return "system/order/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("system:order:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        OrderDO order = orderService.get(id);
        model.addAttribute("order", order);
        return "system/order/edit";
    }

    @GetMapping("/view/{id}")
    @RequiresPermissions("system:order:view")
    String view(@PathVariable("id") Long id, Model model) {
        OrderDO order = orderService.get(id);
        model.addAttribute("order", order);
        return "system/order/view";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:order:add")
    public R save(OrderDO order) {
        if (orderService.save(order) > 0) {
            OrderSettlementDO orderSettlementDO = new OrderSettlementDO();
            orderSettlementDO.setOrderSn(order.getOrderSn());
            orderSettlementDO.setTotalPrice(order.getTotalPrice());
            orderSettlementDO.setCreateDate(new Date());
            orderSettlementDO.setState(0);
            orderSettlementService.save(orderSettlementDO);
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:order:edit")
    public R update(OrderDO order) {
        orderService.update(order);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:order:remove")
    public R remove(Long id) {
        if (orderService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:order:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        orderService.batchRemove(ids);
        return R.ok();
    }

}
