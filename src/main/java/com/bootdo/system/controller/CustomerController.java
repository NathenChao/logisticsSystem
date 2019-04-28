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

import com.bootdo.system.domain.CustomerDO;
import com.bootdo.system.service.CustomerService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * @author dc
 */

@Controller
@RequestMapping("/system/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping()
    @RequiresPermissions("system:customer:customer")
    String Customer() {
        return "system/customer/customer";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:customer:customer")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<CustomerDO> customerList = customerService.list(query);
        int total = customerService.count(query);
        PageUtils pageUtils = new PageUtils(customerList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:customer:add")
    String add() {
        return "system/customer/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("system:customer:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        CustomerDO customer = customerService.get(id);
        model.addAttribute("customer", customer);
        return "system/customer/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:customer:add")
    public R save(CustomerDO customer) {
        if (customerService.save(customer) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:customer:edit")
    public R update(CustomerDO customer) {
        customerService.update(customer);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:customer:remove")
    public R remove(Long id) {
        if (customerService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:customer:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        customerService.batchRemove(ids);
        return R.ok();
    }

}
