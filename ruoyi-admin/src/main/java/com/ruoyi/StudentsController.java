package com.ruoyi;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.mall.domain.Students;
import com.ruoyi.mall.service.IStudentsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生列表Controller
 * 
 * @author ruoyi
 * @date 2020-09-25
 */
@Controller
@RequestMapping("/mall/stu")
public class StudentsController extends BaseController
{
    private String prefix = "mall/stu";

    @Autowired
    private IStudentsService studentsService;

    @RequiresPermissions("mall:stu:view")
    @GetMapping()
    public String stu()
    {
        return prefix + "/stu";
    }

    /**
     * 查询学生列表列表
     */
    @RequiresPermissions("mall:stu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Students students)
    {
        startPage();
        List<Students> list = studentsService.selectStudentsList(students);
        return getDataTable(list);
    }

    /**
     * 导出学生列表列表
     */
    @RequiresPermissions("mall:stu:export")
    @Log(title = "学生列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Students students)
    {
        List<Students> list = studentsService.selectStudentsList(students);
        ExcelUtil<Students> util = new ExcelUtil<Students>(Students.class);
        return util.exportExcel(list, "stu");
    }

    /**
     * 新增学生列表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生列表
     */
    @RequiresPermissions("mall:stu:add")
    @Log(title = "学生列表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Students students)
    {
        return toAjax(studentsService.insertStudents(students));
    }

    /**
     * 修改学生列表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Students students = studentsService.selectStudentsById(id);
        mmap.put("students", students);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生列表
     */
    @RequiresPermissions("mall:stu:edit")
    @Log(title = "学生列表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Students students)
    {
        return toAjax(studentsService.updateStudents(students));
    }

    /**
     * 删除学生列表
     */
    @RequiresPermissions("mall:stu:remove")
    @Log(title = "学生列表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentsService.deleteStudentsByIds(ids));
    }
}
