package com.geo.emallmaster.controller.admin;

import com.geo.emallmaster.common.IndexConfigTypeEnum;
import com.geo.emallmaster.common.ServiceResultEnum;
import com.geo.emallmaster.entity.IndexConfig;
import com.geo.emallmaster.service.IndexConfigService;
import com.geo.emallmaster.utils.PageQueryUtil;
import com.geo.emallmaster.utils.Result;
import com.geo.emallmaster.utils.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/02 19:45
 */
@Controller
@RequestMapping("/admin")
public class IndexGoodsConfigController {

    @Resource
    private IndexConfigService indexConfigService;

    @GetMapping("/indexConfigs")
    public String indexConfigsPage(HttpServletRequest request, @RequestParam("configType") int configType) {
        IndexConfigTypeEnum indexConfigTypeEnum = IndexConfigTypeEnum.getIndexConfigTypeEnumByType(configType);
        if (indexConfigTypeEnum.equals(IndexConfigTypeEnum.DEFAULT)) {
            return "error";
        }
        request.setAttribute("path", indexConfigTypeEnum.getName());
        request.setAttribute("configType", configType);
        return "admin/index_config";
    }

    /**
     * 列表
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/indexConfigs/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(indexConfigService.getConfigsPage(pageUtil));
    }

    /**
     * 添加
     *
     * @param indexConfig
     * @return
     */
    @RequestMapping(value = "/indexConfigs/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody IndexConfig indexConfig) {
        if (Objects.isNull(indexConfig.getConfigType())
                || StringUtils.isEmpty(indexConfig.getConfigName())
                || Objects.isNull(indexConfig.getConfigRank())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = indexConfigService.saveIndexConfig(indexConfig);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 修改
     *
     * @param indexConfig
     * @return
     */
    @RequestMapping(value = "/indexConfigs/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestBody IndexConfig indexConfig) {
        if (Objects.isNull(indexConfig.getConfigType())
                || Objects.isNull(indexConfig.getConfigId())
                || StringUtils.isEmpty(indexConfig.getConfigName())
                || Objects.isNull(indexConfig.getConfigRank())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = indexConfigService.updateIndexConfig(indexConfig);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/indexConfigs/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody Long[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (indexConfigService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/indexConfigs/info/{id}")
    @ResponseBody
    public Result info(@PathVariable("id") Long id) {
        IndexConfig config = indexConfigService.getIndexConfigById(id);
        if (config == null) {
            return ResultGenerator.genFailResult("未查询到数据");
        }
        return ResultGenerator.genSuccessResult(config);
    }
}
