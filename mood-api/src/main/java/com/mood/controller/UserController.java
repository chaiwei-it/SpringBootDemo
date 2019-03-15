package com.mood.controller;

import com.alibaba.fastjson.JSONObject;
import com.mood.Pager;
import com.mood.PagerDTO;
import com.mood.ResultVO;
import com.mood.user.dto.UserDTO;
import com.mood.user.service.UserService;
import com.mood.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 描述:
 *
 * @author chaiwei
 * @create 2019-03-14 10:49 AM
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加
     *
     * @param userDTO
     * @return
     */
    @PostMapping("")
    public ResultVO create(@ModelAttribute UserDTO userDTO,
                           ModelMap modelMap, HttpServletRequest request) {
        UserVO userVO = userService.insert(userDTO);
        if (userVO == null) {
            return ResultVO.error();
        }
        return new ResultVO(userVO);
    }

    /**
     * 修改
     *
     * @param userDTO
     * @return
     */
    @PutMapping("/{id}")
    public ResultVO update(@PathVariable(value = "id", required = false) String id,
                           @ModelAttribute UserDTO userDTO,
                           ModelMap modelMap, HttpServletRequest request) {
        userDTO.setId(id);
        UserVO userVO = userService.update(userDTO);
        if (userVO == null) {
            return ResultVO.error();
        }
        return new ResultVO(userVO);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResultVO delete(@PathVariable(value = "id", required = false) String id,
                           ModelMap modelMap, HttpServletRequest request) {
        if (userService.deleteById(id)) {
            return ResultVO.success();
        }
        return ResultVO.error();
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResultVO select(@PathVariable(value = "id", required = false) String id,
                           ModelMap modelMap, HttpServletRequest request) {
        UserVO userVO = userService.selectById(id);
        return new ResultVO(userVO);
    }

    /**
     * 列表
     *
     * @param username
     * @return
     */
    @GetMapping("")
    public ResultVO list(@RequestParam(value = "username", required = false) String username,
                         ModelMap modelMap, HttpServletRequest request) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        List<UserVO> list = userService.selectList(userDTO);
        return new ResultVO(list);
    }

    /**
     * 分页
     *
     * @param pageIndex
     * @param pageSize
     * @param username
     * @return
     */
    @GetMapping("pager")
    public ResultVO pager(@RequestParam(value = "pageIndex", required = false, defaultValue = "1") Long pageIndex,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "20") Long pageSize,
                          @RequestParam(value = "username", required = false, defaultValue = "") String username,
                          ModelMap modelMap, HttpServletRequest request) {

        JSONObject param = new JSONObject();
        if ("".equals(username)) {
            param.put("username", username);
        }
        PagerDTO<UserDTO> pagerDTO = new PagerDTO(pageIndex, pageSize, param);
        return new ResultVO(userService.selectPager(pagerDTO));
    }

}
