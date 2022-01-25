package com.example.emos.api.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.json.JSONUtil;
import com.example.emos.api.common.util.PageUtils;
import com.example.emos.api.common.util.R;
import com.example.emos.api.controller.form.*;
import com.example.emos.api.db.pojo.TbUser;
import com.example.emos.api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @Operation(summary = "login")
    public R login(@Valid @RequestBody LoginForm form) {
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        Integer userId = userService.login(param);
        R r = R.ok().put("result", userId != null ? true : false);
        if (userId != null) {
            StpUtil.setLoginId(userId);
            Set<String> permissions = userService.searchUserPermissions(userId);
            //String token = StpUtil.getTokenInfo().getTokenValue();
            r.put("permissions", permissions);//.put("token", token);
        }
        return r;
    }

    @GetMapping("/logout")
    @Operation(summary = "logout")
    public R logout() {
        StpUtil.logout();
        return R.ok();
    }

    @PostMapping("/changepassword")
    @SaCheckLogin
    public R changePassword(@Valid @RequestBody UpdatePasswordForm passwordForm) {
        int userId = StpUtil.getLoginIdAsInt();
        HashMap param = new HashMap();
        param.put("userId", userId);
        param.put("password", passwordForm.getPassword());
        int change = userService.updatePassword(param);
        return R.ok().put("rows", change);
    }

    @PostMapping("/search/page")
    @SaCheckPermission(value = {"ROOT", "USER:SELECT"}, mode = SaMode.OR)
    public R searchUserByPage(@Valid @RequestBody SearchUserByPageForm form) {
        int page = form.getPage();
        int length = form.getLength();
        int start = (page - 1) * length;
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        param.put("start", start);
        PageUtils pageUtils = userService.searchUserByPage(param);
        return R.ok().put("page", pageUtils);
    }

    @PostMapping("/insert")
    @SaCheckPermission(value = {"ROOT", "USER:INSERT"}, mode = SaMode.OR)
    public R insert(@Valid @RequestBody InsertUserForm form) {
        TbUser user = JSONUtil.parse(form).toBean(TbUser.class);
        user.setStatus((byte) 1);
        user.setRole(JSONUtil.parseArray(form.getRole()).toString());
        user.setCreateTime(new Date());
        return R.ok().put("rows", userService.insert(user));
    }

    @PostMapping("/update")
    @SaCheckPermission(value = {"ROOT", "USER:UPDATE"}, mode = SaMode.OR)
    public R update(@Valid @RequestBody UpdateUserForm form) {
        HashMap param = JSONUtil.parse(form).toBean(HashMap.class);
        param.replace("role", JSONUtil.parseArray(form.getRole()).toString());
        int rows = userService.update(param);
        if (rows == 1) {
            //kick off this user
            StpUtil.logoutByLoginId(form.getUserId());
        }
        return R.ok().put("rows", rows);
    }

    @PostMapping("/delete")
    @SaCheckPermission(value = {"ROOT", "USER:DELETE"}, mode = SaMode.OR)
    public R deleteUserByIds(@Valid @RequestBody DeleteUserForm form) {
        Integer userId = StpUtil.getLoginIdAsInt();
        if (ArrayUtil.contains(form.getIds(), userId)) {
            return R.error("cannot delete yourself");
        }
        int rows = userService.delete(form.getIds());
        if (rows > 0) {
            for (Integer id : form.getIds()) {
                StpUtil.logoutByLoginId(id);
            }
        }
        return R.ok().put("rows", rows);
    }

//    /**
//     * 检测登陆验证码
//     *
//     * @param form
//     * @return
//     */
//    @PostMapping("/checkQrCode")
//    @Operation(summary = "检测登陆验证码")
//    public R checkQrCode(@Valid @RequestBody CheckQrCodeForm form) {
//        boolean bool = userService.checkQrCode(form.getCode(), form.getUuid());
//        return R.ok().put("result", bool);
//    }
//
//    @PostMapping("/wechatLogin")
//    @Operation(summary = "微信小程序登陆")
//    public R wechatLogin(@Valid @RequestBody WechatLoginForm form) {
//        HashMap map = userService.wechatLogin(form.getUuid());
//        boolean result = (boolean) map.get("result");
//        if (result) {
//            int userId = (int) map.get("userId");
//            StpUtil.setLoginId(userId);
//            Set<String> permissions = userService.searchUserPermissions(userId);
//            map.remove("userId");
//            map.put("permissions", permissions);
//        }
//        return R.ok(map);
//    }

    @GetMapping("/loadUserInfo")
    @SaCheckLogin
    public R loadUserInfo() {
        int userId = StpUtil.getLoginIdAsInt();
        HashMap summary = userService.searchUserSummary(userId);
        return R.ok(summary);
    }

    @PostMapping("/searchById")
    @SaCheckPermission(value = {"ROOT", "USER:SELECT"}, mode = SaMode.OR)
    public R searchById(@Valid @RequestBody SearchUserByIdForm form) {
        HashMap map = userService.searchById(form.getUserId());
        return R.ok(map);
    }

    @GetMapping("/searchAllUser")
    @SaCheckLogin
    public R searchAllUser() {
        ArrayList<HashMap> list = userService.searchAllUser();
        return R.ok().put("list", list);
    }
}
