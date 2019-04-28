package com.bootdo.system.controller;

import java.util.Date;
import java.util.HashMap;
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
import com.bootdo.system.domain.LogisticsManageDO;
import com.bootdo.system.domain.OrderDO;
import com.bootdo.system.domain.OrderSettlementDO;
import com.bootdo.system.service.LogisticsManageService;
import com.bootdo.system.service.LogisticsService;
import com.bootdo.system.service.OrderService;
import com.bootdo.system.service.OrderSettlementService;

/**
 * @author dc
 */
@Controller
@RequestMapping("/system/logisticsManage")
public class LogisticsManageController {
    @Autowired
    private LogisticsManageService logisticsManageService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderSettlementService orderSettlementService;
    @Autowired
    private LogisticsService logisticsService;

    @GetMapping()
    @RequiresPermissions("system:logisticsManage:logisticsManage")
    String LogisticsManage() {
        return "system/logisticsManage/logisticsManage";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:logisticsManage:logisticsManage")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<LogisticsManageDO> logisticsManageList = logisticsManageService.list(query);
        int total = logisticsManageService.count(query);
        PageUtils pageUtils = new PageUtils(logisticsManageList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:logisticsManage:add")
    String add() {
        return "system/logisticsManage/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("system:logisticsManage:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        LogisticsManageDO logisticsManage = logisticsManageService.get(id);
        model.addAttribute("logisticsManage", logisticsManage);
        return "system/logisticsManage/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:logisticsManage:add")
    public R save(LogisticsManageDO logisticsManage) {
        if (logisticsManageService.save(logisticsManage) > 0) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("no", logisticsManage.getLogisticsNo());
            List<LogisticsDO> logisticsList = logisticsService.list(map);
            if (null != logisticsList && logisticsList.size() > 0) {
                LogisticsDO logisticsDO = logisticsList.get(0);
                Map<String, Object> mm = new HashMap<String, Object>();
                mm.put("goodNumber", logisticsDO.getGoodNumber());
                mm.put("goodName", logisticsDO.getGoodName());
                List<OrderDO> orderDOList = orderService.list(mm);
                if (null != orderDOList && orderDOList.size() > 0) {
                    OrderDO orderDO = orderDOList.get(0);
                    if (logisticsManage.getStatus() == 0) {
                        orderDO.setStatus(1);
                        orderService.update(orderDO);
                    } else if (logisticsManage.getStatus() == 1) {
                        orderDO.setStatus(2);
                        orderService.update(orderDO);
                        mm.clear();
                        mm.put("orderSn", orderDO.getOrderSn());
                        List<OrderSettlementDO> orderSettlementDOList = orderSettlementService.list(map);
                        if (null != orderSettlementDOList && orderSettlementDOList.size() > 0) {
                            OrderSettlementDO orderSettlementDO = orderSettlementDOList.get(0);
                            orderSettlementDO.setState(1);
                            orderSettlementDO.setCreateDate(new Date());
                            orderSettlementService.update(orderSettlementDO);
                        }
                    }
                }
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
    @RequiresPermissions("system:logisticsManage:edit")
    public R update(LogisticsManageDO logisticsManage) {
        logisticsManageService.update(logisticsManage);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("no", logisticsManage.getLogisticsNo());
        List<LogisticsDO> logisticsList = logisticsService.list(map);
        if (null != logisticsList && logisticsList.size() > 0) {
            LogisticsDO logisticsDO = logisticsList.get(0);
            Map<String, Object> mm = new HashMap<String, Object>();
            mm.put("goodNumber", logisticsDO.getGoodNumber());
            mm.put("goodName", logisticsDO.getGoodName());
            List<OrderDO> orderDOList = orderService.list(mm);
            if (null != orderDOList && orderDOList.size() > 0) {
                OrderDO orderDO = orderDOList.get(0);
                if (logisticsManage.getStatus() == 0) {
                    orderDO.setStatus(1);
                    orderService.update(orderDO);
                } else if (logisticsManage.getStatus() == 1) {
                    orderDO.setStatus(2);
                    orderService.update(orderDO);
                    mm.clear();
                    mm.put("orderSn", orderDO.getOrderSn());
                    List<OrderSettlementDO> orderSettlementDOList = orderSettlementService.list(map);
                    if (null != orderSettlementDOList && orderSettlementDOList.size() > 0) {
                        OrderSettlementDO orderSettlementDO = orderSettlementDOList.get(0);
                        orderSettlementDO.setState(1);
                        orderSettlementDO.setCreateDate(new Date());
                        orderSettlementService.update(orderSettlementDO);
                    }
                }
            }
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:logisticsManage:remove")
    public R remove(Long id) {
        if (logisticsManageService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:logisticsManage:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        logisticsManageService.batchRemove(ids);
        return R.ok();
    }

}
